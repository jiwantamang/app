package com.mahuriventures.erp.desktop.models;

public class ModuleEntity {
    private Long id;
    private String title;
    private String description;
    private boolean isInstalled;
    private String url;

    public ModuleEntity(){

    }

    public ModuleEntity(Long id, String title, String description, boolean isInstalled,String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isInstalled = isInstalled;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.title.toUpperCase();
    }
}
