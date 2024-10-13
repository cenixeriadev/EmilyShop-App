package Controlador;
import Vista.Eliminar_Venta_Vista;
import Vista.Menu_Principal_Vista;
//import modelo.Eliminar_Venta_Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Eliminar_Venta_Controlador {
    private Eliminar_Venta_Vista EliminarVentaVista;
    public Eliminar_Venta_Controlador (Eliminar_Venta_Vista EliminarVentaVista){
        this.EliminarVentaVista = EliminarVentaVista;

        //Agregando listeners a los botones para que funcionen
        //Eliminar
        EliminarVentaVista.getbtnEliminar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                EliminarVenta();
            }
        });
        //Volver
        EliminarVentaVista.getbtnVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Menu_Principal_Vista hola = new Menu_Principal_Vista();
                Menu_Principal_Controlador comoesta = new Menu_Principal_Controlador(hola);
                hola.setVisible(true);
                EliminarVentaVista.dispose();
            }

        });
    }

    public void EliminarVenta(){
        if(EliminarVentaVista.txtcod.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Coloque un codigo valido");
            EliminarVentaVista.txtcod.setText("");
            EliminarVentaVista.txtcod.requestFocus();
        } else if(EliminarVentaVista.txtvent.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Coloque un numero de venta valido");
            EliminarVentaVista.txtvent.setText("");
            EliminarVentaVista.txtvent.requestFocus();
        } else if (EliminarVentaVista.ctalla.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Coloque una talla valida");
            EliminarVentaVista.ctalla.setSelectedIndex(0);
            EliminarVentaVista.ctalla.requestFocus();
        } else {
            int codigo = Integer.parseInt(EliminarVentaVista.txtcod.getText());
            int venta = Integer.parseInt(EliminarVentaVista.txtvent.getText());
            int opc = EliminarVentaVista.ctalla.getSelectedIndex();
            //Eliminar_Venta_Modelo producto = new Eliminar_Venta_Modelo(codigo, venta, opc);
            EliminarVentaVista.lblresultado.setText("PAR ELIMINADO");
            EliminarVentaVista.txtcod.setText("");
            EliminarVentaVista.txtvent.setText("");
        }
    }



}
