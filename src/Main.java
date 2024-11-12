import Controlador.FrmLoginUsuario_Controlador;
import Modelo.Modelo_Login;
import Vista.FrmLoginUsuario_Vista;
public class Main{

    public static void main(String[] args) {
        Modelo_Login  modelo = new Modelo_Login();
        FrmLoginUsuario_Vista ventana = new FrmLoginUsuario_Vista();
        new FrmLoginUsuario_Controlador(ventana, modelo);
        ventana.setVisible(true);
    }
}

