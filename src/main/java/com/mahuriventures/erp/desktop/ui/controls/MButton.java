package com.mahuriventures.erp.desktop.ui.controls;

import javax.swing.*;

public class MButton extends JButton {
    public MButton(String title,ImageIcon img){
        super(title,img);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        //setOpaque(false);
        //setBackground(Color.decode("#EEEEEE"));
        //setBorderPainted(false);
    }
}
