package Controlador;

import Modelo.Modelo_Ventas;
import Vista.Consulta_Vista;
import Vista.Menu_Principal_Vista;
import Vista.Venta_Vista;

import java.awt.event.*;
import java.util.ArrayList;

public class Venta_Controlador  implements MouseListener {
    private Venta_Vista ventanaVentas ;
    ArrayList<String> ValoresSeleccionados = new ArrayList<>();

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    public Venta_Controlador(Venta_Vista ventanaVentas){
        this.ventanaVentas = ventanaVentas;

        ventanaVentas.getTablaCandidatos().addMouseListener(this);
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
        ventanaVentas.getComboTalla().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    Object itemSeleccionado = e.getItem();
                    String tallaSeleccionada  = itemSeleccionado.toString();
                    Modelo_Ventas mod = new Modelo_Ventas(ventanaVentas);
                    mod.CargarInventarioD(tallaSeleccionada);

                }

            }


        });

    }
}
