package com.mahuriventures.erp.desktop.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mahuriventures.erp.desktop.manager.json.MarketPlaceJson;
import com.mahuriventures.erp.desktop.manager.json.impl.MarketPlaceJsonImpl;
import com.mahuriventures.erp.desktop.models.ModuleEntity;
import com.mahuriventures.erp.desktop.service.MarketService;

import javax.swing.*;
import java.util.List;

public class MarketServiceImpl implements MarketService{
    private MarketPlaceJson marketPlaceJsonRepo;

    public MarketServiceImpl(){
        this.marketPlaceJsonRepo = new MarketPlaceJsonImpl();
    }


    @Override
    public DefaultListModel<ModuleEntity> getAllMarketModule() {
        DefaultListModel<ModuleEntity> moduleList = new DefaultListModel<>();
//        moduleList.addElement(new ModuleEntity(1L,"CRM","Customer Relation Management",false));
//        moduleList.addElement(new ModuleEntity(2L,"Billing","Thie module allows you to create a billing",false));
//        moduleList.addElement(new ModuleEntity(3L,"Website","Create and manage your own website",false));
//        moduleList.addElement(new ModuleEntity(4L,"Inventory","Manage all the inventory of your organization",false));

        Gson gson = new Gson();
        JsonArray jsonArray;

        try{
            jsonArray = marketPlaceJsonRepo.getMarketModules();
            for (JsonElement object:jsonArray
                 ) {
                ModuleEntity moduleEntity = gson.fromJson(object.toString(),ModuleEntity.class);
                moduleList.addElement(moduleEntity);
            }



        }catch (Exception e){
            e.printStackTrace();
        }


        return moduleList;
    }
}
