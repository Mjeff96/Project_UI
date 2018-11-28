package com.example.matt.project_ui;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String[] textItems = {"Temp1", "Temp2", "Temp3"};

    public static List<CatalogItem> createListItems(){
        List<CatalogItem> items = new ArrayList<>();

        for(int i=0;i<textItems.length; i++){
            CatalogItem catalogItem = new CatalogItem();

            catalogItem.setTextitem(textItems[i]);

            items.add(catalogItem);
        }

        return items;
    }
}
