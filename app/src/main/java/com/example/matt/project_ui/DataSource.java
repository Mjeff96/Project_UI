package com.example.matt.project_ui;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<CatalogItem> createListItems(DatabaseManager db){
        List<CatalogItem> items = new ArrayList<>();
        ArrayList<String> textItems = db.getColumnData("category", "Arms");

        for(int i=0;i<textItems.size(); i++){
            CatalogItem catalogItem = new CatalogItem();

            catalogItem.setTextitem(textItems.get(i));

            items.add(catalogItem);
        }

        return items;
    }
}
