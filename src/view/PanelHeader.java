package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class PanelHeader extends PanelFather {
    
    private JButton btnAdd, btnDelete,  btnSearch;
    private JTextField txtSearch;

    public PanelHeader(ActionListener listener) {
        this.setBackground(new Color(22, 34, 63));
        this.setLayout(null);
        initComponents(listener);
        
    }
    private void initComponents(ActionListener listener){
        btnAdd = new JButton();
        btnAdd.addActionListener(listener);
        btnAdd.setActionCommand("add");
        createButton("src/resources/buttonadd.png", btnAdd, 50, 20, 200, 50);
        btnSearch = new JButton();
        btnSearch.addActionListener(listener);
        btnSearch.setActionCommand("search");
        createButton("src/resources/btnSearch.png", btnSearch, 270, 20, 200, 50);
        btnDelete = new JButton();
        btnDelete.addActionListener(listener);
        btnDelete.setActionCommand("delete");
        createButton("src/resources/btnDelete.png", btnDelete, 500, 20, 200, 50);
        
    }
  
    
}
