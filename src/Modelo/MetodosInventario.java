package Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public interface MetodosInventario {
    void CargarDatos();
    void ModificarProducto();
    void EliminarProducto(String codigoProducto);
    void AgregarProducto(ButtonGroup Tallas,JComboBox<String> modeloProducto ,  JTextField txtcodigo, JTextField txtColor, JTextField txtPrecioCosto );

}
