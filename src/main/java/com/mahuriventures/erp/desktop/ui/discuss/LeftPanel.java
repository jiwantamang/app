package com.mahuriventures.erp.desktop.ui.discuss;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LeftPanel extends JPanel{
    public LeftPanel(){
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(300,getHeight()));

        JLabel label_inbox = new JLabel("Inbox");

        label_inbox.setForeground(Color.WHITE);

        add(label_inbox);
    }
}
