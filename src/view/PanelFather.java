package view;

import java.awt.Cursor;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class PanelFather extends JPanel {

    public PanelFather() {
    }

    public void createButton(String path, JButton buttonGeneric, int x, int y, int w, int h) {
        buttonGeneric.setOpaque(false);
        buttonGeneric.setContentAreaFilled(false);
        buttonGeneric.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonGeneric.setBorderPainted(false);
        buttonGeneric.setFocusable(false);
        buttonGeneric.setBounds(x, y, w, h);
        ImageIcon images = new ImageIcon(path);
        Icon icon = new ImageIcon(images.getImage().getScaledInstance(buttonGeneric.getWidth(), buttonGeneric.getHeight(), Image.SCALE_DEFAULT));
        buttonGeneric.setIcon(icon);
        this.add(buttonGeneric);
    }
}
