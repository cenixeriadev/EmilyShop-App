package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Menu_Principal {
    private Vista.interfaz_Menu_Principal menu ;
    public Controlador_Menu_Principal(Vista.interfaz_Menu_Principal menu){

        this.menu = menu;
        //Asignar los eventos de los botones
        menu.getVentasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vista.interfaz_Ventas ventas  = new Vista.interfaz_Ventas();
                Controlador_Ventas control = new Controlador_Ventas(ventas);
                ventas.setVisible(true);
                menu.dispose();
            }
        });
        menu.getInventarioButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vista.interfaz_Inventario inventario  = new Vista.interfaz_Inventario();
                Controlador_Inventario control = new Controlador_Inventario(inventario);
                inventario.setVisible(true);
                menu.dispose();
            }
        });
        menu.getEliminarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vista.Eliminar_Venta deleteventa =  new Vista.Eliminar_Venta();
                deleteventa.setVisible(true);
                menu.dispose();
            }
        });


    }

}
