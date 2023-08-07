package com.example.newshunt.model;

public class HowTo {
    private String title;
    private int imageResourceId; // Use an integer to store the resource ID of the image
    private String description;

    public HowTo(String title, int imageResourceId, String description) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
