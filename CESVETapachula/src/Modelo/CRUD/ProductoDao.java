/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.ConexionBD;
import Modelo.Objetos.Productos;
import Modelo.Objetos.Proveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author david_alcazar
 */
public class ProductoDao extends ConexionBD {
    
    public ArrayList<Proveedores> listar() {
        ArrayList<Proveedores> datos = new ArrayList<>();
        String sql = "select * from proveedores";
        try(Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Proveedores p = new Proveedores();
                p.setId(resultSet.getInt(1));
                p.setNombre(resultSet.getString(2));
                p.setTelefono(resultSet.getString(3));
                datos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }
    public ArrayList<Integer> obtenerIdsProductosPorMarca(String nombreMarca) {
        ArrayList<Integer> idsProductos = new ArrayList<>();
        String sql = "SELECT id_producto FROM productos WHERE id_provee = (SELECT id_provee FROM proveedores WHERE nom_pro = ?)";

        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, nombreMarca);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                idsProductos.add(resultSet.getInt("id_producto"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idsProductos;
    }
    
    public Productos obtenerProductoPorId(int idProducto) {
    Productos producto = null;
    String sql = "SELECT * FROM productos WHERE id_producto = ?";

    try (Connection conexion = establecerConexion();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setInt(1, idProducto);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id_producto");
            String nombre = resultSet.getString("nom_prod");
            int idProvee = resultSet.getInt("id_provee");
            int idCategoria = resultSet.getInt("id_categoria");
            String descripcion = resultSet.getString("descrip");
            float precio = resultSet.getFloat("precio");
            int cantidad = resultSet.getInt("cant");

            producto = new Productos(id, nombre, idProvee, idCategoria, descripcion, cantidad, precio);
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return producto;
}



    
}
