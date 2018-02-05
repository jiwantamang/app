package com.mahuriventures.erp.desktop.ui.menubar;

import com.mahuriventures.erp.desktop.ui.DashBoard;
import com.mahuriventures.erp.desktop.ui.setting.MarketPlace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingMenu extends JMenu {
    private final String MENU_NAME = "Setting";

    private JMenuItem marketPlace;

    public SettingMenu(){
        setText(MENU_NAME);

        // create a action handler object
        MouseClickHandler mouseClickHandler = new MouseClickHandler();

        this.marketPlace = new JMenuItem("Market Place");
        add(marketPlace);
        this.marketPlace.addActionListener(mouseClickHandler);

    }

    class MouseClickHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == marketPlace){
                JFrame frame = (JFrame) JFrame.getFrames()[0];
                MarketPlace marketPlace = new MarketPlace(frame);
                marketPlace.setSize(new Dimension((int)(getParent().getParent().getWidth() / 1.5),(int)(getParent().getParent().getHeight()/1.3)));
                marketPlace.setLocationRelativeTo(getParent().getParent());
                marketPlace.setVisible(true);

            }
        }
    }
}



