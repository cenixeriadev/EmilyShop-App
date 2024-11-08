package Controlador;
import Modelo.Modelo_Inventario;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;
import Vista.Menu_Principal_Vista;

import javax.swing.*;

public class Inventario_Controlador{
    private final Inventario_Vista inventario;
    private final FrInventarios_Vista Reporte_inventario = new FrInventarios_Vista();
    public Inventario_Controlador(Inventario_Vista inventario ){
        this.inventario = inventario;


// Asignar los eventos de los botones y otros controles
        inventario.getBtnregistrar().addActionListener(_ -> {
            try{
                Modelo_Inventario modelo_inventario =  new Modelo_Inventario(Reporte_inventario);
                modelo_inventario.AgregarProducto(inventario.getGrupotallas(), inventario.getOpcion() , inventario.getTxtcodigo() , inventario.getTxtcolor(), inventario.getTxtprecio());

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null , "Ingrese los valores antes de registrar","" ,  JOptionPane.ERROR_MESSAGE);


            }
        });

        inventario.getBtnreporte().addActionListener(_ -> {
                new FrmInventarios_Controlador(Reporte_inventario);
                Modelo_Inventario mod = new Modelo_Inventario(Reporte_inventario);
                mod.CargarDatos();
                Reporte_inventario.setVisible(true);
                inventario.dispose();
                // Acción al presionar el botón reporte
            });

        inventario.getBtnvolver().addActionListener(_ -> {
                Menu_Principal_Vista vent =  new Menu_Principal_Vista();
                new Menu_Principal_Controlador(vent);
                vent.setVisible(true);
                inventario.dispose();
                // Acción al presionar el botón volver
            });


    }


}
