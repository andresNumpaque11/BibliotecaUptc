package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class PanelSearch  extends PanelFather{
    
    private JTextField search;
    private JButton btnSearchName, BtnSearchCode;

    public PanelSearch(ActionListener listener) {
        initComponents(listener);
        
    }

    private void initComponents(ActionListener listener) {
        this.setVisible(false);
        this.setBackground(Color.white);
        search = new JTextField(50);
        search.setBounds(10, 10, 300, 30);
        add(search);
        btnSearchName = new JButton();
        btnSearchName.addActionListener(listener);
        btnSearchName.setActionCommand("searchName");
        createButton("src/resources/btnSearchName.png", btnSearchName, 10, 50, 150, 30);
        add(btnSearchName);
        BtnSearchCode = new JButton();
        BtnSearchCode.addActionListener(listener);
        BtnSearchCode.setActionCommand("searchCode");
        createButton("src/resources/btnSearchCode.png", BtnSearchCode,170, 50, 150, 30);
        add(BtnSearchCode);
    }
    
    
    
    
    
    
}
