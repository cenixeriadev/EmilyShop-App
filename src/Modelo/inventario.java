package Modelo;

import Utilitario.ConexionBD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class inventario {
    private int id_inventario;
    private double precio_compra;
    private double precio_venta;
    private int stock;
    private Timestamp fecha_entrada;
    private int talla;
    private String marca;
    private String codigo;
    private String color ;
    private String descripcion;


    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    public void setFecha_entrada(Timestamp fecha_entrada){this.fecha_entrada = fecha_entrada;}
    public void setPrecio_venta(double precio_venta){
        this.precio_venta = precio_venta;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setPrecio_compra(double precio_compra){
        this.precio_compra = precio_compra;
    }
    public void setId_inventario(int id_inventario){this.id_inventario = id_inventario;}
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setColor(String color){
        this.color = color;
    }


    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setTalla(int talla){
        this.talla = talla;
    }

    public Timestamp getFecha_entrada(){return fecha_entrada;}
    public int getStock(){return stock;}
    public double getPrecio_venta(){
        return precio_venta;
    }
    public int getIdInventario(){ return id_inventario;}
    public double getPrecio_compra(){
        return precio_compra;
    }
    public String getMarca(){
        return marca;
    }
    public String getColor(){
        return color;
    }
    public String getCodigo(){return codigo; }
    public int getTalla(){
        return talla; 
    }
    public String getDescripcion(){return descripcion;}

    Connection cn  = null;
    PreparedStatement pt = null;
    ResultSet rs = null ;
    ArrayList<inventario> listaInvent = null;
    inventario objInventario = null;
    public ArrayList<inventario> listarInventario() {
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT * FROM inventario WHERE  estado = ?");
            pt.setString(1, "activo");  // esto es para que solo se muestren los productos activos. Puedes modificarlo según necesites.
            rs = pt.executeQuery();
            listaInvent = new ArrayList<>();
            while(rs.next()){
                objInventario = new inventario();
                objInventario.setId_inventario(rs.getInt("id_inventario"));
                objInventario.setPrecio_venta(rs.getDouble("precio_venta"));
                objInventario.setStock(rs.getInt("stock"));
                objInventario.setDescripcion(rs.getString("descripcion"));
                objInventario.setFecha_entrada(rs.getTimestamp("fecha_entrada"));
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setMarca(rs.getString("marca"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setCodigo(rs.getString("codigo"));
                objInventario.setPrecio_compra(rs.getDouble("precio_compra"));
                listaInvent.add(objInventario);
            }
            rs.close();
            pt.close();
            cn.close();
            return listaInvent;
        }catch(Exception e) {
            System.out.println("Error al listar inventario: " + e.getMessage());
        }
        return listaInvent;
    }
    public int AgregarProducto(inventario objInventario)    {
        int estado  = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("INSERT INTO inventario (codigo,talla,marca,color,precio_compra , precio_venta,stock ,descripcion) VALUES (?,?,?,?,?,?,?,?)");
            pt.setString(1, objInventario.getCodigo());
            pt.setInt(2, objInventario.getTalla());
            pt.setString(3, objInventario.getMarca());
            pt.setString(4, objInventario.getColor());
            pt.setDouble(5, objInventario.getPrecio_compra());
            pt.setDouble(6, objInventario.getPrecio_venta());
            pt.setInt(7, objInventario.getStock());
            pt.setString(8, objInventario.getDescripcion());
            estado =  pt.executeUpdate();
            cn.close();
            pt.close();
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            return estado ;
        }
        return  estado;

    }

    public int EliminarProducto(int id_inventario) {
        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();

            // Actualizar el stock y el estado del producto
            pt = cn.prepareStatement("UPDATE inventario SET stock = ? WHERE id_inventario = ?");
            pt.setInt(1, 0);
            pt.setInt(2, id_inventario);
            estado = pt.executeUpdate();

            pt.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error executing: " + e.getMessage());
            return estado;
        }

        return estado;
    }

    public int ObtenerIdInventario(inventario objInventario){
        int idInventario = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT id_inventario FROM inventario WHERE codigo=? AND talla=? AND marca=? AND color=? AND precio_venta = ?;");

            pt.setString(1, objInventario.getCodigo());
            pt.setInt(2, objInventario.getTalla());
            pt.setString(3, objInventario.getMarca());
            pt.setString(4, objInventario.getColor());
            pt.setDouble(5, objInventario.getPrecio_venta());
            rs = pt.executeQuery();
            if(rs.next()){
                idInventario = rs.getInt("id_inventario");
            }
            rs.close();
            pt.close();
            cn.close();
        }catch(Exception e) {
            System.out.println("Error al obtener id inventario: " + e.getMessage());
        }
        return idInventario;
    }
    public int ModificarProducto(inventario objInventario){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("UPDATE inventario SET talla=?, marca=?, color=?, precio_venta=?  ,codigo = ? ,stock = ?  ,descripcion = ? WHERE id_inventario=?");
            pt.setInt(1, objInventario.getTalla());
            pt.setString(2, objInventario.getMarca());
            pt.setString(3, objInventario.getColor());
            pt.setDouble(4, objInventario.getPrecio_venta());
            pt.setString(5, objInventario.getCodigo());
            pt.setInt(6, objInventario.getStock());
            pt.setString(7 , objInventario.getDescripcion());
            pt.setInt(8,objInventario.getIdInventario());
            estado = pt.executeUpdate();
            cn.close();
            pt.close();
        } catch (Exception e) {
            return estado ;
        }
        return  estado;

    }
    public int getStockDisponible(inventario objInventario){
        int stockD = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT stock FROM inventario WHERE id_inventario = ?;");
            pt.setInt(1, objInventario.getIdInventario());
            rs = pt.executeQuery();
            if(rs.next()){
                stockD = rs.getInt("stock");
            }
            rs.close();
            pt.close();
            cn.close();
            return stockD;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error al obtener stock disponible");
        }
        return stockD;
    }
    public String ObtenerEstado(inventario objInventario){
        String estado = "inactivo";
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT estado FROM inventario WHERE id_inventario=?");
            pt.setInt(1, objInventario.getIdInventario());
            rs = pt.executeQuery();
            if (rs.next()) {
                estado = rs.getString("estado");
            }
            rs.close();
            pt.close();
            cn.close();
        }catch (SQLException e){
            System.out.println("Error al obtener estado: " + e.getMessage());
        }
        return estado;
    }
    public String ObtenerDescripcion(inventario objInventario){
        String descp = "";
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT descripcion FROM inventario WHERE id_inventario=?");
            pt.setInt(1, objInventario.getIdInventario());
            rs = pt.executeQuery();
            if (rs.next()) {
                descp = rs.getString("descripcion");
            }
            rs.close();
            pt.close();
            cn.close();
        }catch (SQLException e){
            System.out.println("Error al obtener estado: " + e.getMessage());
        }
        return descp;
    }
    
}
