
package Controlador;

import Modelo.MetodosCarritoBD;
import Modelo.Objetos.Productos;
import Modelo.CRUD.crudVentas;
import Modelo.Objetos.ventas;
import Modelo.Carrito;
import Modelo.Objetos.Productos;
import Modelo.PL.registrarVentas;
import View.VistaCarrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david_alcazar
 */
public class ControladorCarrito implements ActionListener{

    VistaCarrito vcarrito;
    MetodosCarritoBD metodoscarro;
    crudVentas VentaC;
    Carrito carrito;

    public ControladorCarrito(VistaCarrito vcarrito, MetodosCarritoBD metodoscarro) {
        this.vcarrito = vcarrito;
        this.metodoscarro = metodoscarro;
        this.carrito = new Carrito();
        this.vcarrito.BotonAgregar.addActionListener(this);
        this.vcarrito.BotonModificar.addActionListener(this);
        this.vcarrito.BotonEliminar.addActionListener(this);
        this.vcarrito.BotonPagar.addActionListener(this);
        this.vcarrito.jComboBox1.addActionListener(this);

        inicializarVista();
    }
    
    private void inicializarVista() {
        // Obtener nombres de marcas y añadirlos al JComboBox
        ArrayList<String> marcass = metodoscarro.obtenerNombresProveedores();//obtengo las peliculas y se las mando al combox 
        for (String marcas: marcass) {
            vcarrito.jComboBox1.addItem(marcas);
        }
    }
     
     private int obtenerIdCliente() {
        // Suponiendo que obtienes el ID del cliente desde un campo de texto o JLabel en tu vista
        String texto = vcarrito.jLabel1.getText(); // O usa el campo apropiado
        return Integer.parseInt(texto); // Asegúrate de manejar posibles excepciones si el texto no es un número
    }

private void realizarPago() {
    float totalCarrito = carrito.obtenerTotalCarrito();
    System.out.println("Total a pagar: " + totalCarrito);

    // Obtener el ID del cliente desde la vista
    int idCliente = obtenerIdCliente(); // Implementa este método para obtener el ID del cliente

    // Crear instancia del controlador de ventas
    VentaC = new crudVentas();
    registrarVentas regist = new registrarVentas();

    // Iterar sobre los productos en el carrito para crear un objeto ventas para cada uno
    for (Productos producto : carrito.getProductos()) {
        ventas objVentas = new ventas(idCliente, producto.getCantidad(), producto.getPrecioTotal());
        VentaC.create(objVentas);

        int idProducto = producto.getId();
        int cantidad = producto.getCantidad();

        // Registrar el producto en la tabla temporal
        regist.registrarProducto(idProducto, cantidad);

        System.out.println("ID del producto: " + idProducto);
        System.out.println("Cantidad: " + cantidad);
    }

    JOptionPane.showMessageDialog(null, "Pago realizado con éxito");

    carrito.vaciarCarrito();  // Limpiar el carrito después del pago
    actualizarProductos();
    MostrarCarrito();  // Actualizar la vista del carrito
}


    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.vcarrito.BotonAgregar == ae.getSource()) {
            agregarProductoAlCarrito();
            vcarrito.jTextFieldCantidad.setText("");
        } else if (this.vcarrito.jComboBox1 == ae.getSource()) {
            actualizarProductos();
        } else if (this.vcarrito.BotonModificar == ae.getSource()) {
            modificarProductoEnCarrito();
            vcarrito.jTextFieldCantidad.setText("");
        } else if (this.vcarrito.BotonEliminar == ae.getSource()) {
            eliminarProductoDelCarrito();
        }else if(this.vcarrito.BotonPagar == ae.getSource()){
            realizarPago();
            //vcarrito.jTabbedPane1.setSelectedIndex(1);
        }
    }
    
    //METODOS QUE COTONTROLAN LOS PRODUCTOS Y TABLAS 
    
    private void actualizarProductos() {
        String marcaSeleccionada = (String) vcarrito.jComboBox1.getSelectedItem();
        ArrayList<Productos> productos = metodoscarro.obtenerInformacionProvedore(marcaSeleccionada);
        actualizarTabla(productos);
    }
    
    private void actualizarTabla(ArrayList<Productos> productos) {
        String[] columnNames = {"ID", "Producto", "Precio", "Descripcion", "Unidades Disponibles"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (Productos producto : productos) {
            model.addRow(new Object[]{
                producto.getId(),
                producto.getNom_prod(),
                producto.getPrecioTotal(),
                producto.getDescrip(),
                producto.getCantidad()
            });
        }
        vcarrito.jTableProductos.setModel(model);
    }
    
     private void agregarProductoAlCarrito() {
        int fila = vcarrito.jTableProductos.getSelectedRow();
        if (fila != -1) {
            int idp = Integer.parseInt(vcarrito.jTableProductos.getValueAt(fila, 0).toString());
            String nombreProducto = (String) vcarrito.jTableProductos.getValueAt(fila, 1);
            float precioUnitario = Float.parseFloat(vcarrito.jTableProductos.getValueAt(fila, 2).toString());
            int cantidadDisponible = Integer.parseInt(vcarrito.jTableProductos.getValueAt(fila, 4).toString());
            try{
                int cantidadSeleccionada = Integer.parseInt(vcarrito.jTextFieldCantidad.getText());
                
                if (cantidadSeleccionada <= cantidadDisponible) {
                Productos producto = new Productos(idp, nombreProducto, precioUnitario, cantidadSeleccionada);
                carrito.agregarProducto(producto);
                MostrarCarrito();
//                vcarrito.jLabel1.setText("$" + carrito.obtenerTotalCarrito());
                } else {
                    JOptionPane.showMessageDialog(null, "CANTIDAD SELECCIONADA NO DISPONIBLE");
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Por favor ingresa la cantidad :)", "Error en cantidad", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            System.out.println("Nada seleccionado");
        }
    }
     
    private void modificarProductoEnCarrito() {
        int fila = vcarrito.jTableCarrito.getSelectedRow();
        if (fila != -1) {
            try {
                int cantidadNueva = Integer.parseInt(vcarrito.jTextFieldCantidad.getText());
                int cantidadDisponible = metodoscarro.obtenerCantidadDisponible(carrito.getProductos().get(fila).getNom_prod());
                carrito.modificarProducto(fila, cantidadNueva, cantidadDisponible);
                MostrarCarrito();
//                vcarrito.jLabel1.setText("$" + carrito.obtenerTotalCarrito());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            System.out.println("Nada seleccionado");
        }
    }
    private void eliminarProductoDelCarrito() {
        int fila = vcarrito.jTableCarrito.getSelectedRow();
        if (fila != -1) {
            carrito.eliminarProducto(fila);
            MostrarCarrito();
//            vcarrito.jLabel1.setText("$" + carrito.obtenerTotalCarrito());
        } else {
            System.out.println("Nada seleccionado");
        }
    }
     private void MostrarCarrito() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");

        for (Productos producto : carrito.getProductos()) {
            modeloTabla.addRow(new Object[]{
                producto.getNom_prod(),
                producto.getPrecioTotal(),
                producto.getCantidad()
            });
        }
        vcarrito.jTableCarrito.setModel(modeloTabla);
    }
     
}
