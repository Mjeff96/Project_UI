package com.example.matt.project_ui;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<CatalogItem> createListItems(DatabaseManager db){
        List<CatalogItem> items = new ArrayList<>();
        ArrayList<String> proItems = db.getColumnData("pros", "Arms");
        ArrayList<String> conItems = db.getColumnData("cons", "Arms");
        ArrayList<String> workoutDesc = db.getColumnData("description", "Arms");
        ArrayList<String> workoutTitles = db.getColumnData("name", "Arms");
        int[] imageIDS = {R.drawable.deadlift,R.drawable.benchpress};


        for(int i=0;i<proItems.size(); i++){
            CatalogItem catalogItem = new CatalogItem();

            catalogItem.setProsItem(proItems.get(i));
            catalogItem.setConsItem(conItems.get(i));
            catalogItem.setWorkoutInfo(workoutDesc.get(i));
            catalogItem.setWorkoutTitle(workoutTitles.get(i));
            catalogItem.setImageID(imageIDS[i]);

            items.add(catalogItem);
        }

        return items;
    }
}
