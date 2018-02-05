package com.mahuriventures.erp.desktop.ui;

import com.mahuriventures.erp.desktop.util.UIStaticConstants;
import com.mahuriventures.erp.util.Constants;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame{
    public DashBoard(){
        this.setTitle(Constants.APP_NAME+Constants.VERSION);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        // add the menu bar
        this.add(menuBar);
        for (String menu: UIStaticConstants.menuList) {
            this.menuBar.add(new JMenu(menu));
        }


    }

    private static JMenuBar menuBar = new JMenuBar();

}
