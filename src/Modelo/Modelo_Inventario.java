package Modelo;

import Utilitario.Limpieza;
import Utilitario.ValidadorCampos;
import Vista.gestioninventarioVista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        modelo.setRowCount(0);
        listaInventario = objInventario.listarInventario();
        AgregarInventario(modelo, listaInventario, vistages.getTablaInventario());
    }


    @Override
    public void ModificarProducto(String talla , String modelo , String Color , String Codigo ,String Precio  ,int idinventario ,  int i ) {
        if (i != -1) {
            objInventario  = new inventario();
            objInventario.setId_inventario(idinventario);
            objInventario.setTalla(Integer.parseInt(talla));
            objInventario.setMarca(modelo);
            objInventario.setColor(Color);
            objInventario.setPrecio_venta(Double.parseDouble(Precio));
            objInventario.setCodigo(Codigo);
            int resultado = objInventario.ModificarProducto(objInventario);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para modificar");
        }
        CargarDatos();
    }

    @Override
    public void EliminarProducto(int id) {//debe estar en funcion del idinventario
        int resultado = objInventario.EliminarProducto(id);
        if( resultado > 0){
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
        }
    }

    @Override
    public void AgregarProducto(JTextField marca , JTextField codigo ,JComboBox<String> talla , JComboBox<String> color , JTextField PrecioCosto ,JTextField PrecioVenta , JSpinner Cantidad , JTextField descripcion) {
        int resultado;
        try {
            if(!ValidadorCampos.validacion(marca ,"^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s-]{2,50}$")){
                JOptionPane.showMessageDialog(null , "Ingrese un nombre valido de marca!");
                return;
            }
            int Talla = Integer.parseInt((String) Objects.requireNonNull(talla.getSelectedItem()));
            String modeloProd = marca.getText();
            String Codigo = codigo.getText();
            String Color = (String) color.getSelectedItem();
            double precioCosto = Double.parseDouble(PrecioCosto.getText());
            double precioVenta = Double.parseDouble(PrecioVenta.getText());
            int cantidad = (Integer)(Cantidad.getValue());
            String Descripcion = descripcion.getText();
            objInventario = new inventario();
            objInventario.setTalla(Talla);
            objInventario.setMarca(modeloProd);
            objInventario.setCodigo(Codigo);
            objInventario.setColor(Color);
            objInventario.setPrecio_compra(precioCosto);
            objInventario.setPrecio_venta(precioVenta);
            objInventario.setStock(cantidad);
            objInventario.setDescripcion(Descripcion);
            resultado = objInventario.AgregarProducto(objInventario);
            if( resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            }

        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para los precios");
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null , "Debe llenar todos los campos requeridos ");
        }

        CargarDatos();
        Limpieza.LimpiarCampos(marca,codigo,PrecioCosto , PrecioVenta ,descripcion);

    }
    static void AgregarInventario(DefaultTableModel modelo, ArrayList<inventario> listaInventario, JTable tablaInventario) {
        for(inventario objinventario : listaInventario){
            if(objinventario.ObtenerEstado(objinventario).equals("activo")){
                Object[] fila = {
                        objinventario.getCodigo(),
                        objinventario.getMarca(),
                        objinventario.getTalla(),
                        objinventario.getColor(),
                        objinventario.getPrecio_venta()
                };
                modelo.addRow(fila);
            }
        }
        tablaInventario.setModel(modelo);
    }
}
