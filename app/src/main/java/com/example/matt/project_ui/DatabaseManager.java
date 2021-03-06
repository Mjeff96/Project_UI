package com.example.matt.project_ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DatabaseManager extends SQLiteOpenHelper {
    SQLiteDatabase mydatabase;

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "WorkoutInfo";
    private static final String TABLE_WORKOUT_DETAILS = "WorkoutData";
    private static final String KEY_ID = "id";
    private static final String KEY_CATAGORY = "category";
    private static final String KEY_NAME = "name";
    private static final String KEY_MG = "musclegroup";
    private static final String KEY_DIFFICULTY = "difficulty";
    private static final String KEY_PROS = "pros";
    private static final String KEY_CONS = "cons";
    private static final String KEY_DESCRIPTION = "description";

    AssetManager assetManager;

    public DatabaseManager(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);
        assetManager = context.getAssets();
        mydatabase = getWritableDatabase();
        onUpgrade(mydatabase, 1 ,2 );
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_WORKOUT_DETAIL_TABLE = "CREATE TABLE " + TABLE_WORKOUT_DETAILS + "("
                + KEY_ID + " TEXT,"
                + KEY_CATAGORY + " TEXT,"
                + KEY_NAME + " TEXT, "
                + KEY_MG + " TEXT, "
                + KEY_DIFFICULTY + " TEXT, "
                + KEY_PROS + " TEXT, "
                + KEY_CONS + " TEXT, "
                + KEY_DESCRIPTION + " TEXT" + ")";

        db.execSQL(CREATE_WORKOUT_DETAIL_TABLE);
        String arms_file = "ArmsData.csv";
        String legs_file = "LegsData.csv";
        String yoga_file = "YogaData.csv";
        try {
            populateData(db, arms_file);
          //  populateData(db, legs_file);
            //populateData(db, yoga_file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT_DETAILS);

        onCreate(db);
    }

    public void populateData(SQLiteDatabase db, String fileName) throws IOException {
        String assetName = fileName;
        InputStream input = assetManager.open(assetName);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
        String line = "";
        String tableName = TABLE_WORKOUT_DETAILS;
        String columns = KEY_ID + "," + KEY_CATAGORY + "," + KEY_NAME + "," + KEY_MG + ","
               + KEY_DIFFICULTY + "," + KEY_PROS + "," + KEY_CONS + "," + KEY_DESCRIPTION;
        String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
        String str2 = ");";

        db.beginTransaction();
        while ((line = buffer.readLine()) != null) {
            StringBuilder sb = new StringBuilder(str1);
            String[] str = line.split(",");
            sb.append("'" + str[0] + "','");
            sb.append(str[1] + "','");
            sb.append(str[2] + "','");
            sb.append(str[3] + "','");
            sb.append(str[4] + "','");
            sb.append(str[5] + "','");
            sb.append(str[6] + "','");
            sb.append(str[7] + "'");
            sb.append(str2);
            db.execSQL(sb.toString());
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    //IDS = Arms, Yoga, Legs
    public ArrayList<String> getColumnData(String column_name, String id) {
        ArrayList<String> values = new ArrayList<String>();
        String querry = "SELECT " + column_name + " FROM " + TABLE_WORKOUT_DETAILS + " WHERE id = '" + id + "';";
        Cursor cursor = mydatabase.rawQuery(querry, null);

        if(cursor.moveToFirst()) {
            do {
                values.add(cursor.getString(cursor.getColumnIndex(column_name)));
            }while(cursor.moveToNext());
        }

        cursor.close();
        return values;
    }
}
