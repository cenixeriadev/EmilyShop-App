package Controlador;
import Vista.Cerrar_Caja_Vista;
import Vista.Menu_Principal_Vista; 


public class Cerrar_Caja_Controlador {

    public Cerrar_Caja_Controlador (Cerrar_Caja_Vista cierredecajaVista){

        cierredecajaVista.getbtnvolver().addActionListener(_ -> {
            Menu_Principal_Vista shesaid = new Menu_Principal_Vista();
            new Menu_Principal_Controlador(shesaid);
            shesaid.setVisible(true);
            cierredecajaVista.dispose();
        });
    } 
}
