package Controlador;

import Modelo.Modelo_CrearUsuario;
import Modelo.Modelo_Login;
import Vista.LoginVista;
import Vista.RegistroUsuarioVista;

import javax.swing.*;


public class ControladorCrearUsuario {
    RegistroUsuarioVista vista  = new RegistroUsuarioVista();
    public ControladorCrearUsuario(RegistroUsuarioVista vista){
        this.vista = vista;
        Iniciar();
    }
    public void Iniciar() {
        vista.getBtncrear().addActionListener(_ -> {
            if(vista.getTxtcontra().getText().equals("  Ingrese contraseña") || vista.getTxtnombre().getText().equals("  Ingrese Nombre y apellido") || vista.getTxttelefono().getText().equals("   Ingrese Numero de Telefono") || vista.getTxtusuario().getText().equals("  Ingrese usuario")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos requeridos");
            }else{
                Modelo_CrearUsuario modelo = new Modelo_CrearUsuario(vista);
                modelo.RegistrarUsuario();
                LoginVista login = new LoginVista();
                Modelo_Login mod = new Modelo_Login();
                new FrmLoginUsuario_Controlador(login, mod);
                login.setVisible(true);
                vista.dispose();
            }
        });
    }
}
