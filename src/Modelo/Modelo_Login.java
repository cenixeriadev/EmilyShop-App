package Modelo;

import Controlador.FrmLoginUsuario_Controlador;
import Utilitario.ValidationPassword;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Modelo_Login {
    List<FrmLoginUsuario_Controlador> observers =  new ArrayList<>();
    usuarios user = new usuarios();

    public void addObserver(FrmLoginUsuario_Controlador observer) {

        observers.add(observer);
    }
    public void removeObserver(FrmLoginUsuario_Controlador observer) {
        observers.remove(observer);
    }

    @SuppressWarnings("NonAsciiCharacters")
    public void validarCredenciales(String inputUsername, String inputPassword) {
        try {

            ArrayList<usuarios> usuarios = user.ListarUsuario();
            boolean estado = false;
            String nombre = "";
            if(inputPassword.equals("  Ingrese contraseña") || inputUsername.equals("  Ingrese usuario")){
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos requeridos");
                return;
            }
            for (Modelo.usuarios usuario : usuarios) {
                if (inputUsername.equals(usuario.getNombre_usuario()) && ValidationPassword.verificar(inputPassword , usuario.getContraseña())) {
                    estado = true;
                    nombre = usuario.getNames();
                    break;
                }
            }
            if (estado) {
                notificarObserverExito(nombre);
            } else {
                notificarObserverFallo();

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Fail in connection with database"+ e.getMessage());
        }

    }
    private void notificarObserverExito(String nombre_Usuario) {
        for (FrmLoginUsuario_Controlador observer : observers) {
            observer.loginExitoso(nombre_Usuario);
        }
    }
    private void notificarObserverFallo() {
        for (FrmLoginUsuario_Controlador observer : observers) {
            observer.loginFallido("Usuario o contraseña incorrecta");
        }
    }

}
