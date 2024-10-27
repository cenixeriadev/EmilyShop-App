package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Principal_Controlador {
    private Menu_Principal_Vista menu ;
    public Menu_Principal_Controlador(Menu_Principal_Vista menu){

        this.menu = menu;
        menu.getCierreCajaButton().addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                Cerrar_Caja_Vista cierreCaja = new Cerrar_Caja_Vista();
                Cerrar_Caja_Controlador cont = new Cerrar_Caja_Controlador(cierreCaja);
                cierreCaja.setVisible(true);
                menu.dispose();
            }
        });
        //Asignar los eventos de los botones
        menu.getVentasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Venta_Vista ventas  = new Venta_Vista();
                Venta_Controlador control = new Venta_Controlador(ventas);
                ventas.setVisible(true);
                menu.dispose();
            }
        });
        menu.getInventarioButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventario_Vista inventario  = new Inventario_Vista();
                Inventario_Controlador control = new Inventario_Controlador(inventario);
                inventario.setVisible(true);
                menu.dispose();
            }
        });
        menu.getEliminarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar_Venta_Vista deleteventa =  new Eliminar_Venta_Vista();
                Eliminar_Venta_Controlador cont = new Eliminar_Venta_Controlador(deleteventa);
                deleteventa.setVisible(true);
                menu.dispose();
            }
        });


    }

}
