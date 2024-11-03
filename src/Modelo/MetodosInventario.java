package Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public interface MetodosInventario {
    void CargarDatos();
    void ModificarProducto(String talla , String modelo , String Color , String Codigo ,String Precio , int i );
    void EliminarProducto(String codigoProducto);
    void AgregarProducto(ButtonGroup Tallas,JComboBox<String> modeloProducto ,  JTextField txtcodigo, JTextField txtColor, JTextField txtPrecioCosto );

}
