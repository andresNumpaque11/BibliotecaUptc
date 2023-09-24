package view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Andres
 */
public class MainWindow extends JFrame {
    
    private PanelHeader panelHeader;
    private PanelDatas panelDatas;
    private panelImage panelImage;
    private PanelSearch panelSearch;
    private PanelDelete panelDelete;

    public MainWindow(ActionListener listener) {
        initComponents(listener);
        this.setTitle("Biblioteca Uptc");
        this.setSize(1360, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private void initComponents(ActionListener listener){
        this.setLayout(null);
        panelHeader = new PanelHeader(listener);
        panelHeader.setBounds(0, 0, 1360, 100);
        add(panelHeader);
        panelDatas = new PanelDatas(listener);
        panelDatas.setBounds(0, 101, 680, 600);
        add(panelDatas);
         panelSearch = new PanelSearch(listener);
        panelSearch.setBounds(0, 101, 680, 600);
        add(panelSearch);
        panelDelete = new PanelDelete(listener);
        panelDelete.setBounds(0, 101, 680, 600);
        add(panelDelete);
        panelImage = new panelImage();
        panelImage.setBounds(680, 101, 680, 600);
        add(panelImage);
        
    }

    public PanelDatas getPanelDatas() {
        return panelDatas;
    }

    public PanelSearch getPanelSearch() {
        return panelSearch;
    }

    public PanelDelete getPanelDelete() {
        return panelDelete;
    }
    
    public void openCloseDatas(boolean  b){
        panelDatas.setVisible(b);
    }
    public void openCloseSearch(boolean  b){
        panelSearch.setVisible(b);
    }
    public void openCloseDelete(boolean  b){
        panelDelete.setVisible(b);
    }
    

}
