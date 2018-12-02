package com.example.matt.project_ui;

public class CatalogItem {
    private String ProsItem;
    private String ConsItem;
    private String workoutInfo;
    private String workoutTitle;
    private int imageID;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getWorkoutTitle() {
        return workoutTitle;
    }

    public void setWorkoutTitle(String workoutTitle) {
        this.workoutTitle = workoutTitle;
    }


    public String getWorkoutInfo() {
        return workoutInfo;
    }

    public void setWorkoutInfo(String workoutInfo) {
        this.workoutInfo = workoutInfo;
    }

    public String getProsItem() {
        return ProsItem;
    }

    public void setProsItem(String prosItem) {
        ProsItem = prosItem;
    }

    public String getConsItem() {
        return ConsItem;
    }

    public void setConsItem(String consItem) {
        ConsItem = consItem;
    }
}
