package Controlador;

import Modelo.*;
import Utilitario.VentaPDF;
import Vista.registroVentaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControladorRegistrarVentas implements MouseListener {
    private final registroVentaVista RegistroVentas;
    private int selectRow;
    private final Modelo_RegistrarVentas modelo;
    private final VentaPDF pdf = new VentaPDF();
    public ArrayList<ventas> listaVentas = new  ArrayList<>();
    public ArrayList<Integer> inventarioConsumido = new  ArrayList<>();
    private  carrito objProducto;
    private  ventas objVentas;
    private  inventario objInventario;

    public ControladorRegistrarVentas(registroVentaVista RegistroVentas, Modelo_RegistrarVentas modelo){
        this.RegistroVentas = RegistroVentas;
        this.modelo = modelo;
        RegistroVentas.getTablacarrito().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        RegistroVentas.getTablaInventario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iniciarEventos();
    }
    private void iniciarEventos() {
        RegistroVentas.getTablaInventario().addMouseListener(this);
        RegistroVentas.getTablacarrito().addMouseListener(this);
        RegistroVentas.getBtnCarrito().addActionListener(_ ->{
            objVentas = new ventas();
            listaVentas.add(objVentas);
            inventarioConsumido.add(objInventario.getIdInventario());
        });
        RegistroVentas.getBtnregistrar().addActionListener(_->{
            try{
                ImageIcon icon = new ImageIcon("src/Recursos/iconoPregunta.png");
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // Reducir el tamaño a 50x50
                ImageIcon newIcon = new ImageIcon(newimg);
                ArrayList<carrito> productos;
                //productos = modelo_registro_ventas.RegistrarVenta(listaVentas , inventarioConsumido);
                listaVentas.clear();
                inventarioConsumido.clear();
                JOptionPane.showMessageDialog(null , "Venta realizada con exito :D");
                Object[] opciones= {"Aceptar" , "Cancelar"};
                int respuesta = JOptionPane.showOptionDialog(
                        null,
                        "¿Deseas generar una boleta en pdf?",
                        "Confirmación",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        newIcon,
                        opciones,
                        opciones[0] // Opción predeterminada
                );
                if(respuesta==0){
                    ArrayList<ventas> resultados;
                    resultados = pdf.DatosCliente(String.valueOf(objVentas.getId_cliente()));
                    //pdf.generarFactura(productos , resultados);
                }
                DefaultTableModel model1 = (DefaultTableModel) RegistroVentas.getTablacarrito().getModel();
                model1.setRowCount(0);
                DefaultTableModel model2 = (DefaultTableModel) RegistroVentas.getTablaInventario().getModel();
                model2.setRowCount(0);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Debe llenar los campos requeridos :  " + e.getMessage());
            }
        });
        RegistroVentas.getBtnbuscar().addActionListener(_ -> {
            try {
                if (!RegistroVentas.getTxtcodigo2().getText().isEmpty() || !String.valueOf(RegistroVentas.getCbbtallas().getSelectedItem()).equals("Seleccionar una talla") || !String.valueOf(RegistroVentas.getCbbcolor().getSelectedItem()).equals("Seleccionar un color")) {
                    modelo.CargarInventarioD(String.valueOf(RegistroVentas.getCbbtallas().getSelectedItem()), String.valueOf(RegistroVentas.getCbbcolor().getSelectedItem()), RegistroVentas.getTxtcodigo2().getText());
                }else{
                    JOptionPane.showMessageDialog(null,"Debe llenar alguno de los campos requeridos para realizar la busqueda");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la busqueda: " + e.getMessage());
            }
            modelo.LimpiarCampos(RegistroVentas.getTxtcodigo2());
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==RegistroVentas.getTablaInventario()){
            selectRow = RegistroVentas.getTablaInventario().getSelectedRow();
            objInventario = new inventario();
            objInventario.setMarca((String)RegistroVentas.getTablaInventario().getValueAt(selectRow , 0));
            objInventario.setCodigo((String)RegistroVentas.getTablaInventario().getValueAt(selectRow, 1));
            objInventario.setTalla(Integer.parseInt(String.valueOf(RegistroVentas.getTablaInventario().getValueAt(selectRow, 2))));
            objInventario.setColor((String)RegistroVentas.getTablaInventario().getValueAt(selectRow, 3));
            int id = objInventario.ObtenerIdInventario(objInventario);
            objInventario.setId_inventario(id);
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
