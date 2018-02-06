package com.mahuriventures.erp.desktop.ui.setting.CustomList;

public class ModuleEntity {
    private Long id;
    private String title;
    private String description;
    private boolean isInstalled;

    public ModuleEntity(){

    }

    public ModuleEntity(Long id, String title, String description, boolean isInstalled) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isInstalled = isInstalled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInstalled() {
        return isInstalled;
    }

    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }

    @Override
    public String toString() {
        return this.title.toUpperCase();
    }
}
