package Controlador;

import Modelo.Modelo_GestionarUsuario;
import Modelo.usuarios;
import Vista.gestionUsuarioVista;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorGestionarUsuario implements MouseListener {
    private final gestionUsuarioVista vista;
    private Modelo_GestionarUsuario modelo ;
    private int selectRow;
    private int IDusuario;
    private usuarios objUsuario;

    public ControladorGestionarUsuario(gestionUsuarioVista vista, Modelo_GestionarUsuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        modelo.CargarUsuarios();
        vista.getTablaUsuario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iniciarEventos();
    }

    public void iniciarEventos() {
        vista.getTablaUsuario().addMouseListener(this);

        vista.getBtneliminar().addActionListener(_ -> {
            try {
                if (vista.getTablaUsuario().isRowSelected(selectRow)) {
                    modelo.EliminarUsuario(IDusuario);
                    modelo.CargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la tabla");
                }
                modelo.Limpiarcampos(vista.getTxtnombre(), vista.getTxttelefono(), vista.getTxtusuario());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
            }
        });
        vista.getBtnactualizar().addActionListener(_ -> {
            try {
                modelo.ActualizarUsuario(
                        vista.getTxtnombre().getText(),
                        vista.getTxttelefono().getText(),
                        vista.getTxtusuario().getText(),
                        IDusuario
                );
                modelo.CargarUsuarios();
                modelo.Limpiarcampos(vista.getTxtnombre(), vista.getTxttelefono(), vista.getTxtusuario());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos para actualizar");
            }
        });
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.getTablaUsuario()) {
            selectRow = vista.getTablaUsuario().getSelectedRow();
            objUsuario = new usuarios();
            vista.getTxtnombre().setText((String)(vista.getTablaUsuario().getValueAt(selectRow  , 0)));
            vista.getTxttelefono().setText((String)(vista.getTablaUsuario().getValueAt(selectRow , 1)));
            vista.getTxtusuario().setText((String)(vista.getTablaUsuario().getValueAt(selectRow , 2)));
            //Usuariovist.getTxtcontra().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 3)));
            objUsuario.setNombre(vista.getTxtnombre().getText());
            //objUsuario.setContraseña(Usuariovist.getTxtcontra().getText());
            objUsuario.setTelefono(vista.getTxttelefono().getText());
            objUsuario.setNombre_usuario(vista.getTxtusuario().getText());
            IDusuario = objUsuario.ObtenerIdUsuario(objUsuario);
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}

