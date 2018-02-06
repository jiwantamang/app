package com.mahuriventures.erp.desktop.ui.setting.CustomList;

import com.mahuriventures.erp.desktop.models.ModuleEntity;

import javax.swing.*;
import java.awt.*;

public class ModuleRenderer extends JPanel implements ListCellRenderer<ModuleEntity> {
    private JLabel title;
    private Image imageIcon;
    private JTextPane description;
    public ModuleRenderer(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder());
        setOpaque(true);
        title = new JLabel();
        description = new JTextPane();
        description.setEditable(false);


    }



    @Override
    public Component getListCellRendererComponent(JList<? extends ModuleEntity> list, ModuleEntity value, int index, boolean isSelected, boolean cellHasFocus) {
        Long id = value.getId();
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/boxes-brown_25x25.png"));
        //setIcon(imageIcon);
        //setText(value.getTitle());

        title.setText(value.getTitle());
        imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/boxes-brown_25x25.png"));
        description.setText(value.getDescription());

        add(new JLabel(imageIcon),BorderLayout.WEST);
        add(title,BorderLayout.NORTH);
        add(description,BorderLayout.CENTER);

        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            description.setBackground(list.getSelectionBackground());
            description.setForeground(list.getSelectionForeground());
        }else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            description.setBackground(list.getBackground());
            description.setForeground(list.getForeground());
        }

        return this;
    }


}
