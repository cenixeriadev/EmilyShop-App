package Modelo;

import Vista.RegistroUsuarioVista;

public class Modelo_CrearUsuario {
    RegistroUsuarioVista registroVista;
    usuario  Usuario ;
    public Modelo_CrearUsuario(RegistroUsuarioVista registrovista){
        this.registroVista = registrovista;
    }
    public void RegistrarUsuario(){
        String nombre = registroVista.getTxtnombre().getText();
        String usuario = registroVista.getTxtusuario().getText();
        String password = registroVista.getTxtcontra().getText();
        String telefono = registroVista.getTxttelefono().getText();
        Usuario = new usuario();
        Usuario.setApellidoynombre(usuario);
        Usuario.setNombUsuario(nombre);
        Usuario.setContraseña(password);
        Usuario.setTelefono(telefono);
        Usuario.AgregarUsuario(Usuario);

    }

}
