/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david_alcazar
 */
public class CrudCliente extends ConexionBD{
    
    public boolean verificarCliente(int idCliente) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE id_cliente = ?";

        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idCliente);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Clientes obtenerCliente(int idCliente) {
    String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
    Clientes cliente = null;

    try (Connection conexion = establecerConexion();
         PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, idCliente);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                // Crear el objeto Cliente con los datos obtenidos
                cliente = new Clientes();
                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nomb_cliente"));
                cliente.setEdad(resultSet.getInt("edad_cliente"));
                cliente.setTelefono(resultSet.getString("telefono"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cliente;
}


    // Método para crear un nuevo cliente y obtener el ID generado
public int createCliente(Clientes objClientes) {
    String sql = "INSERT INTO clientes (nomb_cliente, edad_cliente, telefono) VALUES (?, ?, ?) RETURNING id_cliente";
    int idClienteGenerado = -1;

    try (Connection conexion = establecerConexion();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        // Establecer los parámetros
        statement.setString(1, objClientes.getNombre());
        statement.setInt(2, objClientes.getEdad());
        statement.setString(3, objClientes.getTelefono());

        // Ejecutar la inserción y obtener el ID generado
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            idClienteGenerado = resultSet.getInt("id_cliente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return idClienteGenerado;
}
 

    public void Actualizar(Clientes persona) {
        String sql = "update clientes set nomb_cliente = ?, edad_cliente = ?, telefono = ? where id_cliente = ?";
        try(Connection conexion = establecerConexion();
        PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, persona.getNombre());
            statement.setInt(2, persona.getEdad());
            statement.setString(3, persona.getTelefono());
            statement.setInt(4, persona.getId());
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id){
        String sql = "delete from clientes where id_cliente = ?";
        try(Connection conexion = establecerConexion();
            PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
