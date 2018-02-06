package com.mahuriventures.erp.desktop.ui.setting.CustomList;

import javax.swing.*;

public class MarketPlaceListModel extends AbstractListModel<ModuleEntity>{
    private int length;

    public MarketPlaceListModel(int n){
        length = n;
    }
    public int getSize() {
        return length;
    }

    public ModuleEntity getElementAt(int index) {
        return null;
    }
}
