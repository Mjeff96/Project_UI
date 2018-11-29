package com.example.matt.project_ui;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<CatalogItem> createListItems(DatabaseManager db){
        List<CatalogItem> items = new ArrayList<>();
        ArrayList<String> proItems = db.getColumnData("pros", "Arms");
        ArrayList<String> conItems = db.getColumnData("cons", "Arms");
        ArrayList<String> workoutItems = db.getColumnData("musclegroup", "Arms");
        ArrayList<String> workoutTitles = db.getColumnData("name", "Arms");

        for(int i=0;i<proItems.size(); i++){
            CatalogItem catalogItem = new CatalogItem();

            catalogItem.setProsItem(proItems.get(i));
            catalogItem.setConsItem(conItems.get(i));
            catalogItem.setWorkoutInfo(workoutItems.get(i));
            catalogItem.setWorkoutTitle(workoutTitles.get(i));

            items.add(catalogItem);
        }

        return items;
    }
}
