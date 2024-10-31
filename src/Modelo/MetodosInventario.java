package Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public interface MetodosInventario {
    void CargarDatos();
    void ModificarProducto();
    void EliminarProducto();
    void AgregarProducto(ButtonGroup Tallas,JComboBox modeloProducto ,  JTextField txtcodigo, JTextField txtColor, JTextField txtPrecioCosto );

}
