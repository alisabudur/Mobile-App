package com.example.alisa.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.alisa.myapplication.database.TravelReaderContract.TravelEntry;

/**
 * Created by Alisa on 11/30/2016.
 */

public class SQLDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "Travels.db";
    private static final String COMMA_SEP = ", ";
    private static final String TEXT_TYPE = " TEXT ";
    private static final String TAG = SQLDbHelper.class.getSimpleName();
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TravelEntry.TABLE_NAME + "(" +
                    TravelEntry._ID + " INTEGER PRIMARY KEY " + COMMA_SEP +
                    TravelEntry.COLUMN_START_LOCATION + TEXT_TYPE + COMMA_SEP +
                    TravelEntry.COLUMN_END_LOCATION + TEXT_TYPE + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TravelEntry.TABLE_NAME;

    public SQLDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.v(TAG, "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
        Log.v(TAG, "onUpgrade");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
        Log.v(TAG, "onDowngrade");
    }
}
