package com.mahuriventures.erp.desktop.ui.menubar;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuBar extends JMenuBar{

    public MenuBar(){
        this.organizationMenu = new OrganizationMenu();
        add(organizationMenu);

        this.settingMenu = new SettingMenu();
        add(settingMenu);
    }

    public void addJMenu(JMenu menu){
        this.add(menu);
        repaint();
    }

    // create a core menu bar
    private final OrganizationMenu organizationMenu;
    private final SettingMenu settingMenu;

}
