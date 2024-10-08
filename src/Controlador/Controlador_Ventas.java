package Controlador;

import Vista.Consulta;
import Vista.interfaz_Menu_Principal;
import Vista.interfaz_Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Ventas {

    private interfaz_Ventas  ventanaVentas ;

    public Controlador_Ventas(interfaz_Ventas ventanaVentas){
        this.ventanaVentas = ventanaVentas;
        //Asignar los eventos de los botones
        ventanaVentas.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaz_Menu_Principal mprime = new interfaz_Menu_Principal();
                Controlador_Menu_Principal cont = new Controlador_Menu_Principal(mprime);
                mprime.setVisible(true);
                ventanaVentas.dispose();
            }
        });
        ventanaVentas.getBtnConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consulta Consultation = new Consulta();
                Consultation.setVisible(true);
                ventanaVentas.dispose();
                // Acción al presionar el botón consulta
            }
        });

    }
}
