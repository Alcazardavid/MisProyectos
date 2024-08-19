/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Objetos.Productos;
import java.util.ArrayList;

/**
 *
 * @author david_alcazar
 * LOGICA DEL CARRITO 
 */
public class Carrito {
    
    private ArrayList<Productos> productos;//array de tipo Productos para guardar 
    private float totalCarrito;

    public Carrito() {
        this.productos = new ArrayList<>();
        this.totalCarrito = 0;
    }

    public void agregarProducto(Productos producto) {
        productos.add(producto);
        recalcularTotal();
    }

    public void modificarProducto(int index, int nuevaCantidad, int cantidadDisponible) {
        if (nuevaCantidad <= cantidadDisponible) {
            Productos producto = productos.get(index);
            producto.setCantidad(nuevaCantidad);
            producto.setPrecioTotal(producto.getPrecioUnitario() * nuevaCantidad);
            recalcularTotal();
        } else {
            throw new IllegalArgumentException("Cantidad seleccionada no disponible");
        }
    }
    public void vaciarCarrito() {
        productos.clear(); // Limpia todos los productos en el carrito
    }

    public void eliminarProducto(int index) {
        productos.remove(index);
        recalcularTotal();
    }

    public float obtenerTotalCarrito() {
        return totalCarrito;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    private void recalcularTotal() {
        totalCarrito = 0;
        for (Productos producto : productos) {
            totalCarrito += producto.getPrecioTotal();
        }
    }
   
    
    
}
