package Controlador;

import Modelo.Modelo_CrearUsuario;
import Modelo.Modelo_GestionarUsuario;
import Utilitario.ValidadorCampos;
import Vista.RegistroUsuarioVista;

import javax.swing.*;


public class ControladorCrearUsuario {
    RegistroUsuarioVista vista  = new RegistroUsuarioVista();
    Modelo_CrearUsuario modelo = new Modelo_CrearUsuario(vista);

    public ControladorCrearUsuario(RegistroUsuarioVista vista , Modelo_CrearUsuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        IniciarEventos();
    }
    public void IniciarEventos() {
        vista.getBtncrear().addActionListener(_ -> {
            if(vista.getTxtcontra().getText().equals("  Ingrese contraseña") || vista.getTxtnombre().getText().equals("  Ingrese Nombre y apellido") || vista.getTxttelefono().getText().equals("   Ingrese Numero de Telefono") || vista.getTxtusuario().getText().equals("  Ingrese usuario")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos requeridos");
            }else {
                if (!ValidadorCampos.validacion(vista.getTxttelefono(), "^9\\d{8}$") || !ValidadorCampos.validacion(vista.getTxtnombre(), "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$")){
                    JOptionPane.showMessageDialog(null, "Debe ingresar campos validos!");

                }
                else{

                    modelo.RegistrarUsuario();
                    vista.dispose();
                }

            }
        });
    }
}
