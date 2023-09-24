/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.AVLTree;
import model.Author;
import model.Book;
import model.TreeNode;

/**
 *
 * @author PC
 */
public class Results extends JDialog {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnClose;

    public Results() {
        initComponents();
        this.setTitle("Tabla de Libros");
        this.setVisible(false);
        this.setSize(800, 400);
        createTable();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(table);
        add(jsp, BorderLayout.NORTH);
        btnClose = new JButton("Cerrar");
        add(btnClose, BorderLayout.SOUTH);
    }

    private void createTable() {
        tableModel.addColumn("Titulo");
        tableModel.addColumn("Codigo ISBN");
        tableModel.addColumn("Nombre del autor");
        tableModel.addColumn("Apellido del autor");
    }

    private void fillTable(TreeNode node) {
        if (node != null) {
            fillTable(node.getLeft());
            Book book = node.getData();
            Author author = book.getAutor();
            Object[] row = {
                    book.getTitle(),
                    book.getCodeISBN(),
                    author.getName(),
                    author.getLastName(),
            };
            tableModel.addRow(row);
            fillTable(node.getRight());
        }
    }

    public void openCloseWindow(boolean b) {
        this.setVisible(b);
    }

    public void refreshTable(AVLTree tree) {
        tableModel.setRowCount(0);
        fillTable(tree.getRoot());
    }

    public void showOnly(ArrayList<Book> books) {
        tableModel.setRowCount(0);
        for (Book book : books) {
            Author author = book.getAutor();
            Object[] row = {
                    book.getTitle(),
                    book.getCodeISBN(),
                    author.getName(),
                    author.getLastName(),
            };
            tableModel.addRow(row);
        }
    }
}
