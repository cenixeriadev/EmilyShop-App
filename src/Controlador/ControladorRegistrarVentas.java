package Controlador;

import Modelo.*;
import Utilitario.Limpieza;
import Utilitario.BoletaPDF;
import Utilitario.ValidadorCampos;
import Vista.registroVentaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class ControladorRegistrarVentas implements MouseListener {
    private final registroVentaVista RegistroVentas;
    private final Modelo_RegistrarVentas modelo;
    private  carrito objProducto;
    private  ventas objVentas;
    private clientes objCliente;
    private  inventario objInventario;
    private int times = 0;
    private int idcarrito;
    private int selectRow;
    private ArrayList<BoletaPDF> listaBoleta;

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

        RegistroVentas.getBtneliminar().addActionListener(e->{
            if (RegistroVentas.getTablacarrito().isRowSelected(RegistroVentas.getTablacarrito().getSelectedRow())) {
                objProducto = new carrito();
                objProducto.setId_carrito(idcarrito);
                objProducto.EliminarProducto(idcarrito);
                DefaultTableModel model = (DefaultTableModel) RegistroVentas.getTablacarrito().getModel();
                model.removeRow(selectRow);
                RegistroVentas.getTablaInventario().clearSelection();
                objInventario = null;
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un producto de la tabla");
            }
        });

        RegistroVentas.getBtnCarrito().addActionListener(e -> {
            try {
                // Validar entrada
                if(!ValidadorCampos.validacion(RegistroVentas.getTxtcliente() , "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$") || !ValidadorCampos.validacion(RegistroVentas.getTxttelefono() , "^9\\d{8}$")){
                    JOptionPane.showMessageDialog(null , "Debe ingresar un nombre o numero telefonico valido!");
                    RegistroVentas.getTablaInventario().clearSelection();
                    return;
                }
                if(objInventario==null){
                    JOptionPane.showMessageDialog(null , "Debe seleccionar un producto para añadir al carrito!");
                    return;
                }

                // Obtener datos del cliente
                if(times==0){
                    objCliente = new clientes();
                    objCliente.setNombre(RegistroVentas.getTxtcliente().getText());
                    objCliente.setTelefono(RegistroVentas.getTxttelefono().getText());
                    int id_cliente = objCliente.AgregarCliente(objCliente);
                    if (id_cliente <= 0) {
                        JOptionPane.showMessageDialog(null, "Error al registrar el cliente.");
                        return;
                    }
                    objCliente.setId_cliente(id_cliente);
                }
                int totalEnCarrito = 0;

                int cantidad = (Integer)(RegistroVentas.getSpCantidad().getValue());
                for (int i = 0; i < RegistroVentas.getTablacarrito().getRowCount(); i++) {
                    int cantidadCarrito = Integer.parseInt(RegistroVentas.getTablacarrito().getValueAt(i, 5).toString());
                    totalEnCarrito += cantidadCarrito;
                }
                totalEnCarrito += cantidad;
                if(totalEnCarrito > objInventario.getStockDisponible(objInventario)){
                    JOptionPane.showMessageDialog(null , "No hay stock disponible!");
                    RegistroVentas.getTablacarrito().clearSelection();
                    return;
                }

                // Calcular subtotal
                int cantidadV = (Integer)RegistroVentas.getSpCantidad().getValue();
                double precioVenta = objInventario.getPrecio_venta();
                double subtotal = cantidadV * precioVenta;

                // Crear objeto de carrito
                objProducto = new carrito();
                objProducto.setCantidad((Integer)(RegistroVentas.getSpCantidad().getValue()));
                objProducto.setId_inventario(objInventario.getIdInventario());
                objProducto.setPrecio_unitario(objInventario.getPrecio_venta());
                objProducto.setId_cliente(objCliente.getId_cliente());
                objProducto.setSubtotal(subtotal);
                objProducto.AgregarProducto(objProducto);

                // Agregar al modelo de la tabla
                DefaultTableModel model = RegistroVentas.getModelocarrito();
                Object[] fila = {
                        objInventario.getCodigo(),
                        objInventario.getMarca(),
                        objInventario.getTalla(),
                        objInventario.getColor(),
                        objInventario.getPrecio_venta(),
                        RegistroVentas.getSpCantidad().getValue(),
                        RegistroVentas.getCbbmetodo().getSelectedItem()
                };
                model.addRow(fila);
                RegistroVentas.getTablaInventario().clearSelection();
                times = 1;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en el formato de los datos: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
            }
        });

        RegistroVentas.getBtnregistrar().addActionListener(e -> {
            try {
                // Validar datos del cliente
                if (objCliente == null || objCliente.getNombre_apellido().isEmpty() || objCliente.getTelefono().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese los datos del cliente.");
                    return;
                }

                // Validar si el carrito tiene productos
                if (RegistroVentas.getTablacarrito().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "El carrito está vacío. Agregue productos antes de registrar la venta.");
                    return;
                }

                // Registrar la venta en la base de datos

                modelo.VentaConfirmada(objCliente, (String)RegistroVentas.getCbbmetodo().getSelectedItem());
                times = 0;
                Limpieza.LimpiarCampos(RegistroVentas.getTxtcliente() , RegistroVentas.getTxttelefono());
                // Preguntar si el usuario quiere generar un PDF
                ImageIcon icon = new ImageIcon("src/Recursos/iconoPregunta.png");
                if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    JOptionPane.showMessageDialog(null, "El ícono de confirmación no pudo cargarse.");
                    return;
                }
                Image image = icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(image);
                Object[] opciones = {"Aceptar", "Cancelar"};
                int respuesta = JOptionPane.showOptionDialog(
                        null,
                        "¿Deseas generar una boleta en PDF?",
                        "Confirmación",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        newIcon,
                        opciones,
                        opciones[0]
                );

                if (respuesta == 0) {
                    BoletaPDF boletaPDF = new BoletaPDF();
                    listaBoleta = boletaPDF.generarDatos(objCliente);
                    boletaPDF.generarFactura(listaBoleta , objCliente);
                }

                // Limpiar las tablas y reinicializar los objetos
                DefaultTableModel model1 = (DefaultTableModel) RegistroVentas.getTablacarrito().getModel();
                model1.setRowCount(0);
                DefaultTableModel model2 = (DefaultTableModel) RegistroVentas.getTablaInventario().getModel();
                model2.setRowCount(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        RegistroVentas.getBtnbuscar().addActionListener(e -> {
            try {
                if (!RegistroVentas.getTxtcodigo().getText().isEmpty() || !String.valueOf(RegistroVentas.getCbbtallas().getSelectedItem()).equals("Seleccionar una talla") || !String.valueOf(RegistroVentas.getCbbcolor().getSelectedItem()).equals("Seleccionar un color")) {
                    modelo.CargarInventarioD(String.valueOf(RegistroVentas.getCbbtallas().getSelectedItem()), String.valueOf(RegistroVentas.getCbbcolor().getSelectedItem()), RegistroVentas.getTxtcodigo().getText());
                    Limpieza.LimpiarCampos(RegistroVentas.getTxtcodigo());
                }else{
                    JOptionPane.showMessageDialog(null,"Debe llenar alguno de los campos requeridos para realizar la busqueda");
                }
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en la busqueda: " + ex.getMessage());
            }
            Limpieza.LimpiarCampos(RegistroVentas.getTxtcodigo());
        });
    }

    private void handleTableRowSelection(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            objInventario = new inventario();
            objInventario.setCodigo((String) table.getValueAt(selectedRow, 0));
            objInventario.setMarca((String) table.getValueAt(selectedRow, 1));
            objInventario.setTalla(Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 2))));
            objInventario.setColor((String) table.getValueAt(selectedRow, 3));
            objInventario.setStock((Integer) table.getValueAt(selectedRow, 4));
            objInventario.setPrecio_venta((Double) table.getValueAt(selectedRow, 5));
            int id = objInventario.ObtenerIdInventario(objInventario);
            objInventario.setId_inventario(id);

            if (table == RegistroVentas.getTablacarrito()) {
                objProducto = new carrito();
                idcarrito = objProducto.ObtenerID(id);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == RegistroVentas.getTablaInventario()) {
            handleTableRowSelection(RegistroVentas.getTablaInventario());
        } else if (e.getSource() == RegistroVentas.getTablacarrito()) {
            handleTableRowSelection(RegistroVentas.getTablacarrito());
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
