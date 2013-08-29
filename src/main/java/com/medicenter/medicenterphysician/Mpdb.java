package com.medicenter.medicenterphysician;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Database Connection class.
 */

public class Mpdb extends SQLiteOpenHelper {

    private static final String TABLE_PATIENT = "patient_table";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "name";
    private static final String COL_FNAME = "fName";
    private static final String COL_L_MEET = "lastMeet";
    private static final String COL_N_MEET = "nextMeet";
    private static final String COL_DESC = "desc";

    private static final String CREATE_BDD = "CREATE_TABLE " + TABLE_PATIENT + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT NOT NULL, " +
            COL_FNAME + " TEXT NOT NULL, " + COL_L_MEET + " TEXT NOT NULL, " + COL_N_MEET + " TEXT NOT NULL, " + COL_DESC + " TEXT NOT NULL);";

    public Mpdb(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL(CREATE_BDD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        arg0.execSQL("DROP_TABLE" + TABLE_PATIENT + ";");
        onCreate(arg0);
    }

}
