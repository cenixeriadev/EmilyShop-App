package Controlador;
import Modelo.Modelo_Inventario;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;
import Vista.Menu_Principal_Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventario_Controlador{
    private Inventario_Vista inventario;
    private  FrInventarios_Vista Reporte_inventario = new FrInventarios_Vista();
    public Inventario_Controlador(Inventario_Vista inventario ){
        this.inventario = inventario;
        //this.modelo_inventario = modelo_inventario;


// Asignar los eventos de los botones y otros controles
        inventario.getBtnregistrar().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Modelo_Inventario modelo_inventario =  new Modelo_Inventario(Reporte_inventario);
                modelo_inventario.AgregarProducto(inventario.getGrupotallas(), inventario.getOpcion() , inventario.getTxtcodigo() , inventario.getTxtcolor(), inventario.getTxtprecio());
                //modelo_inventario.CargarDatos();
            }
        });

        inventario.getBtnreporte().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    new FrmInventarios_Controlador(Reporte_inventario);
                    Modelo_Inventario mod = new Modelo_Inventario(Reporte_inventario);
                    mod.CargarDatos();
                    Reporte_inventario.setVisible(true);
                    inventario.dispose();
                    // Acción al presionar el botón reporte
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
