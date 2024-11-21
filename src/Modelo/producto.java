package Modelo;

import Utilitario.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class producto {
    private int idproducto ;
    private int idinventario;
    private String modelo;
    private String codigo;
    private String color ;
    private int talla;

    public void setIdProducto(int idproducto) {
        this.idproducto = idproducto;
    }
    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }
    public void setModel(String modelo) {
        this.modelo = modelo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getIdProducto() {
        return idproducto;
    }
    public int getIdinventario() {
        return idinventario;
    }
    public String getModel() {
        return modelo;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getColor() {
        return color;
    }
    public int getTalla() {
        return talla;
    }



    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<producto> listaProducto = null;
    producto objProducto = null;



    public ArrayList<producto> listarProductos(){
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM producto");
            rs = ps.executeQuery();
            listaProducto = new ArrayList<>();
            while(rs.next()){
                objProducto = new producto();
                objProducto.setIdProducto(rs.getInt("idproducto"));
                objProducto.setIdinventario(rs.getInt("idInventario"));
                objProducto.setModel(rs.getString("modelo"));
                objProducto.setColor(rs.getString("color"));
                objProducto.setCodigo(rs.getString("codigo"));
                objProducto.setTalla(rs.getInt("talla"));

                listaProducto.add(objProducto);
            }
            return listaProducto;
        }catch(Exception e){
            System.out.println("Error al listar productos: " + e.getMessage());
            return null;
        }
    }
    public int ObtenerIdProducto(int idinventario){
        int id;
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT idproducto FROM producto where idinventario = ?;");
            ps.setInt(1, idinventario);
            rs = ps.executeQuery();
            // Mueve el cursor a la primera fila de resultados
            rs.next();
            // Ahora es seguro leer el valor de "idproducto"
            id = rs.getInt("idproducto");
            cn.close();
            ps.close();
            return id;
        } catch(SQLException e) {
            System.out.println("Error al obtener id producto: " + e.getMessage());
            return 0;
        }
    }
    public int AgregarProducto(producto producto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO producto (idinventario, modelo, color, codigo, talla ) VALUES (?,?,?,?,?)");
            ps.setInt(1, producto.getIdinventario());
            ps.setString(2, producto.getModel());
            ps.setString(3, producto.getColor());
            ps.setString(4, producto.getCodigo());
            ps.setInt(5, producto.getTalla());
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }
    public int ModificarProducto(producto producto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE producto SET idinventario=?, modelo=?, color=?, codigo=?, talla=? WHERE idproducto=?");
            ps.setInt(1, producto.getIdinventario());
            ps.setString(2, producto.getModel());
            ps.setString(3, producto.getColor());
            ps.setString(4, producto.getCodigo());
            ps.setInt(5, producto.getTalla());
            ps.setInt(6, producto.getIdProducto());
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }
    public int EliminarProducto(int idProducto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM producto WHERE idproducto=?");
            ps.setInt(1, idProducto);
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }

}
