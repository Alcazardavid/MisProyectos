/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CRUD.ProveedoresDao;
import Modelo.Objetos.Proveedores;
import View.VistaCarrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author david_alcazar
 * clase encargada de controlar todo del panel de proveedores 
 */
public class ControladorProveedores implements ActionListener{
    
    
    VistaCarrito carrito;
    Proveedores proveer;
    ProveedoresDao crudPro;

    public ControladorProveedores(VistaCarrito carrito, ProveedoresDao crudPro) {
        this.carrito = carrito;
        this.crudPro = crudPro;
        proveer = new Proveedores();
        this.carrito.jButtonGuardar.addActionListener(this);
        this.carrito.jButtonActualizar.addActionListener(this);
        this .carrito.jButtonEliminar.addActionListener(this);
        this.carrito.jButtonCrear.addActionListener(this);
        this.carrito.jComboBox3.addActionListener(this);
        inicializarVista();
    }
    
        private void inicializarVista() {
        // Obtener nombres de marcas y añadirlos al JComboBox
        ArrayList<Proveedores> marcass = crudPro.listar();//obtengo las peliculas y se las mando al combox 
        for (Proveedores marcas: marcass) {
            carrito.jComboBox3.addItem(marcas.getNombre());
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.carrito.jButtonGuardar == ae.getSource()){
            crear();
        }else if(this.carrito.jButtonActualizar == ae.getSource()){
            actualizar();
        }else if(this.carrito.jButtonEliminar == ae.getSource()){
            eliminar();
        }else if(this.carrito.jComboBox3 == ae.getSource()){
            ImprimimrProductos();
        }
    }
    
     private void crear() {
        String nom = carrito.jTextIdProducto.getText();
        String tele = carrito.jTextCantidad.getText();
        proveer = new Proveedores(nom, tele);
        crudPro.agregar(proveer);
        
        // Actualizar el JComboBox con el nuevo proveedor
        carrito.jComboBox3.addItem(proveer.getNombre());
        carrito.jTextField1nom.setText("");
        carrito.jTextField2tele.setText("");
        
        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Proveedor creado exitosamente.");
    }
     
    private void eliminar() {
        String proveedorSeleccionado = (String) carrito.jComboBox3.getSelectedItem();
        if (proveedorSeleccionado != null) {
            Proveedores proveedorAEliminar = crudPro.EncontrarProveedorPorNombre(proveedorSeleccionado);
            if (proveedorAEliminar != null) {
                crudPro.delete(proveedorAEliminar.getId());

                // Actualizar el JComboBox para reflejar la eliminación
                carrito.jComboBox3.removeItem(proveedorSeleccionado);

                // Mostrar un mensaje de confirmación
                JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor para eliminar.");
        }
    }

    
private void actualizar() {
    String nombreActual = (String) carrito.jComboBox3.getSelectedItem();
    if (nombreActual != null) {
        Proveedores proveedorExistente = crudPro.EncontrarProveedorPorNombre(nombreActual);
        if (proveedorExistente != null) {
            String nuevoNombre = carrito.jTextIdProducto.getText();
            String nuevoTelefono = carrito.jTextCantidad.getText();

            // Crear un nuevo objeto Proveedores con los datos actualizados
            proveer = new Proveedores(proveedorExistente.getId(), nuevoNombre, nuevoTelefono);
            crudPro.Actualizar(proveer);

            // Actualizar el JComboBox
            carrito.jComboBox3.removeItem(nombreActual); // Remover el antiguo nombre
            carrito.jComboBox3.addItem(nuevoNombre); // Agregar el nuevo nombre

            // Seleccionar el nuevo nombre en el JComboBox
            carrito.jComboBox3.setSelectedItem(nuevoNombre);

            // Mostrar un mensaje de confirmación
            JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor para actualizar.");
    }
}

   private void ImprimimrProductos() {
        String marcaSeleccionada = (String) carrito.jComboBox3.getSelectedItem();
        proveer = crudPro.EncontrarProveedorPorNombre(marcaSeleccionada);
        carrito.jTextIdProducto.setText(proveer.getNombre());
        carrito.jTextCantidad.setText(proveer.getTelefono());
        System.out.println("id :"+proveer.getId());
    }
    
}
