package Controlador;
import Modelo.Modelo_Inventario;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FrmInventarios_Controlador  implements  MouseListener{
    private FrInventarios_Vista vistainventario;
    public ArrayList<String>  valores = new ArrayList<>();
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vistainventario.getTablaInventario()){
            valores.add((String)vistainventario.getTablaInventario().getValueAt(vistainventario.getTablaInventario().getSelectedRow() , 0));
            valores.add((String)vistainventario.getTablaInventario().getValueAt(vistainventario.getTablaInventario().getSelectedRow() ,1));
            valores.add((String)vistainventario.getTablaInventario().getValueAt(vistainventario.getTablaInventario().getSelectedRow() ,2));
            valores.add((String)vistainventario.getTablaInventario().getValueAt(vistainventario.getTablaInventario().getSelectedRow() ,3));
            valores.add((String)vistainventario.getTablaInventario().getValueAt(vistainventario.getTablaInventario().getSelectedRow() ,4));
            valores.add(String.valueOf(vistainventario.getTablaInventario().getSelectedRow()) );
            for (String v : valores){
                System.out.println(v);
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




    public FrmInventarios_Controlador(FrInventarios_Vista vistainventario   ) {
        this.vistainventario = vistainventario;
        //Agregando listeners a los botones para que funcionen
        //
        vistainventario.getTablaInventario().addMouseListener(this);

        vistainventario.getBtnVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                Inventario_Vista MpVista = new Inventario_Vista();
                Inventario_Controlador  cont = new Inventario_Controlador(MpVista);
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                MpVista.setVisible(true);
                vistainventario.dispose();

            };

        });
        vistainventario.getBtnActualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                mod.ModificarProducto(valores.get(0), valores.get(1),valores.get(2),valores.get(3),valores.get(4)  , Integer.parseInt(valores.get(5)));
            };
        });
    }

}
