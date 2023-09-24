package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Andres
 */
public class PanelDatas extends PanelFather {

    private JLabel tittle, code, tomo, editorial, library;
    private JLabel nameAuthor, lastName, biography;
    private JLabel campus, facultad;

    private JTextField txtTitle, txtCode, txtTomo, txtEditorial, txtLibrary;
    private JTextField txtName, txtlastName, txtBiography;
    private JTextField txtCampus, txtFacultad;

    private JButton btnOk;
    private JButton cancel;

    public PanelDatas(ActionListener listener) {
        this.setLayout(null);
        this.setVisible(false);
        this.setBackground(Color.white);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridLayout(11, 2));

        // Título del formulario
        TitledBorder titleBorder = BorderFactory.createTitledBorder("Información del Libro y Autor");
        this.setBorder(titleBorder);

        tittle = new JLabel("Titulo: ");
        add(tittle);
        txtTitle = new JTextField(10);
        add(txtTitle);
        code = new JLabel("Codigo ISBN: ");
        add(code);
        txtCode = new JTextField(10);
        add(txtCode);
        tomo = new JLabel("Tomo: ");
        add(tomo);
        txtTomo = new JTextField(10);
        add(txtTomo);
        editorial = new JLabel("editorial:");
        add(editorial);
        txtEditorial = new JTextField(10);
        add(txtEditorial);
        library = new JLabel("Biblioteca:");
        add(library);
        txtLibrary = new JTextField(10);
        add(txtLibrary);

        //Autor
        nameAuthor = new JLabel("Nombre:");
        add(nameAuthor);
        txtName = new JTextField(10);
        add(txtName);
        lastName = new JLabel("Apellido:");
        add(lastName);
        txtlastName = new JTextField(10);
        add(txtlastName);
        biography = new JLabel("Biografía");
        add(biography);
        txtBiography = new JTextField(10);
        add(txtBiography);

        //Sede
        campus = new JLabel("Campus: ");
        add(campus);
        txtCampus = new JTextField(10);
        add(txtCampus);
        facultad = new JLabel("Facultad: ");
        add(facultad);
        txtFacultad = new JTextField(10);
        add(txtFacultad);

        //botones
        btnOk = new JButton();
        btnOk.addActionListener(listener);
        btnOk.setActionCommand("ok");
        createButton("src/resources/btnOk.png", btnOk, 1, 1, 100, 49);
        add(btnOk);
        cancel = new JButton();
        cancel.addActionListener(listener);
        cancel.setActionCommand("cancel");
        createButton("src/resources/btnCancel.png", cancel, 1, 1, 136, 49);
        add(cancel);

    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtCode() {
        return txtCode;
    }

    public JTextField getTxtlastName() {
        return txtlastName;
    }

    public JTextField getTxtTomo() {
        return txtTomo;
    }

    public JTextField getTxtTitle() {
        return txtTitle;
    }

    public JTextField getTxtCampus() {
        return txtCampus;
    }

    public JTextField getTxtLibrary() {
        return txtLibrary;
    }

    public JTextField getTxtFacultad() {
        return txtFacultad;
    }

    public JTextField getTxtBiography() {
        return txtBiography;
    }

    public JTextField getTxtEditorial() {
        return txtEditorial;
    }
    
    

    
    
    

}
