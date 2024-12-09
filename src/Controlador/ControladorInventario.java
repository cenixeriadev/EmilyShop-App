package Controlador;

import Modelo.Modelo_Inventario;
import Modelo.inventario;
import Vista.gestioninventarioVista;
import Vista.registroInventarioVista;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorInventario implements MouseListener {
    private final  gestioninventarioVista  gsvista;
    private final registroInventarioVista rgvista;
    private  final  Modelo_Inventario modelo ;
    public int IDinventario;
    private int selectRow;
    public ControladorInventario(gestioninventarioVista gsvista,registroInventarioVista rgvista ,  Modelo_Inventario modelo) {
        this.gsvista = gsvista;
        this.rgvista = rgvista;
        this.modelo = modelo;
        modelo.CargarDatos();
        gsvista.getTablaInventario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iniciarEventos();
    }
    public  void iniciarEventos(){
        gsvista.getTablaInventario().addMouseListener(this);

        rgvista.getBtnregistrar().addActionListener(_ -> modelo.AgregarProducto(rgvista.getTxtmarca() ,rgvista.getTxtcodigo() , rgvista.getCbbtalla() ,rgvista.getCbbcolor() ,rgvista.getTxtcosto() , rgvista.getTxtpventa() , rgvista.getSpcantidad() , rgvista.getTxtdescripcion()));
        gsvista.getBtnactualizar().addActionListener(_ -> {
            try {
                modelo.ModificarProducto(gsvista.getTxtTalla().getText(), gsvista.getTxtModelo().getText(), gsvista.getTxtColor().getText(), gsvista.getTxtCodigo().getText(), gsvista.getTxtCosto().getText(), IDinventario, selectRow);


                modelo.LimpiarCampos(gsvista.getTxtCodigo(), gsvista.getTxtColor(), gsvista.getTxtModelo(), gsvista.getTxtCosto(), gsvista.getTxtTalla());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null , "Debe seleccionar un producto de la tabla  ");
            }
        });
        gsvista.getBtneliminar().addActionListener(_ ->{
            try {
                if(gsvista.getTablaInventario().isRowSelected(selectRow)){
                    modelo.EliminarProducto(IDinventario);
                    gsvista.getModeloInventario().removeRow(selectRow);
                    modelo.CargarDatos();
                }
                else {
                    throw new NullPointerException();
                }
                modelo.LimpiarCampos(gsvista.getTxtCodigo() , gsvista.getTxtColor() , gsvista.getTxtModelo() , gsvista.getTxtCosto() , gsvista.getTxtTalla());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null , "Debe seleccionar un producto de la tabla  ");
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==gsvista.getTablaInventario()){
            selectRow = gsvista.getTablaInventario().getSelectedRow();// codigo  marca talla color pcosto
            inventario objInventario = new inventario();
            objInventario.setCodigo((String)gsvista.getTablaInventario().getValueAt(selectRow, 0));
            objInventario.setMarca((String)gsvista.getTablaInventario().getValueAt(selectRow , 1));
            objInventario.setTalla((Integer) gsvista.getTablaInventario().getValueAt(selectRow, 2));
            objInventario.setColor((String)gsvista.getTablaInventario().getValueAt(selectRow, 3));
            objInventario.setPrecio_venta((Double)gsvista.getTablaInventario().getValueAt(selectRow, 4));
            IDinventario = objInventario.ObtenerIdInventario(objInventario);
            gsvista.getTxtCodigo().setText(objInventario.getCodigo());
            gsvista.getTxtColor().setText(objInventario.getColor());
            gsvista.getTxtCosto().setText(Double.toString(objInventario.getPrecio_venta()));
            gsvista.getTxtTalla().setText(String.valueOf(objInventario.getTalla()));
            gsvista.getTxtModelo().setText(objInventario.getMarca());

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
}
