package Controlador;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;
import Vista.Menu_Principal_Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventario_Controlador {
    private Inventario_Vista inventario;

    public Inventario_Controlador(Inventario_Vista inventario){
        this.inventario = inventario;

// Asignar los eventos de los botones y otros controles
        inventario.getBtnregistrar().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        inventario.getBtnreporte().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    FrInventarios_Vista Reporte_inventario = new FrInventarios_Vista();
                    FrmInventarios_Controlador ReportController = new FrmInventarios_Controlador(Reporte_inventario);
                    Reporte_inventario.setVisible(true);
                    inventario.dispose();
                    // Acción al presionar el botón reporte
                }
        });
        inventario.getBtneliminar().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción al presionar el botón eliminar
                }
        });
        inventario.getBtnvolver().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    Menu_Principal_Vista vent =  new Menu_Principal_Vista();
                    Menu_Principal_Controlador contvent = new Menu_Principal_Controlador(vent);
                    vent.setVisible(true);
                    inventario.dispose();
                    // Acción al presionar el botón volver
                }
        });


    }
}
