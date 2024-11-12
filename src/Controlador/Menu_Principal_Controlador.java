package Controlador;

import Vista.*;


public class Menu_Principal_Controlador {
    private final Menu_Principal_Vista menu;
    public Menu_Principal_Controlador(Menu_Principal_Vista menu) {
        this.menu = menu;
        Iniciar();
    }
    private void Iniciar(){
        menu.getCierreCajaButton().addActionListener(_ -> {
            Cerrar_Caja_Vista cierreCaja = new Cerrar_Caja_Vista();
            new Cerrar_Caja_Controlador(cierreCaja);
            cierreCaja.setVisible(true);
            menu.dispose();
        });
        //Asignar los eventos de los botones
        menu.getVentasButton().addActionListener(_ -> {
            Venta_Vista ventas  = new Venta_Vista();
            new Venta_Controlador(ventas);
            ventas.setVisible(true);
            menu.dispose();
        });
        menu.getInventarioButton().addActionListener(_ -> {
            Inventario_Vista inventariopr  = new Inventario_Vista();
            new Inventario_Controlador(inventariopr);
            inventariopr.setVisible(true);
            menu.dispose();
        });
        menu.getEliminarButton().addActionListener(_ -> {
            Eliminar_Venta_Vista deleteventa =  new Eliminar_Venta_Vista();
            new Eliminar_Venta_Controlador(deleteventa);
            deleteventa.setVisible(true);
            menu.dispose();
        });

    }

}
