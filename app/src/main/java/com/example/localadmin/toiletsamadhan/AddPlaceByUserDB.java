package com.example.localadmin.toiletsamadhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import junit.runner.Version;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by localadmin on 15/09/17.
 */

public class AddPlaceByUserDB extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "ToiletSamadhan.db";
    public static final String TABLE_NAME = "AddPlaces";
    public static final String COLUMN_ID = "id integer primary key";
    public static final String LATITUDE = "latitude double";
    public static final String LONGITUDE = "longitude double";
//    public static final String RATINGS = "ratings integer";
    public static final String COMMENTS = "comments text";
    public static final String PLACENAME = "place_name text";
    public static final String DESCRIPTION = "place_description text";
    private HashMap hashMap;
    private String createTableString = "create table if NOT exists ";
    private String commaSpace = ", ";
    SQLiteDatabase db;
    public AddPlaceByUserDB(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.d("entererd onCreateDB","");
//        String createTableQuery = createTableString + TABLE_NAME +"( " + COLUMN_ID + commaSpace +
////                LATITUDE + commaSpace + LONGITUDE + commaSpace + PLACENAME + commaSpace + DESCRIPTION + commaSpace + COMMENTS + commaSpace + RATINGS+");";
//                LATITUDE + commaSpace + LONGITUDE + commaSpace + PLACENAME + commaSpace + DESCRIPTION + commaSpace + COMMENTS+ ");";
        String createTableQuery = "create table AddPlaces if NOT exists(id integer primary key, latitude double, longitude double,"+
                " place_name text, place_description text, comments text);";
        sqLiteDatabase.execSQL(createTableQuery);
        Log.d("exit onCreateDB","");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS AddPlaces");
        onCreate(sqLiteDatabase);
    }

//    public boolean insertNewPlace (double latitude, double longitude, String placeName, String placeDesc ,String comments, int ratings) {
    public boolean insertNewPlace (double latitude, double longitude, String placeName, String placeDesc, String comments) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("latitude", latitude);
        contentValues.put("longitude", longitude);
        contentValues.put("place_name", placeName);
        contentValues.put("place_description", placeDesc);
        contentValues.put("comments", comments);
//        contentValues.put("ratings", ratings);
//        contentValues.put("ratings", ratings);
        db.insert("AddPlaces", null, contentValues);
        return true;
    }
    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }
    public ArrayList<String> getAllPaces() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from AddPlaces", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_ID)));
            res.moveToNext();
        }
        return array_list;
    }
}
