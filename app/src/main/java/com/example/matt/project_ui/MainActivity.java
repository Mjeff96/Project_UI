package com.example.matt.project_ui;

import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Catalog Button
        Button CatalogButton = (Button) findViewById(R.id.CatalogButton);
        CatalogButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_catalog(v);
            }
        });

        //Account Button
        Button AccountButton = (Button) findViewById(R.id.AccountButton);
        AccountButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_myaccount(v);
            }
        });


        //Settings Button
        Button settingsButton = (Button) findViewById(R.id.SettingsButton);
        settingsButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_settings(v);
            }
        });
        setTitle("Workout App");

        GraphView graphView = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graphView.addSeries(series);
        graphView.getGridLabelRenderer().setNumVerticalLabels(2);
        graphView.getGridLabelRenderer().setNumHorizontalLabels(6);
        series.setColor(Color.parseColor("#FF00574B"));
        series.setThickness(12);
        series.setDrawBackground(true);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(12);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"M","Tu","W","Th","F","Sa","Su"});
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graphView.getViewport().setXAxisBoundsManual(true);
    }

    private DataPoint [] getDataPoint(){
        DataPoint [] dp = new DataPoint[]{
                new DataPoint(0,0.5),
                new DataPoint(1,1),
                new DataPoint(2,1.2),
                new DataPoint(3,2),
                new DataPoint(4,0),
                new DataPoint(5,0.5),
                new DataPoint(6,1.3)
        };
        return(dp);
    }


    // Navigation Bar Button Definitions
    //////////////////////////////////////////////////////////////////////////////
    public void next_page_catalog(View v) {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }

    public void next_page_myaccount(View v) { //Should be Account Activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void next_page_settings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    //////////////////////////////////////////////////////////////////////////////////
}