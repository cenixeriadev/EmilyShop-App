package Controlador;
import Vista.interfaz_FrmLoginUsuario;
import Modelo.Modelo_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controlador_FrmLoginUsuario {
    private interfaz_FrmLoginUsuario login ;
    private Modelo_Login modelo;
    public Controlador_FrmLoginUsuario(interfaz_FrmLoginUsuario login , Modelo_Login modelo){
        this.login = login;
        this.modelo = modelo;
        login.getbtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.dispose();
            }
        });
        login.getbtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.Entrar(login , login.getTxtUsuario() , login.getTxtPassword());

            }
        });


    }

}
