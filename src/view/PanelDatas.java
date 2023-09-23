package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Andres
 */
public class PanelDatas extends JPanel {

    private JLabel tittle, code,tomo,editorial,library;
    private JLabel nameAuthor, lastName,biography;
    private JLabel campus, Facultad;
    
    private JTextField txtTitle,txtCode,txtTomo,txtEditorial,txtLibrary;
    private JTextField txtName,txtlastName,txtBiography;
    private JTextField txtCampus,txtFacultad;
    
    private JButton btnOk;
    private JButton cancel;

    public PanelDatas(ActionListener listener) {
        this.setLayout(null);
        this.setVisible(false);
        this.setBackground(Color.white);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        
        tittle = new JLabel("Titulo: ");
        tittle.setBounds(20, 20, 100, 10);
        add(tittle);
        code = new JLabel("Codigo ISBN: ");
        tomo = new JLabel("Tomo: ");
        editorial = new JLabel("editorial:");
        tittle = new JLabel("Biblioteca:");
        tittle = new JLabel("Titulo:");
        tittle = new JLabel("Titulo:");
        tittle = new JLabel("Titulo:");
    }
    
    
    
    
    
    
    
    
}
