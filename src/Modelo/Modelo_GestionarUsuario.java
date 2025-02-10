package Modelo;

import Vista.gestionUsuarioVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Modelo_GestionarUsuario {
    gestionUsuarioVista vistagesusuario;
    ArrayList<usuarios> listaUsuarios = new ArrayList<>();
    usuarios Usuario;
    public Modelo_GestionarUsuario(gestionUsuarioVista vistagesusuario){
        this.vistagesusuario = vistagesusuario;
    }
    public void CargarUsuarios(){
        DefaultTableModel modelo = vistagesusuario.getModeloUsuario();
        modelo.setRowCount(0);
        Usuario = new usuarios();
        listaUsuarios = Usuario.ListarUsuario();
        for(usuarios obj : listaUsuarios){
            Object[] fila={
                    String.valueOf(obj.getNames()),
                    obj.getTelefono(),
                    obj.getNombre_usuario()
            };
            modelo.addRow(fila);
        }
        vistagesusuario.getTablaUsuario().setModel(modelo);
    }
    public void EliminarUsuario(int idusuario){
        Usuario = new usuarios();
        int resultado = Usuario.EliminarUsuario(idusuario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
        }
        CargarUsuarios();
    }
    public void ActualizarUsuario(String names, String telefono, String nombusuario , int id){
        Usuario = new usuarios();
        Usuario.setNombre_usuario(nombusuario);
        Usuario.setTelefono(telefono);
        Usuario.setNombre(names);
        Usuario.setId_usuario(id);
        int resultado = Usuario.EditarUsuario(Usuario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
        } else {
            throw new NullPointerException();
        }
        CargarUsuarios();
    }
}
