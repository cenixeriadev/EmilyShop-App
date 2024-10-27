package Modelo;

import Controlador.FrmLoginUsuario_Controlador;

import java.util.ArrayList;
import java.util.List;
public class Modelo_Login {
    private List<FrmLoginUsuario_Controlador> observers =  new ArrayList<>();
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
        for(int i = 0; i < usuarios.size(); i++){
            if (inputUsername.equals(usuarios.get(i).getNames()) && inputPassword.equals(usuarios.get(i).getContraseña())){
                estado = true;
            }
            else{
                estado = false;
            }
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
