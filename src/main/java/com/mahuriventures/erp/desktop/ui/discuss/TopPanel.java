package com.mahuriventures.erp.desktop.ui.discuss;

import com.mahuriventures.erp.desktop.util.ColorCodeConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    private JLabel title;
    private JTextField search;
    private JButton btnSearch;
    public TopPanel(){
        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
        setBackground(Color.decode(ColorCodeConstants.PANEL_HEADING_COLOR_1));

        title = new JLabel("Discussion");
        title.setForeground(Color.white);

        search = new JTextField(40);

        btnSearch = new JButton("Search");

        add(title);
        add(search);
        add(btnSearch);
    }
}
