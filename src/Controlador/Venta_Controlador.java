package Controlador;

import Modelo.*;
import Vista.Consulta_Vista;
import Vista.Menu_Principal_Vista;
import Vista.Venta_Vista;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Venta_Controlador  implements MouseListener {
    private Venta_Vista ventanaVentas ;
    producto objProducto  = new producto();
    productoDAO productoDAO = new productoDAO();
    ventas objVentas ;
    ventasDAO ventaDAO = new ventasDAO();
    ArrayList<producto> listaProducto = new ArrayList<producto>();
    private String tallaSeleccionada;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==ventanaVentas.getTablaCandidatos()){
            int filaSelected = ventanaVentas.getTablaCandidatos().getSelectedRow();
            //int idInventario = (Integer)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected, 4);
            objProducto.setModel((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected,0));
            objProducto.setColor((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected,1));
            objProducto.setCodigo((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected,2));
            objProducto.setIdinventario((Integer)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected, 4));

            objProducto.setTalla(Integer.parseInt(tallaSeleccionada));//objProducto((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected, 3));


        }
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
                productoDAO.AgregarProducto(objProducto);
                String datosProducto = "Modelo: " + objProducto.getModel() + "\n" +
                        "Color: " + objProducto.getColor() + "\n" +
                        "Código: " + objProducto.getCodigo() + "\n" +
                        "Talla: " + objProducto.getTalla();
                listaProducto.add(objProducto);

                ventanaVentas.getTextAreaDatos().append(datosProducto);

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
                try {
                    String cliente = ventanaVentas.getTextFieldDatos().getText();
                    String Codigo = ventanaVentas.getTxtCodigo().getText();
                    String Precio = ventanaVentas.getTxtPrecio().getText();
                    String MetodoDePago = ventanaVentas.getTxtDescripcion().getText();
                    for(producto obj : listaProducto){
                        objVentas = new ventas();
                        objVentas.setCliente(cliente);
                        objVentas.setCodigo(Integer.parseInt(Codigo));
                        objVentas.setPrecio(Integer.parseInt(Precio));
                        objVentas.setMetododepago(MetodoDePago);
                        objVentas.setIdProducto(obj.getIdProducto());

                        ventaDAO.AgregarVentas(objVentas);
                    }

                    listaProducto.clear();


                }catch (Exception ex){
                    JOptionPane.showMessageDialog(ventanaVentas, "Por favor ingrese todos los datos");
                }


                // Registrar la venta en la base de datos
            }
        });
        ventanaVentas.getComboTalla().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    Object itemSeleccionado = e.getItem();
                    tallaSeleccionada  = itemSeleccionado.toString();
                    Modelo_Ventas mod = new Modelo_Ventas(ventanaVentas);
                    mod.CargarInventarioD(tallaSeleccionada);

                }

            }


        });

    }
}
