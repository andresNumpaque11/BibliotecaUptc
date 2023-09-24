package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.AVLTree;
import model.Author;
import model.Book;
import view.MainWindow;

/**
 *
 * @author Andres
 */
public class Controller implements ActionListener {

    private MainWindow mw;
    private AVLTree tree;

    public Controller() {
        mw = new MainWindow(this);
        tree = new AVLTree();
    }

    private void add() {
        String tittle = mw.getPanelDatas().getTxtTitle().getText();
        String codISBN = mw.getPanelDatas().getTxtCode().getText();
        String tomotxt = mw.getPanelDatas().getTxtTomo().getText();
        String editorial = mw.getPanelDatas().getTxtEditorial().getText();
        String name = mw.getPanelDatas().getTxtName().getText();
        String lastName = mw.getPanelDatas().getTxtlastName().getText();
        String biography = mw.getPanelDatas().getTxtBiography().getText();
        if (tittle.isEmpty() || codISBN.isEmpty() || editorial.isEmpty() || tomotxt.isEmpty()
                || name.isEmpty() || lastName.isEmpty() || biography.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int tomo = Integer.parseInt(tomotxt);
                // Insertar el libro en el árbol
                tree.insert(new Book(tittle, codISBN, tomo, editorial, new Author(name, lastName, biography)));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo 'Tomo' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void search() {
        String name = mw.getPanelSearch().getSearch().getText();
        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            tree.searchByName(name);
        }
    }
     private Object[][] getDatas() {
        ArrayList<Book> list = sl.getPlayers();
        Object[][] datas = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            datas[i][0] = list.get(i).getNickName();
            datas[i][1] = list.get(i).getScore();
            datas[i][2] = list.get(i).getRecordScore();
        }
        return datas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                mw.openCloseDatas(true);
                mw.openCloseDelete(false);
                mw.openCloseSearch(false);
                add();
                break;
            case "search":
                mw.openCloseDatas(false);
                mw.openCloseDelete(false);
                mw.openCloseSearch(true);
                break;
            case "delete":
                mw.openCloseDelete(true);
                mw.openCloseDatas(false);
                mw.openCloseSearch(false);
            case "ok":
                add();
                mw.openCloseDatas(false);
                break;
            case "cancel":
                mw.openCloseDatas(false);
        }
    }

    public static void main(String[] args) {
        new Controller();
    }

}
