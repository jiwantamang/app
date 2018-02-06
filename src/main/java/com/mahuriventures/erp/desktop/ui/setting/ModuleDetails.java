package com.mahuriventures.erp.desktop.ui.setting;

import com.mahuriventures.erp.desktop.ui.setting.CustomList.ModuleEntity;

import javax.swing.*;
import java.awt.*;

public class ModuleDetails extends JDialog{
    public ModuleDetails(JDialog jDialog,ModuleEntity entity){
        super(jDialog,entity.getTitle(), ModalityType.DOCUMENT_MODAL);
        setSize((int)(jDialog.getWidth() / 1.2),(int) (jDialog.getHeight()/1.2));

    }
}
