package Controlador;
import Vista.FrmLoginUsuario_Vista;
import Modelo.Modelo_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FrmLoginUsuario_Controlador {
    private FrmLoginUsuario_Vista login ;
    private Modelo_Login modelo;
    public FrmLoginUsuario_Controlador(FrmLoginUsuario_Vista login , Modelo_Login modelo){
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
