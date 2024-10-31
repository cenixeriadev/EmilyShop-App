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
                objInventario.setTalla(rs.getString("talla"));
                objInventario.setModel(rs.getString("modelo"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setPrecioCosto(rs.getDouble("precio"));
                listaInvent.add(objInventario);
            }
            return listaInvent;



        }catch(Exception e) {

        }

    }
    public int AgregarProducto(inventario objInventario)    {


    }




}
