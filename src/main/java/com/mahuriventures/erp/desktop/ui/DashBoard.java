package com.mahuriventures.erp.desktop.ui;

import com.mahuriventures.erp.desktop.ui.menubar.BillingMenu;
import com.mahuriventures.erp.desktop.ui.menubar.MenuBar;
import com.mahuriventures.erp.desktop.util.UIStaticConstants;
import com.mahuriventures.erp.util.Constants;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame{
    private MenuBar menuBar;
    public static MainPanel mainPanel = new MainPanel();

    public DashBoard(){
        this.setTitle(Constants.APP_NAME+Constants.VERSION);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());
        menuBar = new MenuBar();
        menuBar.addJMenu(new BillingMenu("Billing"));
        add(menuBar,BorderLayout.NORTH);
        paintMainPanel();

    }

    public void paintMainPanel(){
        add(mainPanel,BorderLayout.CENTER);
        repaint();
    }

    public static void updateMainPanel(JPanel panel){
        mainPanel.removeAll();
        mainPanel.add(panel,BorderLayout.CENTER);
        mainPanel.revalidate();
    }
}
