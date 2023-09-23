package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindow;

/**
 *
 * @author Andres
 */
public class Controller implements ActionListener{
    
    private MainWindow mw;

    public Controller() {
        mw = new MainWindow(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                mw.openCloseDatas(true);
                break;
        }
    }
    
    public static void main(String[] args) {
        new Controller();
    }
    
    
    
    
    
    
}
