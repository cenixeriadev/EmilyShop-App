package Controlador;
import Modelo.Modelo_Inventario;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;


public class FrmInventarios_Controlador  implements  MouseListener{
    private final FrInventarios_Vista vistainventario;
    private final Inventario_Vista MpVista  = new Inventario_Vista();
    private final ArrayList<String>  valores = new ArrayList<>();
    private boolean keyadd = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistainventario.getTablaInventario()) {
            CompletableFuture<Void> future = new CompletableFuture<>();

            if(!keyadd) {
                vistainventario.getTablaInventario().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            // Cuando se presiona ENTER, completa el CompletableFuture
                            future.complete(null);
                        }
                    }
                });
            }
            keyadd = true;
            // Una vez que se complete el futuro (al presionar ENTER), carga los datos de la fila
            future.thenRunAsync(() -> {
                int selectedRow = vistainventario.getTablaInventario().getSelectedRow();
                if (selectedRow >= 0) {
                    valores.clear();
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, 0));
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, 1));
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, 2));
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, 3));
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, 4));
                    valores.add((String) vistainventario.getTablaInventario().getValueAt(selectedRow, 5));
                    valores.add(String.valueOf(selectedRow));

                    // Imprime los valores después de cargarlos
                }
            });
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

        //Agregando listeners a los botones para que funcionen
        //
        vistainventario.getTablaInventario().addMouseListener(this);

        vistainventario.getBtnVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Inventario_Controlador  cont = new Inventario_Controlador(MpVista);
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                MpVista.setVisible(true);
                vistainventario.dispose();

            }

        });
        vistainventario.getBtnEliminar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                mod.EliminarProducto(Integer.parseInt(valores.get(5)));

            }
        });
        vistainventario.getBtnActualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Modelo_Inventario mod = new Modelo_Inventario(vistainventario);
                mod.ModificarProducto(valores.get(0), valores.get(1),valores.get(2),valores.get(3),valores.get(4)  , Integer.parseInt(valores.get(5)) , Integer.parseInt(valores.get(6)));

            }
        });
    }

}
