package Controlador;

import Modelo.Modelo_CrearUsuario;
import Modelo.Modelo_Login;
import Utilitario.ValidadorCampos;
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
            }else {
                if (!ValidadorCampos.validacion(vista.getTxttelefono(), "^9\\d{8}$") || !ValidadorCampos.validacion(vista.getTxtnombre(), "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$")){
                    JOptionPane.showMessageDialog(null, "Debe ingresar campos validos!");

                }
                else{
                    Modelo_CrearUsuario modelo = new Modelo_CrearUsuario(vista);
                    modelo.RegistrarUsuario();
                    LoginVista login = new LoginVista();
                    Modelo_Login mod = new Modelo_Login();
                    new FrmLoginUsuario_Controlador(login, mod);
                    login.setVisible(true);
                    vista.dispose();
                }

            }
        });
        vista.getBtnvolver().addActionListener(_->{
            LoginVista login = new LoginVista();
            Modelo_Login mod = new Modelo_Login();
            new FrmLoginUsuario_Controlador(login, mod);
            login.setVisible(true);
            vista.dispose();
        });
    }
}
