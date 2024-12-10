package Modelo;

import Utilitario.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Modelo_Reportes {
    Connection cn  = null;
    PreparedStatement pt = null;
    ResultSet rs = null ;

    public int TotalProductos(){
        int total = 0;
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT COUNT(id_inventario) FROM inventario WHERE estado = ?;");
            pt.setString(1, "activo");
            rs = pt.executeQuery();
            if(rs.next()){
                total =  rs.getInt(1);
            }
            return total;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener total de productos");
        }
        return total;
    }

}
