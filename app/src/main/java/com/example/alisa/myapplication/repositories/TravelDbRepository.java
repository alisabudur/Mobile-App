package com.example.alisa.myapplication.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alisa.myapplication.database.SQLDbHelper;
import com.example.alisa.myapplication.domain.Travel;
import com.example.alisa.myapplication.repositories.interfaces.ITravelRepository;

import java.util.ArrayList;
import java.util.List;

import static com.example.alisa.myapplication.database.TravelReaderContract.TravelEntry;

/**
 * Created by Alisa on 11/30/2016.
 */

public class TravelDbRepository implements ITravelRepository {
    private SQLDbHelper dbHelper;
    private String[] allColumns = {"*"};
    private static ITravelRepository singleton;

    private TravelDbRepository(Context context) {
        dbHelper = new SQLDbHelper(context);
    }

    public static ITravelRepository getInstance(Context context){
        if(singleton == null){
            singleton = new TravelDbRepository(context);
        }
        return singleton;
    }

    @Override
    public List<Travel> getTravelsByUser(long userId) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        List<Travel> travels = new ArrayList<>();
        Cursor cursor = database.query(TravelEntry.TABLE_NAME, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Travel travel = cursorToTravel(cursor);
            travels.add(travel);
            cursor.moveToNext();
        }
        dbHelper.close();
        return travels;
    }

    @Override
    public void updateTravel(Travel travel) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TravelEntry.COLUMN_START_LOCATION, travel.getStartLocation());
        values.put(TravelEntry.COLUMN_END_LOCATION, travel.getEndLocation());

        String updateSelection = TravelEntry._ID + " = " + travel.getId();

        int count = database.update(TravelEntry.TABLE_NAME, values, updateSelection, null);
    }

    @Override
    public long addTravel(Travel travel) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String path = database.getPath();
        ContentValues values = new ContentValues();
        values.put(TravelEntry.COLUMN_START_LOCATION, travel.getStartLocation());
        values.put(TravelEntry.COLUMN_END_LOCATION, travel.getEndLocation());
        long insertId = database.insert(TravelEntry.TABLE_NAME, null, values);
        dbHelper.close();
        return insertId;
    }

    private Travel cursorToTravel(Cursor cursor) {
        Travel travel = new Travel();
        travel.setId(cursor.getLong(0));
        travel.setStartLocation(cursor.getString(1));
        travel.setEndLocation(cursor.getString(2));
        return travel;
    }
}
