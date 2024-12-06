package Modelo;

import Controlador.FrmLoginUsuario_Controlador;
import Utilitario.ValidationPassword;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Modelo_Login {
    List<FrmLoginUsuario_Controlador> observers =  new ArrayList<>();
    usuario user = new usuario();

    public void addObserver(FrmLoginUsuario_Controlador observer) {

        observers.add(observer);
    }
    public void removeObserver(FrmLoginUsuario_Controlador observer) {
        observers.remove(observer);
    }

    @SuppressWarnings("NonAsciiCharacters")
    public void validarCredenciales(String inputUsername, String inputPassword) {
        try {

            ArrayList<usuario> usuarios = user.ListarUsuario();
            boolean estado = false;
            for (usuario usuario : usuarios) {
                if (inputUsername.equals(usuario.getNombre_usuario()) && ValidationPassword.verificar(inputPassword , usuario.getContraseña())) {
                    estado = true;
                    break; // Salir del bucle tan pronto como se encuentre una coincidencia
                }
            }
            if (estado) {
                notificarObserverExito();
            } else {
                notificarObserverFallo();

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Fail in connection with database"+ e.getMessage());
        }

    }
    private void notificarObserverExito() {
        for (FrmLoginUsuario_Controlador observer : observers) {
            observer.loginExitoso();
        }
    }
    private void notificarObserverFallo() {
        for (FrmLoginUsuario_Controlador observer : observers) {
            observer.loginFallido("Usuario o contraseña incorrecta");
        }
    }

}
