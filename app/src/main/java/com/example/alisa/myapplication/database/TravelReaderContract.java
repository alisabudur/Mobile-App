package com.example.alisa.myapplication.database;

import android.provider.BaseColumns;

/**
 * Created by Alisa on 11/30/2016.
 */

public class TravelReaderContract {

    private TravelReaderContract() {
    }

    public static class TravelEntry implements BaseColumns {
        public static final String TABLE_NAME = "travel";
        public static final String COLUMN_START_LOCATION = " start_location ";
        public static final String COLUMN_END_LOCATION = " end_location ";
    }
}
