/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Objetos.Productos;

/**
 *
 * @author david_alcazar
 */

public class MetodosCarritoBD extends ConexionBD{
    
//    public void actualizarCantidadDisponible(int idProducto, int cantidadComprada) {
//        String query = "CALL actualizar_cantidad_disponible(?, ?)";
//
//        try (Connection conexion = establecerConexion();
//             PreparedStatement stmt = conexion.prepareStatement(query)) {
//            
//            // Establecer los parámetros para la llamada al procedimiento almacenado
//            stmt.setInt(1, idProducto); // Primer parámetro: ID del producto
//            stmt.setInt(2, cantidadComprada); // Segundo parámetro: Cantidad comprada
//
//            // Ejecutar el procedimiento
//            stmt.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace(); // Manejo de errores
//        }
//    }
    public ArrayList<String> obtenerNombresProveedores() {
        ArrayList<String> nombresProvedores = new ArrayList<>();

        try (Connection conexion = establecerConexion();
             Statement statement = conexion.createStatement()) {
            String sql = "SELECT nom_pro FROM proveedores;";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                nombresProvedores.add(resultSet.getString("nom_pro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombresProvedores;
    }
    
public ArrayList<Productos> obtenerInformacionProvedore(String proveedor) {
    ArrayList<Productos> productos = new ArrayList<>();

    try (Connection conexion = establecerConexion();
         PreparedStatement statement = conexion.prepareStatement(
             "SELECT p.id_producto, " +  // Selecciona el id_producto
             "p.nom_prod AS producto, " +
             "prov.nom_pro AS marca, " +
             "p.descrip AS descripcion, " +
             "p.precio AS precio, " +
             "p.cant AS cantidad_disponible " +
             "FROM productos p " +
             "JOIN proveedores prov ON p.id_provee = prov.id_provee " +
             "WHERE prov.nom_pro = ?"
         )) {
        statement.setString(1, proveedor);
        ResultSet resultSet = statement.executeQuery();

        // Iterar sobre los resultados del ResultSet
        while (resultSet.next()) {
            int id_producto = resultSet.getInt("id_producto");  // Obtener el id_producto
            String nom_prod = resultSet.getString("producto");
            String nom_prov = resultSet.getString("marca");
            String descrip = resultSet.getString("descripcion");
            float precio = resultSet.getFloat("precio");
            int cantidad = resultSet.getInt("cantidad_disponible");

            // Crear un nuevo objeto Producto con id_producto y agregarlo a la lista
            Productos producto = new Productos(id_producto, nom_prod, nom_prov, descrip, precio, cantidad);
            productos.add(producto);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }

    return productos;
}


// Método para obtener la cantidad disponible de un producto específico
public int obtenerCantidadDisponible(String nombreProducto) {
    int cantidadDisponible = 0;
    String query = "SELECT cant FROM productos WHERE nom_prod = ?";

    try (Connection conexion = establecerConexion();
         PreparedStatement stmt = conexion.prepareStatement(query)) {
        stmt.setString(1, nombreProducto); // Establecer el nombre del producto en la consulta
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            cantidadDisponible = rs.getInt("cant"); // Obtener la cantidad disponible
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Manejo de errores
    }

    return cantidadDisponible;
}
}
