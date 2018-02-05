package com.mahuriventures.erp.desktop.ui.menubar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrganizationMenu extends JMenu implements ActionListener{
    private final JMenuItem exit;
    public OrganizationMenu(){
        setText("Organization");
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        add(exit);

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
    }

}
