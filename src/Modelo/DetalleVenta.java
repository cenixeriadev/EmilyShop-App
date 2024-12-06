package Modelo;

import Utilitario.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetalleVenta {
    private int id_detalle_venta;
    private int id_venta;
    private int id_inventario;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }
    public int getId_venta() {
        return id_venta;
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
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<DetalleVenta> listaVentas = null;
    DetalleVenta objVenta = null;

    public ArrayList<DetalleVenta> listarProductos(){
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM carrito");
            rs = ps.executeQuery();
            listaVentas = new ArrayList<>();
            while(rs.next()){
                objVenta = new DetalleVenta();
                objVenta.setId_detalle_venta(rs.getInt("id_detalle_venta"));
                objVenta.setId_venta(rs.getInt("id_venta"));
                objVenta.setCantidad(rs.getInt("cantidad"));
                objVenta.setSubtotal(rs.getDouble("subtotal"));
                objVenta.setPrecio_unitario(rs.getDouble("precio_unitario"));
                listaVentas.add(objVenta);
            }
            return listaVentas;
        }catch(Exception e){
            System.out.println("Error al listar productos: " + e.getMessage());
            return null;
        }
    }


}
