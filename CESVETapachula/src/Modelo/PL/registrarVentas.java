/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.PL;

import Modelo.Carrito;
import Modelo.ConexionBD;
import Modelo.Objetos.Cliente;
import Modelo.Objetos.Productos;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author shegberg
 */
public class registrarVentas extends ConexionBD{
//    
//    public void registro(Cliente cliente){
//        Carrito productos = new Carrito();
//        ArrayList<Productos> productosArray = productos.getProductos();
//        String sql = "CREATE TEMP TABLE temp_productos (id_producto INTEGER,cantidad INTEGER);";
//        try(Connection conexion = establecerConexion();
//              CallableStatement statement = conexion.prepareCall(sql);){
//            statement.execute();
//            for(Productos carrito: productosArray){
//                sql = "INSERT INTO temp_productos (id_producto, cantidad) VALUES ("+carrito.getId()+","+carrito.getNom_prod()+")";
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public void registrarProducto(int idProducto, int cantidad) {
        String insertSQL = "INSERT INTO temp_productos (id_producto, cantidad) VALUES (?, ?)";

        try (Connection conexion = establecerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(insertSQL)) {

            // Insertar el producto en la tabla temporal
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, cantidad);
            int rowsAffected = pstmt.executeUpdate(); // Ejecutar la inserción
            System.out.println("Filas afectadas por el INSERT: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Error en la operación SQL: " + e.getMessage());
        }
    }

}
