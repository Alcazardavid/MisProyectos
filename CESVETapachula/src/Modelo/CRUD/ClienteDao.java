package Modelo.CRUD;

import java.sql.*;
import java.util.ArrayList;

import Modelo.ConexionBD;
import Modelo.Objetos.Cliente;

public class ClienteDao extends ConexionBD{

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> datos = new ArrayList<>();
        String sql = "select * from clientes";
        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                Cliente p = new Cliente();
                p.setId(resultSet.getInt(1));
                p.setNombre(resultSet.getString(2));
                p.setEdad(resultSet.getInt(3));
                p.setTelefono(resultSet.getString(4));
                datos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public int agregar(Cliente persona) {
        String sql = "insert into clientes(nomb_cliente,edad_cliente, telefono) values(?,?,?)";
        int filasAfectadas = 0;
        try (Connection conexion = establecerConexion();
            PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setString(1, persona.getNombre());
            statement.setInt(2, persona.getEdad());
            statement.setString(3, persona.getTelefono());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    public void Actualizar(Cliente persona) {
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

    public static void main(String[] args) {
        ClienteDao p = new ClienteDao();
        Cliente persona = new Cliente();
        ArrayList<Cliente> arrayClientes = p.listar();
        persona.setNombre("agregaddo");persona.setEdad(2);persona.setTelefono("9493493934");persona.setId(2);
        p.agregar(persona);
        for (Cliente clientes : arrayClientes) {
            System.out.println(clientes.getEdad()+ " "+ clientes.getId()+ " "+clientes.getNombre()+ " "+ clientes.getTelefono()+ clientes.getClass());
        }
    }
}
