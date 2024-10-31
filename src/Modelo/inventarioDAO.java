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
            listaInvent = new ArrayList<>();
            while(rs.next()){
                objInventario = new inventario();
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setModel(rs.getString("modelo"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setPrecioCosto(rs.getInt("precio"));//Precio entero , esta raro eh.....
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
            pt = cn.prepareStatement("INSERT INTO inventario (talla,modelo,color,preciocosto) VALUES (?,?,?,?)");
            pt.setInt(1, objInventario.getTalla());
            pt.setString(2, objInventario.getModel());
            pt.setString(3, objInventario.getColor());
            pt.setInt(4, objInventario.getPrecioCosto());
            return pt.executeUpdate();
        }catch(Exception e) {

        }
        return  estado;

    }
    public int  EliminarProducto(inventario objInventario){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM inventario WHERE idinventario=?");
            pt.setInt(1, objInventario.getIdInventario());
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
            pt = cn.prepareStatement("UPDATE inventario SET talla=?, modelo=?, color=?, preciocosto=? WHERE idinventario=?");
            pt.setInt(1, objInventario.getTalla());
            pt.setString(2, objInventario.getModel());
            pt.setString(3, objInventario.getColor());
            pt.setInt(4, objInventario.getPrecioCosto());
            pt.setInt(5, objInventario.getIdInventario());
            estado = pt.executeUpdate();
            cn.close();
            pt.close();
        } catch (Exception e) {
            return  estado ;
        }
        return  estado;

    }




}
