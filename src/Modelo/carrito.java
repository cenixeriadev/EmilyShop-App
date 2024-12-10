package Modelo;

import Utilitario.ConexionBD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class carrito {
    private int id_carrito;
    private int id_cliente;
    private int id_inventario;
    private int cantidad ;
    private double precio_unitario;
    private double subtotal;

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public int getId_inventario() {
        return id_inventario;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio_unitario() {
        return precio_unitario;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public int getId_carrito() {
        return id_carrito;
    }
    public int getId_cliente() {
        return id_cliente;
    }




    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<carrito> listaProducto = null;
    carrito objProducto = null;


    public int AgregarProducto(carrito producto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO carrito (id_inventario, id_cliente, cantidad, precio_unitario , subtotal ) VALUES (?,?,?,?,?)");
            ps.setInt(1, producto.getId_inventario());
            ps.setInt(2, producto.getId_cliente());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio_unitario());
            ps.setDouble(5, producto.getSubtotal());
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null  , "Error al agregar producto a carrito");
        }
        return estado;
    }

    public int EliminarProducto(int id_carrito){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM carrito WHERE id_carrito=?");
            ps.setInt(1, id_carrito);
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }
    public int ObtenerID(int id_inventario){
        int IdProducto = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT id_carrito FROM carrito WHERE id_inventario = ?;");
            ps.setInt(1,id_inventario);
            rs = ps.executeQuery();
            if(rs.next()){
                IdProducto = rs.getInt("id_carrito");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch(Exception e) {
            System.out.println("Error al obtener id inventario: " + e.getMessage());
        }
        return IdProducto;
    }
}
