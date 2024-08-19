/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CRUD.ProductoDao;
import Modelo.Objetos.Proveedores;
import View.VistaCarrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author david_alcazar
 */
public class ControladorProductos implements ActionListener{
    
    VistaCarrito carrito;
    ProductoDao crudProd;
    Proveedores prov;

    public ControladorProductos(VistaCarrito carrito, ProductoDao crudProd) {
        this.carrito = carrito;
        this.crudProd = crudProd;
        prov = new Proveedores();
        this.carrito.jComboBox2.addActionListener(this);
        inicializarVista();
    }
    
    private void inicializarVista() {
        // Obtener nombres de marcas y añadirlos al JComboBox
        ArrayList<Proveedores> marcass = crudProd.listar();
        for (Proveedores marcas: marcass) {
            carrito.jComboBox2.addItem(marcas.getNombre());
        }
    }
    
    public void mostrarIdsProductosEnComboBox(String nombreMarca) {
    // Limpia el JComboBox antes de agregar nuevos elementos
    carrito.jComboBox4.removeAllItems();

    // Obtener los IDs de los productos asociados a la marca/proveedor
    ArrayList<Integer> idsProductos = crudProd.obtenerIdsProductosPorMarca(nombreMarca);

    // Añadir los IDs al JComboBox
    for (Integer idProducto : idsProductos) {
        carrito.jComboBox4.addItem(String.valueOf(idProducto)); // Añadir el ID como un String
    }
}


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.carrito.jComboBox2 == ae.getSource()){
            ImprimimrProductos();
        }
    }
    
    private void ImprimimrProductos() {
        String marcaSeleccionada = (String) carrito.jComboBox2.getSelectedItem();
        mostrarIdsProductosEnComboBox(marcaSeleccionada);
    }

    
    
    
}
