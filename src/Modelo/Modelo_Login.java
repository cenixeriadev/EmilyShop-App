package Modelo;

import Controlador.FrmLoginUsuario_Controlador;

import java.util.ArrayList;
import java.util.List;
public class Modelo_Login {
    List<FrmLoginUsuario_Controlador> observers =  new ArrayList<>();
    usuarioDAO user = new usuarioDAO();

    public void addObserver(FrmLoginUsuario_Controlador observer) {

        observers.add(observer);
    }
    public void removeObserver(FrmLoginUsuario_Controlador observer) {
        observers.remove(observer);
    }

    @SuppressWarnings("NonAsciiCharacters")
    public void validarCredenciales(String inputUsername , String inputPassword){
        ArrayList<usuario> usuarios = user.ListarUsuario();
        boolean estado = false;
        for (Modelo.usuario usuario : usuarios) {
            estado = inputUsername.equals(usuario.getNames()) && inputPassword.equals(usuario.getContraseña());
        }
        if (estado){
            notificarObserverExito();
        }
        else {
            notificarObserverFallo();

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
