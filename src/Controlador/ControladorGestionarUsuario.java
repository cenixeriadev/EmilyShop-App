package Controlador;

import Modelo.Modelo_CrearUsuario;
import Modelo.Modelo_GestionarUsuario;
import Modelo.usuarios;
import Utilitario.ValidadorCampos;
import Vista.RegistroUsuarioVista;
import Vista.gestionUsuarioVista;
import Utilitario.Limpieza;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class ControladorGestionarUsuario implements MouseListener {
    private final gestionUsuarioVista vista;
    private final Modelo_GestionarUsuario modelo ;
    private int selectRow;
    private int IDusuario;
    RegistroUsuarioVista vistaCrear = new RegistroUsuarioVista();
    Modelo_CrearUsuario model = new Modelo_CrearUsuario(vistaCrear);
    public ControladorGestionarUsuario(gestionUsuarioVista vista, Modelo_GestionarUsuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        modelo.CargarUsuarios();
        vista.getTablaUsuario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iniciarEventos();
    }
    public void iniciarEventos() {
        vista.getTablaUsuario().addMouseListener(this);

        vista.getBtneliminar().addActionListener(e -> {
            try {
                if (vista.getTablaUsuario().isRowSelected(selectRow)) {
                    modelo.EliminarUsuario(IDusuario);
                    modelo.CargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la tabla");
                }
                Limpieza.LimpiarCampos(vista.getTxtnombre(), vista.getTxttelefono(), vista.getTxtusuario());
                vista.getTablaUsuario().clearSelection();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
            }
        });
        vista.getBtnactualizar().addActionListener(e -> {
            try {
                modelo.ActualizarUsuario(
                        vista.getTxtnombre().getText(),
                        vista.getTxttelefono().getText(),
                        vista.getTxtusuario().getText(),
                        IDusuario
                );
                modelo.CargarUsuarios();
                Limpieza.LimpiarCampos(vista.getTxtnombre(), vista.getTxttelefono(), vista.getTxtusuario());
                vista.getTablaUsuario().clearSelection();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos para actualizar");
            }
        });
        vista.getBtnCrearUsuario().addActionListener(e->{
            try{
                vistaCrear.setVisible(true);
                vistaCrear.getBtncrear().addActionListener(ex-> {
                    crearUsuario();
                });
                vistaCrear.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "crearUsuario");
                vistaCrear.getRootPane().getActionMap().put("crearUsuario", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        crearUsuario();
                    }
                });
                vistaCrear.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println(Arrays.stream(vistaCrear.getBtncrear().getActionListeners()).count());//debug
                        for(int i = 0; i < Arrays.stream(vistaCrear.getBtncrear().getActionListeners()).count(); i++){
                            vistaCrear.getBtncrear().removeActionListener(vistaCrear.getBtncrear().getActionListeners()[i]);
                        }
                    }
                });

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al crear el usuario");
            }
        });
    }
    private void limpiarYConfigurarCampos() {
        vistaCrear.getTxtcontra().setText("  Ingrese contraseña");
        vistaCrear.getTxtnombre().setText("  Ingrese Nombre y apellido");
        vistaCrear.getTxttelefono().setText("   Ingrese Numero de Telefono");
        vistaCrear.getTxtusuario().setText("  Ingrese usuario");
        vistaCrear.getTxtcontra().requestFocus();
    }
    private void crearUsuario() {
        if (vistaCrear.getTxtcontra().getText().equals("  Ingrese contraseña") ||
                vistaCrear.getTxtnombre().getText().equals("  Ingrese Nombre y apellido") ||
                vistaCrear.getTxttelefono().getText().equals("   Ingrese Numero de Telefono") ||
                vistaCrear.getTxtusuario().getText().equals("  Ingrese usuario")) {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos requeridos");
        } else {
            if (!ValidadorCampos.validacion(vistaCrear.getTxttelefono(), "^9\\d{8}$") ||
                    !ValidadorCampos.validacion(vistaCrear.getTxtnombre(), "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$")) {

                JOptionPane.showMessageDialog(null, "Debe ingresar campos válidos!");
            } else {
                model.RegistrarUsuario();
                modelo.CargarUsuarios();
                JOptionPane.showMessageDialog(null , "Usuario creado exitosamente!");
                vistaCrear.dispose();
            }
            limpiarYConfigurarCampos();
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.getTablaUsuario()) {
            if(selectRow!=-1){
                selectRow = vista.getTablaUsuario().getSelectedRow();
                usuarios objUsuario = new usuarios();
                vista.getTxtnombre().setText((String)(vista.getTablaUsuario().getValueAt(selectRow  , 0)));
                vista.getTxttelefono().setText((String)(vista.getTablaUsuario().getValueAt(selectRow , 1)));
                vista.getTxtusuario().setText((String)(vista.getTablaUsuario().getValueAt(selectRow , 2)));
                objUsuario.setNombre(vista.getTxtnombre().getText());
                objUsuario.setTelefono(vista.getTxttelefono().getText());
                objUsuario.setNombre_usuario(vista.getTxtusuario().getText());
                IDusuario = objUsuario.ObtenerIdUsuario(objUsuario);
            }
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}

