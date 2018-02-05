package com.mahuriventures.erp.desktop.ui.discuss;

import javax.swing.*;
import java.awt.*;

public class DiscussPanel extends JPanel{
    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private ViewPanel viewPanel;

    public DiscussPanel(){
        this.topPanel = new TopPanel();
        this.leftPanel = new LeftPanel();
        this.viewPanel = new ViewPanel();
        setLayout(new BorderLayout(0,0));
        add(topPanel,BorderLayout.NORTH);

        // add the left panel
        this.leftPanel = new LeftPanel();
        add(leftPanel,BorderLayout.WEST);


    }

}
