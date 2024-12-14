package Controlador;

import Modelo.Modelo_GestionarVentas;
import Utilitario.Limpieza;
import Vista.GestionarVentasVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class ControladorGestionarVentas implements MouseListener {
    private final GestionarVentasVista vista ;
    private final Modelo_GestionarVentas modelo ;
    private int idDetalleVenta;
    private int idVenta;
    private int idCliente;
    public ControladorGestionarVentas(GestionarVentasVista vista , Modelo_GestionarVentas modelo){
        this.vista = vista;
        this.modelo = modelo;
        vista.getTablaInventario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iniciarEventos();
    }
    public void iniciarEventos(){
        vista.getTablaInventario().addMouseListener(this);
        vista.getBtneliminar().addActionListener(e->{
            try {
                modelo.eliminarDetalleVenta(idDetalleVenta, idVenta, idCliente);
                JOptionPane.showMessageDialog(null , "Venta eliminada correctamente");
                DefaultTableModel model1 = (DefaultTableModel) vista.getTablaInventario().getModel();
                model1.setRowCount(0);
                Limpieza.LimpiarCampos(vista.getTxtcliente(), vista.getTxttelefono());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null , "Error al eliminar detalle venta " + e.getSource() );
            }


        });
        vista.getBtnbuscar().addActionListener(e-> modelo.ListarTabla(vista.getTxtcliente().getText() , vista.getTxttelefono().getText()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.getTablaInventario()) {
            int selectedRow = vista.getTablaInventario().getSelectedRow();
            if (selectedRow != -1) {
                // Obtén los valores de las columnas ocultas
                idDetalleVenta = Integer.parseInt(vista.getTablaInventario().getModel().getValueAt(selectedRow, 0).toString());
                idVenta = Integer.parseInt(vista.getTablaInventario().getModel().getValueAt(selectedRow, 1).toString());
                idCliente = Integer.parseInt(vista.getTablaInventario().getModel().getValueAt(selectedRow, 2).toString());
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
