package Modelo;
import java.sql.*;
import Utilitario.ConexionBD;
import java.util.ArrayList;


public class usuarioDAO {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<usuario> listaUsuario = null;
    usuario User = null;
    public ArrayList<usuario> ListarUsuario(){

        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM usuario");
            rs = ps.executeQuery();
            listaUsuario = new ArrayList<>();
            while(rs.next()){
                User = new usuario();
                User.setIdusuario(rs.getInt("idusuario"));
                User.setApellidoynombre(rs.getString("apellidoynombre"));
                User.setContraseña(rs.getString("contraseña"));
                listaUsuario.add(User);
            }
            rs.close();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            System.out.println("Error al listar los usuarios: " + e.getMessage());
            return null;
        }
        return listaUsuario;
    }
    public int AgregarUsuario(usuario user){
        int res = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO usuario(apellidoynombre , contraseña) VALUES(?,?)");
            ps.setString(1, user.getNames());
            ps.setString(2, user.getContraseña());
            res = ps.executeUpdate();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            System.out.println("Error al agregar el usuario: " + e.getMessage());
        }
        return res;
    }
    public int EditarUsuario(usuario user){
        int res = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE usuario SET apellidoynombre=?, contraseña=? WHERE idusuario=?");
            ps.setString(1, user.getNames());
            ps.setString(2, user.getContraseña());
            ps.setInt(3, user.getIdusuario());
            res = ps.executeUpdate();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            return  res;
        }
        return res;
    }
    public int EliminarUsuario(usuario user){
        int res = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM usuario WHERE idusuario=?");
            ps.setInt(1, user.getIdusuario());
            res = ps.executeUpdate();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            return res;
        }
        return res;
    }




}
