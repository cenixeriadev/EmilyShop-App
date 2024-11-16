package Modelo;

import javax.swing.*;


public interface MetodosInventario {
    void CargarDatos();

    void ModificarProducto(String talla , String modelo , String Color , String Codigo ,String Precio , int idinventario , int i );

    void EliminarProducto(int id);

    void AgregarProducto( JTextField modelo , JTextField codigo ,JComboBox<String> talla , JComboBox<String> color , JTextField PrecioCosto );

}
