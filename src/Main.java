import Controlador.FrmLoginUsuario_Controlador;
import Modelo.Modelo_Login;
import Vista.LoginVista;

public class Main{

    public static void main(String[] args) {
        Modelo_Login  modelo = new Modelo_Login();
        LoginVista ventana = new LoginVista();
        new FrmLoginUsuario_Controlador(ventana, modelo);
        ventana.setVisible(true);
    }
}

