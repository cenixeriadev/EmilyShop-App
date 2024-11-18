package Modelo;

import Vista.gestioninventarioVista;
import Vista.registroInventarioVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Objects;

public class Modelo_Inventario implements MetodosInventario {
    private final gestioninventarioVista vistages ;
    ArrayList<inventario> listaInventario =  new ArrayList<>();
    inventario objInventario  =  new inventario();
    public Modelo_Inventario(gestioninventarioVista vistages ) {
        this.vistages = vistages;

    }
    @Override
    public void CargarDatos() {
        DefaultTableModel modelo = vistages.getModeloInventario();
        int i = 0 ;
        listaInventario = objInventario.listarInventario();
        modelo.setNumRows(listaInventario.size());
        for(inventario objinventario : listaInventario){
            modelo.setValueAt(objinventario.getModel(), i, 0);
            modelo.setValueAt(String.valueOf(objinventario.getCodigo()), i, 1);
            modelo.setValueAt(String.valueOf(objinventario.getTalla()), i, 2);
            modelo.setValueAt(objinventario.getColor(), i, 3);
            modelo.setValueAt(String.valueOf(objinventario.getPrecioCosto()), i, 4);
            i++;
        }
        vistages.getTablaInventario().setModel(modelo);
    }

    @Override
    public void ModificarProducto(String talla , String modelo , String Color , String Codigo ,String Precio  ,int idinventario ,  int i ) {
        if (i != -1) {
            TableModel model =  vistages.getTablaInventario().getModel();
            objInventario  = new inventario();
            objInventario.setIdinventario(idinventario);
            objInventario.setTalla(Integer.parseInt(talla));
            objInventario.setModel(modelo);
            objInventario.setColor(Color);
            objInventario.setPrecioCosto(Integer.parseInt(Precio));
            objInventario.setCodigo(Codigo);
            model.setValueAt(objInventario.getModel(), i, 0);
            model.setValueAt(objInventario.getCodigo(), i, 1);
            model.setValueAt(String.valueOf(objInventario.getTalla()), i, 2);
            model.setValueAt(objInventario.getColor(), i, 2);
            model.setValueAt(String.valueOf(objInventario.getPrecioCosto()), i, 4);

            int resultado = objInventario.ModificarProducto(objInventario);
            vistages.getTablaInventario().setModel(model);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para modificar");
        }
    }

    @Override
    public void EliminarProducto(int id) {//debe estar en funcion del idinventario
        int resultado = objInventario.EliminarProducto(id);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
        }
        CargarDatos();

    }

    @Override
    public void AgregarProducto(JTextField modelo , JTextField codigo ,JComboBox<String> talla , JComboBox<String> color , JTextField PrecioCosto ) {
        int Talla = Integer.parseInt((String)talla.getSelectedItem());
        String modeloProd = modelo.getText();
        String Codigo = codigo.getText();
        String Color = (String) color.getSelectedItem();
        int precioCosto = Integer.parseInt(PrecioCosto.getText());
        objInventario = new inventario();
        objInventario.setTalla(Talla);
        objInventario.setModel(modeloProd);
        objInventario.setCodigo(Codigo);
        objInventario.setColor(Color);
        objInventario.setPrecioCosto(precioCosto);
        int resultado = objInventario.AgregarProducto(objInventario);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
        }else {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto");
        }
        CargarDatos();
        LimpiarCampos(modelo,codigo,PrecioCosto);

    }
    private void LimpiarCampos(JTextField... campos){
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }
    }
}
