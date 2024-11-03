package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utilitario.ConexionBD;
import java.util.ArrayList;

public class inventarioDAO {
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
            listaInvent = new ArrayList<inventario>();
            while(rs.next()){
                objInventario = new inventario();
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setModel(rs.getString("modelo"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setCodigo(rs.getString("codigo"));
                objInventario.setPrecioCosto(rs.getInt("preciocosto"));//Precio entero , esta raro eh.....
                listaInvent.add(objInventario);
            }
            return listaInvent;



        }catch(Exception e) {

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
            return pt.executeUpdate();
        }catch(Exception e) {

        }
        return  estado;

    }
    public int  EliminarProducto(inventario objInventario){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM inventario WHERE codigo=?");
            pt.setString(1, objInventario.getCodigo());
            estado =  pt.executeUpdate();
            cn.close();
            pt.close();
        }catch (Exception e) {
            return estado;
        }

        return estado;
    }
    public int ModificarProducto(inventario objInventario){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("UPDATE inventario SET talla=?, modelo=?, color=?, preciocosto=? WHERE codigo=?");
            pt.setInt(1, objInventario.getTalla());
            pt.setString(2, objInventario.getModel());
            pt.setString(3, objInventario.getColor());
            pt.setInt(4, objInventario.getPrecioCosto());
            pt.setString(5, objInventario.getCodigo());
            estado = pt.executeUpdate();
            cn.close();
            pt.close();
        } catch (Exception e) {
            return estado ;
        }
        return  estado;

    }




}
