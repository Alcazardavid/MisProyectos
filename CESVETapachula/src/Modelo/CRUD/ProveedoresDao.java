package Modelo.CRUD;

import Modelo.ConexionBD;
import Modelo.Objetos.Proveedores;
import java.sql.*;
import java.util.ArrayList;

public class ProveedoresDao extends ConexionBD {

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


    public void agregar(Proveedores proveedor) {
        String sql = "insert into proveedores(nom_pro,telefono) values(?,?)";
        try(Connection conexion = establecerConexion();
            PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getTelefono());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void Actualizar(Proveedores proveedor) {
    String sql = "UPDATE proveedores SET nom_pro = ?, telefono = ? WHERE id_provee = ?";

    try (Connection conexion = establecerConexion();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        // Verificar los valores antes de ejecutar la actualización
        System.out.println("Actualizando proveedor con ID: " + proveedor.getId());
        System.out.println("Nuevo nombre: " + proveedor.getNombre());
        System.out.println("Nuevo teléfono: " + proveedor.getTelefono());

        statement.setString(1, proveedor.getNombre());
        statement.setString(2, proveedor.getTelefono());
        statement.setInt(3, proveedor.getId());

        int rowsAffected = statement.executeUpdate();

        // Verificar si la actualización fue exitosa
        if (rowsAffected > 0) {
            System.out.println("Proveedor actualizado exitosamente.");
        } else {
            System.out.println("No se encontró el proveedor para actualizar.");
        }

    } catch (SQLException e) {
        // Manejo de excepciones con detalles
        System.err.println("Error al actualizar el proveedor: " + e.getMessage());
        e.printStackTrace();
    }
}

    public Proveedores EncontrarProveedorPorNombre(String nombre) {
        String sql = "SELECT id_provee, nom_pro, telefono FROM proveedores WHERE nom_pro = ?";
        Proveedores pro = null;

        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, nombre);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Crear el objeto Proveedor con los datos obtenidos
                    pro = new Proveedores();
                    pro.setId(resultSet.getInt("id_provee"));
                    pro.setNombre(resultSet.getString("nom_pro"));
                    pro.setTelefono(resultSet.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pro;
    }

    
    public void delete(int id){
        String sql = "delete from proveedores where id_provee = ?";
        try(Connection conexion = establecerConexion();
            PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ProveedoresDao p = new ProveedoresDao();
        Proveedores proveedor = new Proveedores();
        ArrayList<Proveedores> arrayProveedores = p.listar();
        proveedor.setId(5);proveedor.setNombre("Mampo");proveedor.setTelefono("9393223");
        p.agregar(proveedor);
        for (Proveedores proveedores : arrayProveedores) {
            System.out.println(proveedores.getId() + "  "+ proveedores.getNombre() + " "+ proveedores.getNombre() + " "+ proveedores.getTelefono());
        }
        p.delete(5);
        for (Proveedores proveedores : arrayProveedores) {
            System.out.println(proveedores.getId() + "  "+ proveedores.getNombre() + " "+ proveedores.getNombre() + " "+ proveedores.getTelefono());
        }
    }
}
