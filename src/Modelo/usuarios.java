package Modelo;

import Utilitario.ConexionBD;
import Utilitario.ValidationPassword;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public class usuarios {
    private int id_usuario;
    private String nombre;
    private String password;
    private String nombre_usuario;
    private String telefono;

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String password) {
        this.password = password;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public String getTelefono() {
        return telefono;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public String getNames(){
        return nombre;
    }

    public String getContraseña() {
        return password;
    }

    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<usuarios> listaUsuario = null;
    usuarios User = null;
    public int ObtenerIdUsuario (usuarios Usuario){
        int id= 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT id_usuario FROM usuarios WHERE nombre_usuario = ?   AND nombre = ? AND telefono = ?;");
            ps.setString(1, Usuario.getNombre_usuario());
            ps.setString(2 , Usuario.getNames());
            ps.setString(3, Usuario.getTelefono());
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt("id_usuario");
            }
            ps.close();
            cn.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null , "Error en obtener ID usuario");
        }
        return id;
    }
    public ArrayList<usuarios> ListarUsuario(){

        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM usuarios");
            rs = ps.executeQuery();
            listaUsuario = new ArrayList<>();
            while(rs.next()){
                User = new usuarios();
                User.setId_usuario(rs.getInt("id_usuario"));
                User.setNombre(rs.getString("nombre"));
                User.setContraseña(rs.getString("password"));
                User.setNombre_usuario(rs.getString("nombre_usuario"));
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
    public int AgregarUsuario(usuarios user){
        int res = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO usuarios(nombre , password , nombre_usuario , telefono) VALUES(?,?,? ,?);");
            String hashContraseña = ValidationPassword.encriptar(user.getContraseña());
            ps.setString(1, user.getNames());
            ps.setString(2, hashContraseña);
            ps.setString(3 , user.getNombre_usuario());
            ps.setString(4 , user.getTelefono());
            res = ps.executeUpdate();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            System.out.println("Error al agregar el usuario: " + e.getMessage());
        }
        return res;
    }
    public int EditarUsuario(usuarios user){
        int res = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE usuarios SET nombre=? , nombre_usuario = ? , telefono = ? WHERE id_usuario=?");
            ps.setString(1, user.getNames());
            ps.setString(2 , user.getNombre_usuario());
            ps.setString(3, user.getTelefono());
            ps.setInt(4, user.getId_usuario());
            res = ps.executeUpdate();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return  res;
        }
        return res;
    }
    public int EliminarUsuario(int id){
        int res = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM usuarios WHERE id_usuario=?");
            ps.setInt(1,id );
            res = ps.executeUpdate();
            ps.close();
            cn.close();
        }catch(SQLException e) {
            return res;
        }
        return res;
    }


}
