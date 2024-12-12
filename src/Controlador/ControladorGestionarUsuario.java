package Controlador;

import Modelo.Modelo_CrearUsuario;
import Modelo.Modelo_GestionarUsuario;
import Modelo.usuarios;
import Utilitario.ValidadorCampos;
import Vista.RegistroUsuarioVista;
import Vista.gestionUsuarioVista;
import Utilitario.Limpieza;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorGestionarUsuario implements MouseListener {
    private final gestionUsuarioVista vista;
    private final Modelo_GestionarUsuario modelo ;
    private int selectRow;
    private int IDusuario;

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
                RegistroUsuarioVista vistaCrear = new RegistroUsuarioVista();
                Modelo_CrearUsuario model = new Modelo_CrearUsuario(vistaCrear);
                vistaCrear.setVisible(true);
                vistaCrear.getBtncrear().addActionListener(o->{
                    if(vistaCrear.getTxtcontra().getText().equals("  Ingrese contraseña") || vistaCrear.getTxtnombre().getText().equals("  Ingrese Nombre y apellido") || vistaCrear.getTxttelefono().getText().equals("   Ingrese Numero de Telefono") || vistaCrear.getTxtusuario().getText().equals("  Ingrese usuario")) {
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos requeridos");
                    }else {
                        if (!ValidadorCampos.validacion(vistaCrear.getTxttelefono(), "^9\\d{8}$") || !ValidadorCampos.validacion(vistaCrear.getTxtnombre(), "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$")){
                            JOptionPane.showMessageDialog(null, "Debe ingresar campos validos!");

                        }
                        else{
                            model.RegistrarUsuario();
                            vistaCrear.dispose();
                            modelo.CargarUsuarios();
                        }

                    }
                });
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al crear el usuario");
            }
        });
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

