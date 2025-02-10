package Controlador;

import Modelo.Modelo_Inventario;
import Modelo.inventario;
import Utilitario.Limpieza;
import Vista.gestioninventarioVista;
import Vista.registroInventarioVista;

import javax.swing.*;
import java.awt.event.*;

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

        rgvista.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "login");
        rgvista.getRootPane().getActionMap().put("login", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.AgregarProducto(rgvista.getTxtmarca() ,rgvista.getTxtcodigo() , rgvista.getCbbtalla() ,rgvista.getCbbcolor() ,rgvista.getTxtcosto() , rgvista.getTxtpventa() , rgvista.getSpcantidad() , rgvista.getTxtdescripcion());
            }
        });
        rgvista.getBtnregistrar().addActionListener(e -> modelo.AgregarProducto(rgvista.getTxtmarca() ,rgvista.getTxtcodigo() , rgvista.getCbbtalla() ,rgvista.getCbbcolor() ,rgvista.getTxtcosto() , rgvista.getTxtpventa() , rgvista.getSpcantidad() , rgvista.getTxtdescripcion()));
        gsvista.getBtnactualizar().addActionListener(e -> {
            try {
                modelo.ModificarProducto(gsvista.getTxtDescripcion().getText(),gsvista.getTxtTalla().getText(), gsvista.getTxtModelo().getText(), gsvista.getTxtColor().getText(), gsvista.getTxtCodigo().getText(), gsvista.getTxtCosto().getText(),gsvista.getTxtCantidad().getText() , IDinventario, selectRow);


                Limpieza.LimpiarCampos(gsvista.getTxtCodigo(), gsvista.getTxtColor(), gsvista.getTxtModelo(), gsvista.getTxtCosto(), gsvista.getTxtTalla() ,gsvista.getTxtCantidad() , gsvista.getTxtDescripcion());
                gsvista.getTablaInventario().clearSelection();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null , "Debe seleccionar un producto de la tabla  ");
            }
        });
        gsvista.getBtneliminar().addActionListener(e ->{
            try {
                if(gsvista.getTablaInventario().isRowSelected(selectRow)){
                    modelo.EliminarProducto(IDinventario);
                    gsvista.getModeloInventario().removeRow(selectRow);
                    modelo.CargarDatos();
                }
                else {
                    throw new NullPointerException();
                }
                Limpieza.LimpiarCampos(gsvista.getTxtCodigo() , gsvista.getTxtColor() , gsvista.getTxtModelo() , gsvista.getTxtCosto() , gsvista.getTxtTalla() , gsvista.getTxtCantidad());
                gsvista.getTablaInventario().clearSelection();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null , "Debe seleccionar un producto de la tabla  ");
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==gsvista.getTablaInventario()){
            if(selectRow!=-1){
                selectRow = gsvista.getTablaInventario().getSelectedRow();
                inventario objInventario = new inventario();
                objInventario.setCodigo((String)gsvista.getTablaInventario().getValueAt(selectRow, 0));
                objInventario.setMarca((String)gsvista.getTablaInventario().getValueAt(selectRow , 1));
                objInventario.setTalla((Integer) gsvista.getTablaInventario().getValueAt(selectRow, 2));
                objInventario.setColor((String)gsvista.getTablaInventario().getValueAt(selectRow, 3));
                objInventario.setStock((Integer)gsvista.getTablaInventario().getValueAt(selectRow , 4));
                objInventario.setPrecio_venta((Double)gsvista.getTablaInventario().getValueAt(selectRow, 5));
                IDinventario = objInventario.ObtenerIdInventario(objInventario);
                objInventario.setId_inventario(IDinventario);
                String descripcion = objInventario.ObtenerDescripcion(objInventario);
                objInventario.setDescripcion(descripcion);
                gsvista.getTxtCodigo().setText(objInventario.getCodigo());
                gsvista.getTxtColor().setText(objInventario.getColor());
                gsvista.getTxtCosto().setText(Double.toString(objInventario.getPrecio_venta()));
                gsvista.getTxtTalla().setText(String.valueOf(objInventario.getTalla()));
                gsvista.getTxtModelo().setText(objInventario.getMarca());
                gsvista.getTxtCantidad().setText(String.valueOf(objInventario.getStock()));
                gsvista.getTxtDescripcion().setText(objInventario.getDescripcion());
            }


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
