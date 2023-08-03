package com.example.newshunt.model;

public class LanguageModel {
    private String name;
    private boolean isSelected;

    public LanguageModel(String name) {
        this.name = name;
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}