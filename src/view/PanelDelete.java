package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class PanelDelete extends PanelFather {
      private JTextField search;
    private JButton deleteName, deleteCode;

    public PanelDelete(ActionListener listener) {
        initComponents(listener);
        
    }

    private void initComponents(ActionListener listener) {
        this.setVisible(false);
        this.setBackground(Color.white);
        search = new JTextField(50);
        search.setBounds(10, 10, 300, 30);
        add(search);
        deleteName = new JButton();
        createButton("src/resources/btnDeleteName.png", deleteName, 10, 50, 150, 30);
        deleteName.addActionListener(listener);
        deleteName.setActionCommand("deleteName");
        add(deleteName);
        deleteCode = new JButton();
        createButton("src/resources/btnDeleteCode.png", deleteCode,170, 50, 150, 30);
        deleteCode.addActionListener(listener);
        deleteCode.setActionCommand("deleteCode");
        add(deleteCode);
    } 
    
    public JTextField getSearch() {
        return search;
    }
    
}
