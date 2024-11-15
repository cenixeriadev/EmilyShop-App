package Modelo;

import Utilitario.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public class usuario {
    private int idusuario;
    private String apellidoynombre;
    private String contraseña;
    private String nombUsuario;
    private String telefono;

    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public void setApellidoynombre(String apellidoynombre) {
        this.apellidoynombre = apellidoynombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombUsuario() {
        return nombUsuario;
    }
    public String getTelefono() {
        return telefono;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public String getNames(){
        return apellidoynombre;
    }

    public String getContraseña() {
        return contraseña;
    }

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
                User.setNombUsuario(rs.getString("nombusuario"));
                User.setTelefono(rs.getString("telefono"));
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
            ps = cn.prepareStatement("INSERT INTO usuario(apellidoynombre , contraseña , nombusuario , telefono) VALUES(?,?,? ,?);");
            ps.setString(1, user.getNames());
            ps.setString(2, user.getContraseña());
            ps.setString(3 , user.getNombUsuario());
            ps.setString(4 , user.getTelefono());
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
            ps = cn.prepareStatement("UPDATE usuario SET apellidoynombre=?, contraseña=? , nombusuario = ? , telefono = ? WHERE idusuario=?");
            ps.setString(1, user.getNames());
            ps.setString(2, user.getContraseña());
            ps.setString(3 , user.getNombUsuario());
            ps.setString(4, user.getTelefono());
            ps.setInt(5, user.getIdusuario());
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
