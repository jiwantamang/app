package com.mahuriventures.erp.desktop.ui.menubar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillingMenu extends JMenu{

    public BillingMenu(String name)
    {
        setText(name);
        // create event handler object
        MouseClickHandler mouseClickHandler = new MouseClickHandler();
        this.addBilling = new JMenuItem("Add Billing");
        add(addBilling);
        addBilling.addActionListener(mouseClickHandler);
        this.deleteBilling = new JMenuItem("Delete Billing");
        add(deleteBilling);

    }

    private JMenuItem addBilling;
    private JMenuItem deleteBilling;

    private class MouseClickHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == addBilling){
                System.out.println("Add Billing Clicked");
            }
        }
    }
}


