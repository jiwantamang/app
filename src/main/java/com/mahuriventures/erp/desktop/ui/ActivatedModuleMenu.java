package com.mahuriventures.erp.desktop.ui;

import com.mahuriventures.erp.desktop.ui.controls.MButton;
import com.mahuriventures.erp.desktop.ui.discuss.DiscussPanel;
import com.mahuriventures.erp.desktop.util.ColorCodeConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivatedModuleMenu extends JPanel implements ActionListener{

    private MButton discuss;
    private MButton calender;
    private MButton contacts;
    private MButton settings;

    public ActivatedModuleMenu(){

        this.setLayout(new GridBagLayout());
        setBackground(Color.decode(ColorCodeConstants.PANEL_BACKGROUND_MAIN));

        discuss = new MButton("Discuss",new ImageIcon(ClassLoader.getSystemResource("images/discussion_50x50.png")));
        addMenu(discuss,0,0);
        discuss.addActionListener(this);

        calender = new MButton("Calendar",new ImageIcon(ClassLoader.getSystemResource("images/calendar_50x50.png")));
        addMenu(calender,1,0);

        contacts = new MButton("Contacts",new ImageIcon(ClassLoader.getSystemResource("images/contacts_50x50.png")));
        addMenu(contacts,0,1);

        settings = new MButton("Settings",new ImageIcon(ClassLoader.getSystemResource("images/setting_50x50.png")));
        addMenu(settings,1,1);


    }

    private void addMenu(JButton button,int x, int y){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = x;
        gbc.gridy = y;
        //gbc.weightx = x;
        //gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(button,gbc);
    }

   private ImageIcon getImage(String image){
        return null;
   }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == discuss){
            // show the discuss panel
            DashBoard.updateMainPanel(new DiscussPanel());
        }
    }
}
