package Modelo;

import Vista.gestionUsuarioVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class Modelo_GestionarUsuario {
    gestionUsuarioVista vistagesusuario;
    ArrayList<usuario> listaUsuarios = new ArrayList<>();
    usuario Usuario;
    public Modelo_GestionarUsuario(gestionUsuarioVista vistagesusuario){
        this.vistagesusuario = vistagesusuario;
    }
    public void CargarUsuarios(){
        DefaultTableModel modelo = vistagesusuario.getModeloUsuario();
        int i = 0 ;
        Usuario = new usuario();  // Reemplazar con la clase que gestiona la base de datos de usuarios.
        listaUsuarios = Usuario.ListarUsuario();
        modelo.setNumRows(listaUsuarios.size());
        for(usuario obj : listaUsuarios){
            modelo.setValueAt(String.valueOf(obj.getNames()), i, 0);
            modelo.setValueAt(obj.getTelefono(), i, 1);
            modelo.setValueAt(obj.getNombUsuario(), i, 2);
            modelo.setValueAt(String.valueOf(obj.getContraseña()), i, 3);
            i++;
        }
        vistagesusuario.getTablaUsuario().setModel(modelo);
    }
    public void EliminarUsuario(String nombusuario){
        Usuario = new usuario();
        int resultado = Usuario.EliminarUsuario(nombusuario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
        }
        CargarUsuarios();
    }
    public void ActualizarUsuario(String names, String telefono, String nombusuario, String contraseña , String nomactual){
        Usuario = new usuario();
        int id = 0;
        listaUsuarios = Usuario.ListarUsuario();
        for(usuario u : listaUsuarios){
            if(Objects.equals(u.getNames(), nomactual)){
                id = u.getIdusuario();
            }
        }
        Usuario.setNombUsuario(nombusuario);
        Usuario.setTelefono(telefono);
        Usuario.setApellidoynombre(names);
        Usuario.setIdusuario(id);
        Usuario.setContraseña(contraseña);
        int resultado = Usuario.EditarUsuario(Usuario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
        } else {
            throw new NullPointerException();
        }
        CargarUsuarios();
    }
}
