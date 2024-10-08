import Controlador.Controlador_FrmLoginUsuario;
import Modelo.Modelo_Login;
import Vista.interfaz_FrmLoginUsuario;
public class Main{

    public static void main(String[] args) {
        Modelo_Login  modelo = new Modelo_Login();
        interfaz_FrmLoginUsuario ventana = new interfaz_FrmLoginUsuario();
        Controlador_FrmLoginUsuario controlador = new Controlador_FrmLoginUsuario(ventana, modelo);
        ventana.setVisible(true);
    }


}

