package com.mahuriventures.erp.desktop.service;

import com.mahuriventures.erp.desktop.models.ModuleEntity;

import javax.swing.*;
import java.util.List;

public interface MarketService {
    public DefaultListModel<ModuleEntity> getAllMarketModule();
}
