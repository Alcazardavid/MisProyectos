/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CRUD.crudVentas;
import Modelo.Objetos.Productos;
import Modelo.Objetos.ventas;
import View.VistaCarrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david_alcazar
 */
public class ControladorReportes implements ActionListener{
    
    VistaCarrito carrito;
    crudVentas Ventas;
    ventas vm;

    public ControladorReportes(VistaCarrito carrito, crudVentas Ventas) {
        this.carrito = carrito;
        this.Ventas = Ventas;
        this.carrito.jButtonQuincenal.addActionListener(this);
        this.carrito.jButtonSemanal.addActionListener(this);
        this.carrito.jButtonMensual.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.carrito.jButtonQuincenal == ae.getSource()){
            System.out.println("quincenal");
            mostrarVentasEnTabla(Ventas.readQuincenal());
        }else if(this.carrito.jButtonSemanal == ae.getSource()){
            System.out.println("semanal");
            mostrarVentasEnTabla(Ventas.readSemanal());
        }else if(this.carrito.jButtonMensual == ae.getSource()){
            System.out.println("mensual");
            mostrarVentasEnTabla(Ventas.readMensual());
        }
    }
    
 private void mostrarVentasEnTabla(ArrayList<ventas> listaVentas) {
        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Venta");
        modeloTabla.addColumn("ID Cliente");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Monto");

        // Llenar la tabla con los datos de las ventas
        for (ventas venta : listaVentas) {
            modeloTabla.addRow(new Object[]{
                venta.getId_venta(),
                venta.getId_cliente(),
                venta.getFecha(),
                venta.getCantProducto(),
                venta.getMonto()
            });
        }

        // Asignar el modelo a la tabla en la vista
        carrito.jTable1.setModel(modeloTabla);
    }
    
}
