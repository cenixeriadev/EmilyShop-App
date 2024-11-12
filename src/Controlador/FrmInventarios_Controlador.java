package Controlador;
import Modelo.Modelo_Inventario;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class FrmInventarios_Controlador  implements  MouseListener{
    private final FrInventarios_Vista vistainventario;
    private final Inventario_Vista MpVista  = new Inventario_Vista();
    private final ArrayList<String>  valores = new ArrayList<>();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistainventario.getTablaInventario()) {
            int selectedRow = vistainventario.getTablaInventario().getSelectedRow();
            if (selectedRow >= 0) {
                valores.clear();
                for(int i= 0; i<6 ; i++){
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, i));
                }
                valores.add(String.valueOf(selectedRow));
            }
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




    public FrmInventarios_Controlador(FrInventarios_Vista vistainventario) {
        this.vistainventario = vistainventario;

        vistainventario.getTablaInventario().addMouseListener(this);

        vistainventario.getBtnVolver().addActionListener(_ -> {
            new Inventario_Controlador(MpVista);
            new Modelo_Inventario(vistainventario);
            MpVista.setVisible(true);
            vistainventario.dispose();

        });
        vistainventario.getBtnEliminar().addActionListener(_ -> {
            try {
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                mod.EliminarProducto(Integer.parseInt(valores.get(5)));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null , "No se puedo eliminar el producto! (‾◡◝)");
            }
        });
        vistainventario.getBtnActualizar().addActionListener(_ -> {
            try {
                if (vistainventario.getTablaInventario().isEditing()) {
                    vistainventario.getTablaInventario().getCellEditor().stopCellEditing();
                }

                // Actualizar los valores antes de enviar los datos al modelo
                int selectedRow = vistainventario.getTablaInventario().getSelectedRow();
                if (selectedRow >= 0) {
                    valores.clear();
                    for(int i = 0 ; i <6 ; i++) {
                        valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, i));
                    }
                }
                valores.add((String.valueOf(selectedRow)));
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                mod.ModificarProducto(valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), Integer.parseInt(valores.get(5)), Integer.parseInt(valores.get(6)));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null,"No se actualizo el producto! (‾◡◝)");
            }
        });
    }

}
