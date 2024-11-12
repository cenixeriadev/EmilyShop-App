package Controlador;
import Vista.Consulta_Vista;
import Vista.Venta_Vista;
import javax.swing.JOptionPane;
import java.util.Objects;

public class Consulta_Controlador {
    private final Consulta_Vista vistaConsulta;

    public Consulta_Controlador(Consulta_Vista vistaConsulta){
        this.vistaConsulta = vistaConsulta;

        vistaConsulta.getbtnConsulta().addActionListener(_ -> Consulta());
        //Borrar
        vistaConsulta.getbtnBorrar().addActionListener(_ -> Borrar());
        //Volver
        vistaConsulta.getbtnVolver().addActionListener(_ -> {
            Venta_Vista comeBack = new Venta_Vista();
            new Venta_Controlador(comeBack);
            comeBack.setVisible(true);
            vistaConsulta.dispose();
        });
    }
    public void Consulta(){
        if(vistaConsulta.getTextCod().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Coloque un codigo valido");
            vistaConsulta.getTextCod().setText("");
            vistaConsulta.getTextCod().requestFocus();
        } else if(Objects.equals(vistaConsulta.cboopTalla.getSelectedItem(), "TALLA")){
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