package Controlador;
//import modelo.Consulta_Modelo;
import Vista.Consulta_Vista;
import Vista.Venta_Vista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Consulta_Controlador {
    private final Consulta_Vista vistaConsulta;

    public Consulta_Controlador(Consulta_Vista vistaConsulta){
        this.vistaConsulta = vistaConsulta;
        //Agregando listeners a los botones para que funcionen
        //Consultar
        vistaConsulta.getbtnConsulta().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Consulta();
            }
        });
        //Borrar
        vistaConsulta.getbtnBorrar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Borrar();
            }
        });
        //Volver
        vistaConsulta.getbtnVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Venta_Vista comeBack = new Venta_Vista();
                Venta_Controlador ventacont = new Venta_Controlador(comeBack);
                comeBack.setVisible(true);
                vistaConsulta.dispose();
            }
        });
    }
    public void Consulta(){
        if(vistaConsulta.getTextCod().getText().length()==0){
            JOptionPane.showMessageDialog(null, "Coloque un codigo valido");
            vistaConsulta.getTextCod().setText("");
            vistaConsulta.getTextCod().requestFocus();
        } else if(vistaConsulta.cboopTalla.getSelectedItem().equals("TALLA")){
            JOptionPane.showMessageDialog(null, "Elija una talla valida");
            vistaConsulta.cboopTalla.requestFocus();
        } else {
            int codigo = Integer.parseInt(vistaConsulta.getTextCod().getText());
            int talla = vistaConsulta.cboopTalla.getSelectedIndex();
            vistaConsulta.getRespuesta().setText("PAR ENCONTRADO: EL CODIGO ES: " + codigo + " Y LA TALLA ES: " + talla );
            vistaConsulta.getRespuesta().repaint();
        }
    }
    public void Borrar(){
        vistaConsulta.getTextCod().setText("");
        vistaConsulta.getRespuesta().setText("");
        vistaConsulta.cboopTalla.setSelectedIndex(0);
    }

}