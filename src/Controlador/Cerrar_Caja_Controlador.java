package Controlador;
import Vista.Cerrar_Caja_Vista;
import Vista.Menu_Principal_Vista; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cerrar_Caja_Controlador {
    private Cerrar_Caja_Vista cierredecajaVista; 
    public Cerrar_Caja_Controlador (Cerrar_Caja_Vista cierredecajaVista){
        this.cierredecajaVista = cierredecajaVista; 
        cierredecajaVista.getbtnvolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_Principal_Vista shesaid = new Menu_Principal_Vista(); 
                Menu_Principal_Controlador konichiwua = new Menu_Principal_Controlador(shesaid); 
                shesaid.setVisible(true);
                cierredecajaVista.dispose();
            }
        });
    } 
}
