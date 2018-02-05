package com.mahuriventures.erp.desktop.ui;

import com.mahuriventures.erp.desktop.util.ColorCodeConstants;
import com.mahuriventures.erp.desktop.util.UIStaticConstants;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    private JPanel dashboardInfo;

    private JLabel txt_title = new JLabel(UIStaticConstants.WELCOME_TEXT);
    private Font font = new Font("Arial",Font.BOLD,15);

    public MainPanel(){

        setLayout(new BorderLayout());

        txt_title.setForeground(Color.white);


        dashboardInfo = new JPanel();
        dashboardInfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        dashboardInfo.add(txt_title);
        dashboardInfo.setBackground(Color.decode(ColorCodeConstants.PANEL_HEADING_COLOR));
        add(dashboardInfo,BorderLayout.NORTH);

        addDashboardMenu();


    }

    // display the core modules
    private void addDashboardMenu(){
        this.add(new ActivatedModuleMenu(),BorderLayout.CENTER);
    }

}
