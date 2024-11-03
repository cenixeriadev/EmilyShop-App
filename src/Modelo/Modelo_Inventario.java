package Modelo;

import Vista.FrInventarios_Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Modelo_Inventario implements MetodosInventario {
    private final FrInventarios_Vista vista ;
    ArrayList<inventario> listaInventario =  new ArrayList<>();
    inventario objInventario ;
    inventarioDAO objInventarioDAO  = new inventarioDAO();

    public Modelo_Inventario(FrInventarios_Vista vista) {
        this.vista = vista;

    }
    @Override
    public void CargarDatos() {
        DefaultTableModel modelo = vista.getModelo();
        int i = 0 ;
        listaInventario = objInventarioDAO.listarInventario();
        modelo.setNumRows(listaInventario.size());
        for(inventario objinventario : listaInventario){
            modelo.setValueAt(String.valueOf(objinventario.getTalla()), i, 0);
            modelo.setValueAt(objinventario.getModel(), i, 1);
            modelo.setValueAt(objinventario.getColor(), i, 2);
            modelo.setValueAt(String.valueOf(objinventario.getCodigo()), i, 3);
            modelo.setValueAt(String.valueOf(objinventario.getPrecioCosto()), i, 4);
            i++;
        }
        vista.getTablaInventario().setModel(modelo);
    }

    @Override
    public void ModificarProducto(String talla , String modelo , String Color , String Codigo ,String Precio  , int i ) {
        //int i = 0;
        DefaultTableModel model = vista.getModelo();
        objInventario = new inventario();
        objInventario.setTalla(Integer.parseInt(talla));
        objInventario.setModel(modelo);
        objInventario.setColor(Color);
        objInventario.setPrecioCosto(Integer.parseInt(Precio));
        objInventario.setCodigo(Codigo);
        listaInventario = objInventarioDAO.listarInventario();
        model.setNumRows(listaInventario.size());
        model.setValueAt(String.valueOf(objInventario.getTalla()), i, 0);
        model.setValueAt(objInventario.getModel(), i, 1);
        model.setValueAt(objInventario.getColor(), i, 2);
        model.setValueAt(objInventario.getCodigo(), i, 3);
        model.setValueAt(String.valueOf(objInventario.getPrecioCosto()), i, 4);

        int resultado = objInventarioDAO.ModificarProducto(objInventario);
        if (resultado>0) {
            JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto");
        }
        vista.getTablaInventario().setModel(model);
        CargarDatos();

    }

    @Override
    public void EliminarProducto(String codigoProduct) {
        objInventario = new inventario();
        objInventario.setCodigo(codigoProduct);
        int resultado = objInventarioDAO.EliminarProducto(objInventario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
        }
        CargarDatos();

    }

    @Override
    public void AgregarProducto(ButtonGroup Tallas,JComboBox<String> modeloProducto ,  JTextField txtcodigo, JTextField txtColor, JTextField txtPrecioCosto ) {
        int talla = Integer.parseInt(Tallas.getSelection().getActionCommand());
        String modeloProd = String.valueOf(modeloProducto.getSelectedItem());
        String codigo = txtcodigo.getText();
        String color = txtColor.getText();
        int precioCosto = Integer.parseInt(txtPrecioCosto.getText());
        objInventario = new inventario();
        objInventario.setTalla(talla);
        objInventario.setModel(modeloProd);
        objInventario.setCodigo(codigo);
        objInventario.setColor(color);
        objInventario.setPrecioCosto(precioCosto);
        int resultado = objInventarioDAO.AgregarProducto(objInventario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
        }else {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto");
        }
        CargarDatos();
        LimpiarCampos(txtcodigo,txtColor,txtPrecioCosto);

    }
    private void LimpiarCampos(JTextField... campos){
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }
    }
}
