package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class panelImage extends JPanel  {
    private JLabel imageLabel;

    public panelImage() {
        this.setLayout(null);
        this.setBackground(Color.white);
        imageLabel = new JLabel(new ImageIcon(this.getClass().getResource("/resources/imagen.png")));
        imageLabel.setBounds(150, 100   , 520, 320);
        add(imageLabel);
    }
    
    
    
   

   
    
    
    
}
