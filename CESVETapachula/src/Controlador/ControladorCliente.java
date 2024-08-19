/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clientes;
import Modelo.CrudCliente;
import View.VistaCarrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author david_alcazar
 */
public class ControladorCliente implements ActionListener{

    VistaCarrito carrito;
    CrudCliente crudClie;
    Clientes cliente;
    int idCliente;
    

    public ControladorCliente(VistaCarrito carrito, CrudCliente crudClie) {
        this.carrito = carrito;
        this.crudClie = crudClie;
        this.carrito.jButtoGuardar.addActionListener(this);
        this.carrito.jButtonEli.addActionListener(this);
        this.carrito.jButtonActu.addActionListener(this);
        this.carrito.jButtonBuscar.addActionListener(this);
        this.carrito.jButton1.addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.carrito.jButtoGuardar == ae.getSource()){
            GuardarCliente();
        }else if(this.carrito.jButtonEli == ae.getSource()){
            eliminarCliente();
        }else if(this.carrito.jButtonActu == ae.getSource()){
            actualizarCliente();
        }else if(this.carrito.jButtonBuscar == ae.getSource()){
            Verificar();
        }else if(this.carrito.jButton1 == ae.getSource()){
            mostrar();
        }
    }
    
    public void mostrar(){
        carrito.jTabbedPane1.setSelectedIndex(1);
        idCliente = Integer.parseInt(carrito.jTextIdCliente.getText());
        carrito.jLabel1.setText(""+idCliente);
    }
    
    public void Verificar(){
        idCliente = Integer.parseInt(carrito.jTextIngresar.getText());
        boolean Bandera = crudClie.verificarCliente(idCliente);
        if(Bandera){
            cliente = crudClie.obtenerCliente(idCliente);
            carrito.jTextIdCliente.setText(String.valueOf(cliente.getId()));
            carrito.jTextNombre.setText(cliente.getNombre());
            carrito.jTextEdad.setText(String.valueOf(cliente.getEdad()));
            carrito.jTextTele.setText(cliente.getTelefono());
        }else{
            JOptionPane.showMessageDialog(null, "ID NO ENCONTRADO ");
        }
    }
    
    private void GuardarCliente(){
        String name = carrito.jTextNombre.getText();
        int edad = Integer.parseInt(carrito.jTextEdad.getText());
        String tel = carrito.jTextTele.getText();
        cliente = new Clientes(name, edad, tel);
        idCliente = crudClie.createCliente(cliente);
        carrito.jTextIdCliente.setText(String.valueOf(idCliente));   
        JOptionPane.showMessageDialog(null, "Cliente guardado con éxito.");
    }
    
    public void actualizarCliente() {
        idCliente = Integer.parseInt(carrito.jTextIdCliente.getText());
        String nombre = carrito.jTextNombre.getText();
        int edad = Integer.parseInt(carrito.jTextEdad.getText());
        String telefono = carrito.jTextTele.getText();
        cliente = new Clientes(idCliente, nombre, edad, telefono);
        crudClie.Actualizar(cliente);
        carrito.jTextNombre.setText("");
        carrito.jTextEdad.setText("");
        carrito.jTextTele.setText("");
        carrito.jTextIngresar.setText("");
        JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito.");
    }
    
    private void eliminarCliente() {
        idCliente = Integer.parseInt(carrito.jTextIngresar.getText());
        crudClie.delete(idCliente);
        carrito.jTextNombre.setText("");
        carrito.jTextEdad.setText("");
        carrito.jTextTele.setText("");
        carrito.jTextIngresar.setText("");
        JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");        
    }

}
