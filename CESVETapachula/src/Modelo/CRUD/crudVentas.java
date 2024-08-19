package Modelo.CRUD;

import Modelo.ConexionBD;
import Modelo.Objetos.ventas;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class crudVentas extends ConexionBD{
    
   public void create(ventas objVentas) {
        String sql = "INSERT INTO ventas(id_cliente,fecha,cant_prod,monto) VALUES (?,CURRENT_DATE, ?, ?)";
        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            
            statement.setInt(1, objVentas.getId_cliente());
            statement.setInt(2, objVentas.getCantProducto());
            statement.setFloat(3, objVentas.getMonto());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ventas> read() {
        ArrayList<ventas> arrayVentas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ventas Ventas = new ventas();
                Ventas.setId_venta(resultSet.getInt(1));
                Ventas.setId_cliente(resultSet.getInt(2));
                Ventas.setFecha(resultSet.getString(3));
                Ventas.setCantProducto(resultSet.getInt(4));
                Ventas.setMonto(resultSet.getFloat(5));
                arrayVentas.add(Ventas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayVentas;
    }
    
    public ArrayList<ventas> readSemanal(){
        ArrayList<ventas> arraySemanal = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE fecha >= CURRENT_DATE - INTERVAL '7 days'";
        try(Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                ventas objVentas = new ventas();
                objVentas.setId_venta(resultSet.getInt(1));
                objVentas.setId_cliente(resultSet.getInt(2));
                objVentas.setFecha(resultSet.getString(3));
                objVentas.setCantProducto(resultSet.getInt(4));
                objVentas.setMonto(resultSet.getFloat(5));
                arraySemanal.add(objVentas);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return arraySemanal;
    }
    public ArrayList<ventas> readQuincenal(){
        ArrayList<ventas> arraySemanal = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE fecha >= CURRENT_DATE - INTERVAL '15 days'";
        try(Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                ventas objVentas = new ventas();
                objVentas.setId_venta(resultSet.getInt(1));
                objVentas.setId_cliente(resultSet.getInt(2));
                objVentas.setFecha(resultSet.getString(3));
                objVentas.setCantProducto(resultSet.getInt(4));
                objVentas.setMonto(resultSet.getFloat(5));
                arraySemanal.add(objVentas);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return arraySemanal;
    }
    public ArrayList<ventas> readMensual(){
        ArrayList<ventas> arraySemanal = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE fecha >= CURRENT_DATE - INTERVAL '30 days'";
        try(Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                ventas objVentas = new ventas();
                objVentas.setId_venta(resultSet.getInt(1));
                objVentas.setId_cliente(resultSet.getInt(2));
                objVentas.setFecha(resultSet.getString(3));
                objVentas.setCantProducto(resultSet.getInt(4));
                objVentas.setMonto(resultSet.getFloat(5));
                arraySemanal.add(objVentas);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return arraySemanal;
    }

    public void update(ventas objVentas) {
        String sql = "UPDATE ventas SET cant_prod = ?, monto = ? WHERE id_venta = ?";
        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1,objVentas.getCantProducto());
            statement.setFloat(2, objVentas.getMonto());
            statement.setInt(3, objVentas.getId_venta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ventas objVentas) {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        try (Connection conexion = establecerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, objVentas.getId_venta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}