package Controlador;

import Modelo.*;
import Vista.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.util.ArrayList;


public class Menu_Principal_Controlador implements MouseListener {
    private final PrincipalVista menu;
    private  JPanel mainPanel;
    private  CardLayout cardLayout;
    private int selectRow;
    public String names ;
    public int IDinventario;
    public int IDusuario;
    usuario objUsuario;
    inventario objInventario;
    producto objProducto;
    ventas objVentas;
    public ArrayList<ventas> listaVentas = new  ArrayList<>();
    public ArrayList<Integer> inventarioConsumido = new  ArrayList<>();

    private  final  gestionUsuarioVista Usuariovist = new gestionUsuarioVista();
    private final gestioninventarioVista Inventariovist = new gestioninventarioVista();
    private final registroInventarioVista Registrovist = new registroInventarioVista();
    private final  registroVentaVista RegistroVentas = new registroVentaVista();
    private final GestionarVentasVista gestionarVentas = new GestionarVentasVista();

    private final Modelo_GestionarUsuario model = new Modelo_GestionarUsuario(Usuariovist);
    private final Modelo_Inventario modelo_inventario = new Modelo_Inventario(Inventariovist);
    private final Modelo_RegistrarVentas modelo_registro_ventas = new Modelo_RegistrarVentas(RegistroVentas);
    private final ModeloGestionarVentas model_gestionar_ventas = new ModeloGestionarVentas(gestionarVentas);
    private final VentaPDF pdf = new VentaPDF();
    @SuppressWarnings("NonAsciiCharacters")
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==Usuariovist.getTablaUsuario()) {
            names = (String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 0));
            selectRow = Usuariovist.getTablaUsuario().getSelectedRow();
            objUsuario = new usuario();
            Usuariovist.getTxtnombre().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 0)));
            Usuariovist.getTxttelefono().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow , 1)));
            Usuariovist.getTxtusuario().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow , 2)));
            Usuariovist.getTxtcontra().setText((String)(Usuariovist.getTablaUsuario().getValueAt(selectRow  , 3)));
            objUsuario.setApellidoynombre(Usuariovist.getTxtnombre().getText());
            objUsuario.setContraseña(Usuariovist.getTxtcontra().getText());
            objUsuario.setTelefono(Usuariovist.getTxttelefono().getText());
            objUsuario.setNombUsuario(Usuariovist.getTxtusuario().getText());
            IDusuario = objUsuario.ObtenerIdUsuario(objUsuario);

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
        if(e.getSource()==RegistroVentas.getTablaInventario()){
            selectRow = RegistroVentas.getTablaInventario().getSelectedRow();
            objInventario = new inventario();
            objInventario.setModel((String)RegistroVentas.getTablaInventario().getValueAt(selectRow , 0));
            objInventario.setCodigo((String)RegistroVentas.getTablaInventario().getValueAt(selectRow, 1));
            objInventario.setTalla(Integer.parseInt(String.valueOf(RegistroVentas.getTablaInventario().getValueAt(selectRow, 2))));
            objInventario.setColor((String)RegistroVentas.getTablaInventario().getValueAt(selectRow, 3));
            int id = objInventario.ObtenerIdInventario(objInventario);
            int preciocosto = objInventario.ObtenerPrecio(id);
            objInventario.setIdinventario(id);
            objInventario.setPrecioCosto(preciocosto);
        }
        if(e.getSource()==gestionarVentas.getTablaInventario()){
            selectRow = gestionarVentas.getTablaInventario().getSelectedRow();
            objVentas = new ventas();
            objVentas.setCliente((String)gestionarVentas.getTablaInventario().getValueAt(selectRow , 0));
            objVentas.setCodigo((String)gestionarVentas.getTablaInventario().getValueAt(selectRow , 1));
            objVentas.setMetododepago((String)gestionarVentas.getTablaInventario().getValueAt(selectRow , 5));
            objVentas.setPrecio((Integer) gestionarVentas.getTablaInventario().getValueAt(selectRow , 6));
            objVentas.setHoraventa((Timestamp) gestionarVentas.getTablaInventario().getValueAt(selectRow , 7));
            objVentas.setTelefono((String)gestionarVentas.getTablaInventario().getValueAt(selectRow,8));


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
        RegistroVentas.getTablaInventario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Usuariovist.getTablaUsuario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        RegistroVentas.getTablacarrito().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Iniciar();
    }

    private void Iniciar(){
        JPanel gestionarV = gestionarVentas.getPanelusuario();
        JPanel registropa = Registrovist.getPanelusuario();
        JPanel inventariopa = Inventariovist.getPanelInventario();
        JPanel usuariopa = Usuariovist.getPanelusuario();
        JPanel registrovent = RegistroVentas.getPanelregistroventas();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        JPanel menupr = menu.getPanelprincipal();
        mainPanel.add(menupr , "MenuPrincipal");
        mainPanel.add(usuariopa , "GestionUsuario");
        mainPanel.add(inventariopa , "GestionInventario");
        mainPanel.add(registropa , "RegistroInventario");
        mainPanel.add(registrovent, "RegistroVentas");
        mainPanel.add(gestionarV , "GestionarVentas");

        RegistroVentas.getTablaInventario().addMouseListener(this);
        RegistroVentas.getTablacarrito().addMouseListener(this);
        Usuariovist.getTablaUsuario().addMouseListener(this);
        Inventariovist.getTablaInventario().addMouseListener(this);
        gestionarVentas.getTablaInventario().addMouseListener(this);

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
                    model.Limpiarcampos(Usuariovist.getTxtnombre(), Usuariovist.getTxttelefono(), Usuariovist.getTxtusuario() , Usuariovist.getTxtcontra());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null , "Debe seleccionar un usuario de la tabla  ");
                }
            });
            Usuariovist.getBtnactualizar().addActionListener(_ ->{
                try{
                    model.ActualizarUsuario(Usuariovist.getTxtnombre().getText() , Usuariovist.getTxttelefono().getText(), Usuariovist.getTxtusuario().getText() , Usuariovist.getTxtcontra().getText() ,IDusuario);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Debe completar los campos para poder actualizar");
                }
                model.Limpiarcampos(Usuariovist.getTxtnombre(), Usuariovist.getTxttelefono(), Usuariovist.getTxtusuario() , Usuariovist.getTxtcontra());
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
                    modelo_inventario.LimpiarCampos(Inventariovist.getTxtCodigo() , Inventariovist.getTxtColor() , Inventariovist.getTxtModelo() , Inventariovist.getTxtCosto() , Inventariovist.getTxtTalla());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null , "Debe seleccionar un producto de la tabla  ");
                }
            });
            Inventariovist.getBtnactualizar().addActionListener(_->{
                try {
                    modelo_inventario.ModificarProducto(Inventariovist.getTxtTalla().getText(), Inventariovist.getTxtModelo().getText(), Inventariovist.getTxtColor().getText(), Inventariovist.getTxtCodigo().getText(), Inventariovist.getTxtCosto().getText(), IDinventario, selectRow);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Debe llenar los campos requeridos :  " + e.getMessage());
                }
                modelo_inventario.LimpiarCampos(Inventariovist.getTxtCodigo() , Inventariovist.getTxtColor() , Inventariovist.getTxtModelo() , Inventariovist.getTxtCosto() , Inventariovist.getTxtTalla());
            });

        });
        menu.getRegistrarVenta().addActionListener(_ -> {
           cardLayout.show(mainPanel , "RegistroVentas");
           RegistroVentas.getBtnbuscar().addActionListener(_ -> {
               try {
                   if (!RegistroVentas.getTxtcodigo2().getText().isEmpty() || !String.valueOf(RegistroVentas.getCbbtallas().getSelectedItem()).equals("Seleccionar una talla") || !String.valueOf(RegistroVentas.getCbbcolor().getSelectedItem()).equals("Seleccionar un color")) {
                       modelo_registro_ventas.CargarInventarioD(String.valueOf(RegistroVentas.getCbbtallas().getSelectedItem()), String.valueOf(RegistroVentas.getCbbcolor().getSelectedItem()), RegistroVentas.getTxtcodigo2().getText());
                   }else{
                    JOptionPane.showMessageDialog(null,"Debe llenar alguno de los campos requeridos para realizar la busqueda");
                   }
               }catch (Exception e) {
                   JOptionPane.showMessageDialog(null, "Error en la busqueda: " + e.getMessage());
               }
               modelo_registro_ventas.LimpiarCampos(RegistroVentas.getTxtcodigo2());
           });
           RegistroVentas.getBtnregistrar().addActionListener(_->{
               try{
                   ImageIcon icon = new ImageIcon("src/Recursos/iconoPregunta.png");
                   Image image = icon.getImage();
                   Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // Reducir el tamaño a 50x50
                   ImageIcon newIcon = new ImageIcon(newimg);
                   ArrayList<producto> productos = new ArrayList<producto>();
                   productos = modelo_registro_ventas.RegistrarVenta(listaVentas , inventarioConsumido);
                   JOptionPane.showMessageDialog(null , "Venta realizada con exito :D");
                   Object[] opciones= {"Aceptar" , "Cancelar"};
                   int respuesta = JOptionPane.showOptionDialog(
                           null,
                           "¿Deseas generar una boleta en pdf?",
                           "Confirmación",
                           JOptionPane.DEFAULT_OPTION,
                           JOptionPane.QUESTION_MESSAGE,
                           newIcon,
                           opciones,
                           opciones[0] // Opción predeterminada
                   );
                   if(respuesta==0){
                       ArrayList<ventas> resultados = new ArrayList<>();
                       resultados = pdf.DatosCliente(objVentas.getCliente());
                       pdf.generarFactura(productos , resultados);
                   }
                   DefaultTableModel model1 = (DefaultTableModel) RegistroVentas.getTablacarrito().getModel();
                   model1.setRowCount(0);
                   DefaultTableModel model2 = (DefaultTableModel) RegistroVentas.getTablaInventario().getModel();
                   model2.setRowCount(0);
               }catch (Exception e){
                   JOptionPane.showMessageDialog(null, "Debe llenar los campos requeridos :  " + e.getMessage());
               }

           });
           RegistroVentas.getBtnCarrito().addActionListener(_->{
                modelo_registro_ventas.Agregar_aCarrito(objInventario , String.valueOf(RegistroVentas.getTxtprecioventa().getText()) , String.valueOf(RegistroVentas.getCbbmetodo().getSelectedItem()) , RegistroVentas.getTxttelefono().getText());
                objVentas = new ventas();
                objVentas.setCliente(RegistroVentas.getTxtcliente().getText());
                objVentas.setMetododepago(String.valueOf(RegistroVentas.getCbbmetodo().getSelectedItem()));
                objVentas.setTelefono( RegistroVentas.getTxttelefono().getText());
                objVentas.setCodigo(RegistroVentas.getTxtcodigo2().getText());
                objVentas.setPrecio(Integer.parseInt(String.valueOf(RegistroVentas.getTxtprecioventa().getText())));
                listaVentas.add(objVentas);
                inventarioConsumido.add(objInventario.getIdInventario());
           });


        });
        menu.getGestionarVentas().addActionListener(_ -> {
            cardLayout.show(mainPanel, "GestionarVentas");
            model_gestionar_ventas.cargarDatos();
        });
        menu.getCerrarSesion().addActionListener(_ -> {
            menu.dispose();
            LoginVista vista = new LoginVista();
            Modelo_Login modelologin = new Modelo_Login();
            new FrmLoginUsuario_Controlador(vista, modelologin);
            vista.setVisible(true);

        });

    }
}
