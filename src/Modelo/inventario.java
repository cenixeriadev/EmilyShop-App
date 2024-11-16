package Modelo;

import Utilitario.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class inventario {
    private int idinventario ;
    private int preciocosto;
    private int talla;
    private String modelo;
    private String codigo;
    private String color ;

    public void setPrecioCosto(int preciocosto){
        this.preciocosto = preciocosto;
    }
    public void setIdinventario(int idinventario){this.idinventario = idinventario;}
    public void setModel(String modelo){
        this.modelo = modelo;
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


    public int getIdInventario(){ return idinventario;}
    public int getPrecioCosto(){
        return preciocosto;
    }
    public String getModel(){
        return modelo;
    }
    public String getColor(){
        return color;
    }
    public String getCodigo(){return codigo; }
    public int getTalla(){
        return talla; 
    }

    Connection cn  = null;
    PreparedStatement pt = null;
    ResultSet rs = null ;
    ArrayList<inventario> listaInvent = null;
    inventario objInventario = null;
    public ArrayList<inventario> listarInventario() {
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT * FROM inventario");
            rs = pt.executeQuery();
            listaInvent = new ArrayList<>();
            while(rs.next()){
                objInventario = new inventario();
                objInventario.setIdinventario(rs.getInt("idinventario"));
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setModel(rs.getString("modelo"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setCodigo(rs.getString("codigo"));
                objInventario.setPrecioCosto(rs.getInt("preciocosto"));//Precio entero , esta raro eh.....
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
            pt = cn.prepareStatement("INSERT INTO inventario (codigo,talla,modelo,color,preciocosto) VALUES (?,?,?,?,?)");
            pt.setString(1, objInventario.getCodigo());
            pt.setInt(2, objInventario.getTalla());
            pt.setString(3, objInventario.getModel());
            pt.setString(4, objInventario.getColor());
            pt.setInt(5, objInventario.getPrecioCosto());
            estado =  pt.executeUpdate();
            cn.close();
            pt.close();
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            return estado ;
        }
        return  estado;

    }
    public int  EliminarProducto(int idinventario){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM inventario WHERE idinventario=?");
            pt.setInt(1, idinventario);
            estado =  pt.executeUpdate();
            cn.close();
            pt.close();
        }catch (Exception e) {
            return estado;
        }

        return estado;
    }
    public int ObtenerIdInventario(inventario objInventario){
        int idInventario = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT idinventario FROM inventario WHERE codigo=? AND talla=? AND modelo=? AND color=?");
            pt.setString(1, objInventario.getCodigo());
            pt.setInt(2, objInventario.getTalla());
            pt.setString(3, objInventario.getModel());
            pt.setString(4, objInventario.getColor());
            rs = pt.executeQuery();
            if(rs.next()){
                idInventario = rs.getInt("idinventario");
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
            pt = cn.prepareStatement("UPDATE inventario SET talla=?, modelo=?, color=?, preciocosto=?  ,codigo = ? WHERE idinventario=?");
            pt.setInt(1, objInventario.getTalla());
            pt.setString(2, objInventario.getModel());
            pt.setString(3, objInventario.getColor());
            pt.setInt(4, objInventario.getPrecioCosto());
            pt.setString(5, objInventario.getCodigo());
            pt.setInt(6,objInventario.getIdInventario());
            estado = pt.executeUpdate();
            cn.close();
            pt.close();
        } catch (Exception e) {
            return estado ;
        }
        return  estado;

    }
    
}
