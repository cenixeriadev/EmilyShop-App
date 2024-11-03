package Controlador;

import Vista.Consulta_Vista;
import Vista.Menu_Principal_Vista;
import Vista.Venta_Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Venta_Controlador {

    private Venta_Vista ventanaVentas ;

    public Venta_Controlador(Venta_Vista ventanaVentas){
        this.ventanaVentas = ventanaVentas;
        //Asignar los eventos de los botones
        ventanaVentas.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_Principal_Vista mprime = new Menu_Principal_Vista();
                Menu_Principal_Controlador cont = new Menu_Principal_Controlador(mprime);
                mprime.setVisible(true);
                ventanaVentas.dispose();
            }
        });
        ventanaVentas.getBtnConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consulta_Vista Consultation = new Consulta_Vista();
                Consulta_Controlador consulta = new Consulta_Controlador(Consultation);
                Consultation.setVisible(true);
                ventanaVentas.dispose();
                // Acción al presionar el botón consulta
            }
        });
        ventanaVentas.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ventanaVentas.getBtnEliminar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }

        });
        ventanaVentas.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registrar la venta en la base de datos
            }
        });
    }
}
