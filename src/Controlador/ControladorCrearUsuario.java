package Controlador;

import Modelo.Modelo_CrearUsuario;
import Modelo.Modelo_Login;
import Vista.LoginVista;
import Vista.RegistroUsuarioVista;


public class ControladorCrearUsuario {
    RegistroUsuarioVista vista  = new RegistroUsuarioVista();
    public ControladorCrearUsuario(RegistroUsuarioVista vista){
        this.vista = vista;
        Iniciar();
    }
    public void Iniciar() {
        vista.getBtncrear().addActionListener(_ -> {
            Modelo_CrearUsuario modelo = new Modelo_CrearUsuario(vista);
            modelo.RegistrarUsuario();
            LoginVista login = new LoginVista();
            Modelo_Login mod = new Modelo_Login();
            new FrmLoginUsuario_Controlador(login , mod);
            login.setVisible(true);
            vista.dispose();
        });
    }
}
