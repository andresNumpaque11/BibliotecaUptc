package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        tree = new AVLTree();
        mw = new MainWindow(this);
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
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int tomo = Integer.parseInt(tomotxt);
                // Insertar el libro en el árbol
                Book test = new Book(tittle, codISBN, tomo, editorial, new Author(name, lastName, biography));
                tree.insert(test);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo 'Tomo' debe ser un número válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void searchByName() {
        String name = mw.getPanelSearch().getSearch().getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<Book> book = tree.searchByName(name);
            if (book != null) {
                mw.getResults().showOnly(book);
                mw.getResults().openCloseWindow(true);
            } else {
                JOptionPane.showMessageDialog(null, "El Titulo Buscado no coincide con ningun libro almacenado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void searchByCode() {
        String code = mw.getPanelSearch().getSearch().getText();
        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<Book> book = tree.searchByCode(code);
            if (book != null) {
                mw.getResults().showOnly(book);
                mw.getResults().openCloseWindow(true);
            } else {
                JOptionPane.showMessageDialog(null, "El Codigo Buscado no coincide con ningun libro almacenado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteByCode() {
        String code = mw.getPanelDelete().getSearch().getText();
        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los libros que coinciden con el codigo han sido eliminados.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tree.deleteByCode(code);
        }
    }

    public void deleteByName() {
        String name = mw.getPanelDelete().getSearch().getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los libros que coinciden con el nombre han sido eliminados.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tree.deleteAllByName(name);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                mw.openCloseDatas(true);
                mw.openCloseDelete(false);
                mw.openCloseSearch(false);
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
                break;
            case "ok":
                add();
                mw.openCloseDatas(false);
                break;
            case "cancel":
                mw.openCloseDatas(false);
            case "viewAll":
                mw.getResults().refreshTable(tree);
                mw.getResults().openCloseWindow(true);
                break;
            case "searchName":
                searchByName();
                break;
            case "searchCode":
                searchByCode();
                break;
            case "deleteCode":
                deleteByCode();
                break;
            case "deleteName":
                deleteByName();
                break;

        }
    }

    public static void main(String[] args) {
        new Controller();
    }

}
