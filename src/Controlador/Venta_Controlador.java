package Controlador;

import Modelo.*;
import Vista.Menu_Principal_Vista;
import Vista.Venta_Vista;

import javax.swing.*;
import java.awt.event.*;

public class Venta_Controlador  implements MouseListener {
    private final Venta_Vista ventanaVentas ;
    producto objProducto ;
    productoDAO productoDAO = new productoDAO();
    ventas objVentas ;
    ventasDAO ventaDAO = new ventasDAO();
    String tallaSeleccionada;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==ventanaVentas.getTablaCandidatos()){
            int filaSelected = ventanaVentas.getTablaCandidatos().getSelectedRow();
            int IDinventario = (Integer)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected, 4);
            objProducto = new producto();

            objProducto.setModel((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected,0));
            objProducto.setColor((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected,1));
            objProducto.setCodigo((String)ventanaVentas.getTablaCandidatos().getValueAt(filaSelected,2));
            objProducto.setIdinventario(IDinventario);
            objProducto.setTalla(Integer.parseInt(tallaSeleccionada));
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
        ventanaVentas.getBtnVolver().addActionListener(_ -> {
            Menu_Principal_Vista mprime = new Menu_Principal_Vista();
            //new Menu_Principal_Controlador(mprime);
            mprime.setVisible(true);
            ventanaVentas.dispose();
        });

        ventanaVentas.getBtnAdd().addActionListener(_ -> {
            int estado = productoDAO.AgregarProducto(objProducto);

            if(estado>0){
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                String datosProducto = "\n" +"Modelo: " + objProducto.getModel() + "\n" +
                        "Color: " + objProducto.getColor() + "\n" +
                        "Código: " + objProducto.getCodigo() + "\n" +
                        "Talla: " + objProducto.getTalla() + "\n";
                ventanaVentas.getTextAreaDatos().append(datosProducto);
            }
            else{
                JOptionPane.showMessageDialog(null, "Producto no agregado");
            }




        });
        ventanaVentas.getBtnEliminar().addActionListener(_ -> {

        });
        ventanaVentas.getBtnRegistrar().addActionListener(_ -> {
            try {
                String cliente = ventanaVentas.getTextFieldDatos().getText();
                String Codigo = ventanaVentas.getTxtCodigo().getText();
                String Precio = ventanaVentas.getTxtPrecio().getText();
                String MetodoDePago = ventanaVentas.getTxtDescripcion().getText();

                int estado;
                objVentas = new ventas();
                objVentas.setCliente(cliente);
                objVentas.setCodigo(Integer.parseInt(Codigo));
                objVentas.setPrecio(Integer.parseInt(Precio));
                objVentas.setMetododepago(MetodoDePago);
                objVentas.setIdProducto(productoDAO.ObtenerIdProducto(objProducto.getIdinventario()));

                ventaDAO.actualizarInventario(objProducto.getIdinventario());

                estado  = ventaDAO.AgregarVentas(objVentas);
                LimpiarCampos(ventanaVentas.getTextFieldDatos() , ventanaVentas.getTxtCodigo() , ventanaVentas.getTxtDescripcion() ,ventanaVentas.getTxtPrecio());
                if(estado>0){
                    JOptionPane.showMessageDialog(null, "Venta registrada correctamente");
                    ventanaVentas.getTextAreaDatos().setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al registrar la venta");
                }



            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
            }


            // Registrar la venta en la base de datos
        });
        ventanaVentas.getComboTalla().addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED){
                try {
                    Object itemSeleccionado = e.getItem();
                    tallaSeleccionada = itemSeleccionado.toString();
                    Modelo_Ventas mod = new Modelo_Ventas(ventanaVentas);
                    mod.CargarInventarioD(tallaSeleccionada);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "ERROR");
                }

            }

        });

    }
    private void LimpiarCampos(JTextField... campos){
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }
    }
}
