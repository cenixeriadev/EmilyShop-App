package Utilitario;

import javax.swing.*;
import java.awt.*;

public class PantallaCarga extends JFrame{

    public PantallaCarga(){
        setSize(200,200);
        setLocation(600,200);
        setUndecorated(true);
        add(PantallaCar());


    }
    public JPanel PantallaCar() {
        JPanel panel = new JPanel();
        BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.Y_AXIS );
        panel.setLayout(layoutMgr);
        try {
            ClassLoader cldr = this.getClass().getClassLoader();
            java.net.URL imageURL = cldr.getResource("Recursos/pantallaCarga.gif");
            if (imageURL == null) throw new NullPointerException();
            ImageIcon imageIcon = new ImageIcon(imageURL);
            Image si = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
            imageIcon = new ImageIcon(si);
            JLabel iconLabel = new JLabel();
            iconLabel.setIcon(imageIcon);
            imageIcon.setImageObserver(iconLabel);

            panel.add(iconLabel);
            return panel;
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null , "Url del gif no pudo ser encontrada");
        }
        return panel;
    }


}
