package Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public interface MetodosInventario {
    void CargarDatos();
    void ModificarProducto(String talla , String modelo , String Color , String Codigo ,String Precio , int idinventario , int i );
    void EliminarProducto(int id);
    void AgregarProducto(ButtonGroup Tallas,JComboBox<String> modeloProducto ,  JTextField txtcodigo, JTextField txtColor, JTextField txtPrecioCosto );

}
