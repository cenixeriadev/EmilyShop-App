package Controlador;
import Vista.FrInventarios;
import Vista.interfaz_Inventario;
import Vista.interfaz_Menu_Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Inventario {
    private interfaz_Inventario inventario;

    public Controlador_Inventario(interfaz_Inventario inventario){
        this.inventario = inventario;

// Asignar los eventos de los botones y otros controles
        inventario.getBtnregistrar().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción al presionar el botón volver
                }
        });

        inventario.getBtnreporte().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    FrInventarios Reporte_inventario = new FrInventarios();
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
                    interfaz_Menu_Principal vent =  new interfaz_Menu_Principal();
                    Controlador_Menu_Principal contvent = new Controlador_Menu_Principal(vent);
                    vent.setVisible(true);
                    inventario.dispose();
                    // Acción al presionar el botón volver
                }
        });


    }
}
