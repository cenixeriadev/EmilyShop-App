package Modelo;

import Controlador.FrmLoginUsuario_Controlador;

import java.util.ArrayList;
import java.util.List;
public class Modelo_Login {
    private  List<FrmLoginUsuario_Controlador> observers =  new ArrayList<>();
    usuarioDAO user = new usuarioDAO();
    private ArrayList<usuario> usuarios = new ArrayList<>();

    public void addObserver(FrmLoginUsuario_Controlador observer) {

        observers.add(observer);
    }
    public void removeObserver(FrmLoginUsuario_Controlador observer) {
        observers.remove(observer);
    }

    public void validarCredenciales(String inputUsername , String inputPassword){
        usuarios = user.ListarUsuario();
        boolean estado = false;
        for (Modelo.usuario usuario : usuarios) {
            estado = inputUsername.equals(usuario.getNames()) && inputPassword.equals(usuario.getContraseña());
        }
        if (estado){
            notificarObserverExito();


        }
        else {
            notificarObserverFallo("Usuario o contraseña incorrecta");
        }
    }
    private void notificarObserverExito() {
        for (FrmLoginUsuario_Controlador observer : observers) {
            observer.loginExitoso();
        }
    }
    private void notificarObserverFallo(String MensajeError) {
        for (FrmLoginUsuario_Controlador observer : observers) {
            observer.loginFallido(MensajeError);
        }
    }

}
