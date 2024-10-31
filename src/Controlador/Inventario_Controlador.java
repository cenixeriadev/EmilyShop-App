package Controlador;
import Modelo.Modelo_Inventario;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;
import Vista.Menu_Principal_Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventario_Controlador {
    private Inventario_Vista inventario;
    private Modelo_Inventario modelo_inventario;
    private Inventario_Vista mpVista;
    public Inventario_Controlador(Inventario_Vista inventario ,Modelo_Inventario modelo_inventario){
        this.inventario = inventario;
        this.modelo_inventario = modelo_inventario;


// Asignar los eventos de los botones y otros controles
        inventario.getBtnregistrar().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                modelo_inventario.AgregarProducto(inventario.getGrupotallas(), inventario.getOpcion() , inventario.getTxtcodigo() , inventario.getTxtcolor(), inventario.getTxtprecio());

            }
        });

        inventario.getBtnreporte().addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                    FrInventarios_Vista Reporte_inventario = new FrInventarios_Vista();
                    Modelo_Inventario modeloReporte = new Modelo_Inventario(Reporte_inventario);
                    FrmInventarios_Controlador contReporte = new FrmInventarios_Controlador(Reporte_inventario , modeloReporte);

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

    public Inventario_Controlador(Inventario_Vista mpVista) {
        this.mpVista = mpVista;
    }
}
