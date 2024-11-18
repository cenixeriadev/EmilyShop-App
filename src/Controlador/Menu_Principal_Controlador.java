package Controlador;

import Modelo.Modelo_GestionarUsuario;
import Modelo.Modelo_Inventario;
import Modelo.Modelo_Login;
import Modelo.inventario;
import Vista.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Menu_Principal_Controlador implements MouseListener {
    private final PrincipalVista menu;
    private  JPanel mainPanel;
    private  CardLayout cardLayout;
    private int selectRow;
    public String names ;
    public int IDinventario;
    inventario objInventario;

    private  final  gestionUsuarioVista Usuariovist = new gestionUsuarioVista();
    private final gestioninventarioVista Inventariovist = new gestioninventarioVista();
    private final registroInventarioVista Registrovist = new registroInventarioVista();
    private final  registroVentaVista RegsitroVentas = new registroVentaVista();
    private final GestionarVentasVista gestionarVentas = new GestionarVentasVista();

    private final Modelo_GestionarUsuario model = new Modelo_GestionarUsuario(Usuariovist);
    private final Modelo_Inventario modelo_inventario = new Modelo_Inventario(Inventariovist);
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==Usuariovist.getTablaUsuario()) {
            names = (String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 0));
            selectRow = Usuariovist.getTablaUsuario().getSelectedRow();
            Usuariovist.getTxtnombre().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 0)));
            Usuariovist.getTxttelefono().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow , 1)));
            Usuariovist.getTxtusuario().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow , 2)));
            Usuariovist.getTxtcontra().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 3)));
        }
        if(e.getSource()==Inventariovist.getTablaInventario()){
            selectRow = Inventariovist.getTablaInventario().getSelectedRow();// modelo  codigo talla color pcosto
            objInventario = new inventario();
            objInventario.setModel((String)Inventariovist.getTablaInventario().getValueAt(selectRow , 0));
            objInventario.setCodigo((String)Inventariovist.getTablaInventario().getValueAt(selectRow, 1));
            objInventario.setTalla(Integer.parseInt((String)Inventariovist.getTablaInventario().getValueAt(selectRow, 2)));
            objInventario.setColor((String)Inventariovist.getTablaInventario().getValueAt(selectRow, 3));
            objInventario.setPrecioCosto(Integer.parseInt((String)Inventariovist.getTablaInventario().getValueAt(selectRow, 4)));
            IDinventario = objInventario.ObtenerIdInventario(objInventario);
            Inventariovist.getTxtCodigo().setText(objInventario.getCodigo());
            Inventariovist.getTxtColor().setText(objInventario.getColor());
            Inventariovist.getTxtCosto().setText(String.valueOf(objInventario.getPrecioCosto()));
            Inventariovist.getTxtTalla().setText(String.valueOf(objInventario.getTalla()));
            Inventariovist.getTxtModelo().setText(objInventario.getModel());

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


    public Menu_Principal_Controlador(PrincipalVista menu) {
        this.menu = menu;
        Iniciar();
    }

    private void Iniciar(){
        JPanel gestionarV = gestionarVentas.getPanelusuario();
        JPanel registropa = Registrovist.getPanelusuario();
        JPanel inventariopa = Inventariovist.getPanelInventario();
        JPanel usuariopa = Usuariovist.getPanelusuario();
        JPanel registrovent = RegsitroVentas.getPanelregistroventas();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        JPanel menupr = menu.getPanelprincipal();
        mainPanel.add(menupr , "MenuPrincipal");
        mainPanel.add(usuariopa , "GestionUsuario");
        mainPanel.add(inventariopa , "GestionInventario");
        mainPanel.add(registropa , "RegistroInventario");
        mainPanel.add(registrovent, "RegistroVentas");
        mainPanel.add(gestionarV , "GestionarVentas");
        Usuariovist.getTablaUsuario().addMouseListener(this);
        Inventariovist.getTablaInventario().addMouseListener(this);

        menu.add(mainPanel ,BorderLayout.CENTER);

        menu.getGestionUsuario().addActionListener(_-> {
            cardLayout.show(mainPanel, "GestionUsuario");

            model.CargarUsuarios();
            Usuariovist.getBtneliminar().addActionListener(_-> {
                try {
                    if(Usuariovist.getTablaUsuario().isRowSelected(selectRow)){
                        model.EliminarUsuario(String.valueOf(Usuariovist.getTablaUsuario().getValueAt(selectRow , 2)));
                    }
                    else {
                        throw new NullPointerException();
                    }
                    Limpiarcampos(Usuariovist.getTxtnombre(), Usuariovist.getTxttelefono(), Usuariovist.getTxtusuario() , Usuariovist.getTxtcontra());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null , "Debe seleccionar un usuario de la tabla  ");
                }
            });
            Usuariovist.getBtnactualizar().addActionListener(_ ->{
                try{
                    model.ActualizarUsuario(Usuariovist.getTxtnombre().getText() , Usuariovist.getTxttelefono().getText(), Usuariovist.getTxtusuario().getText() , Usuariovist.getTxtcontra().getText() ,names);
                    Limpiarcampos(Usuariovist.getTxtnombre(), Usuariovist.getTxttelefono(), Usuariovist.getTxtusuario() , Usuariovist.getTxtcontra());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Debe completar los campos para poder actualizar");
                }
            });


        });
        menu.getRegistrarProducto().addActionListener(_ -> {
            cardLayout.show(mainPanel, "RegistroInventario");
            Registrovist.getBtnregistrar().addActionListener(_->{
                modelo_inventario.AgregarProducto(Registrovist.getTxtmodelo() , Registrovist.getTxtcodigo() , Registrovist.getCbbtalla() ,Registrovist.getCbbcolor() ,Registrovist.getTxtcosto());
                modelo_inventario.CargarDatos();
            });

        });
        menu.getGestionarInventario().addActionListener(_ -> {
            cardLayout.show(mainPanel, "GestionInventario");
            modelo_inventario.CargarDatos();
            Inventariovist.getBtneliminar().addActionListener(_ ->{
                try {
                    if(Inventariovist.getTablaInventario().isRowSelected(selectRow)){
                        modelo_inventario.EliminarProducto(IDinventario);
                        modelo_inventario.CargarDatos();
                    }
                    else {
                        throw new NullPointerException();
                    }
                    Limpiarcampos(Inventariovist.getTxtCodigo() , Inventariovist.getTxtColor() , Inventariovist.getTxtModelo() , Inventariovist.getTxtCosto() , Inventariovist.getTxtTalla());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null , "Debe seleccionar un producto de la tabla  ");
                }
            });
            Inventariovist.getBtnactualizar().addActionListener(_->{
                try {
                    modelo_inventario.ModificarProducto(Inventariovist.getTxtTalla().getText(), Inventariovist.getTxtModelo().getText(), Inventariovist.getTxtColor().getText(), Inventariovist.getTxtCodigo().getText(), Inventariovist.getTxtCosto().getText(), IDinventario, selectRow);
                    modelo_inventario.CargarDatos();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Debe llenar los campos requeridos :  " + e.getMessage());
                }
                Limpiarcampos(Inventariovist.getTxtCodigo() , Inventariovist.getTxtColor() , Inventariovist.getTxtModelo() , Inventariovist.getTxtCosto() , Inventariovist.getTxtTalla());
            });

        });
        menu.getRegistrarVenta().addActionListener(_ -> {
           cardLayout.show(mainPanel , "RegistroVentas");
        });
        menu.getGestionarVentas().addActionListener(_ -> {
            cardLayout.show(mainPanel, "GestionarVentas");
        });
        menu.getCerrarSesion().addActionListener(_ -> {
            menu.dispose();
            LoginVista vista = new LoginVista();
            Modelo_Login modelologin = new Modelo_Login();
            new FrmLoginUsuario_Controlador(vista, modelologin);
            vista.setVisible(true);

        });

    }
    private void Limpiarcampos(JTextField... campos) {
        for(JTextField camp : campos) {
            camp.setText("");
            camp.requestFocus();
        }
    }


}
