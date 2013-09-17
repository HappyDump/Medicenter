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
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_FNAME = "fname";
    private static final String COL_EMAIL = "email";
    private static final String COL_AGE = "age";
    private static final String COL_STREET = "street";
    private static final String COL_STREETNO = "streetno";
    private static final String COL_COUNTRY = "country";
    private static final String COL_CITY = "city";
    private static final String COL_DESC = "desc";
    private static final String COL_GENDER = "gender";
    private static final String COL_BPLACE = "birthplace";
    private static final String COL_PHONE = "phone";
    private static final String COL_SSN = "ssn";

    private static final String CREATE_BDD = "CREATE_TABLE " + TABLE_PATIENT + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT NOT NULL, " + COL_FNAME + " TEXT NOT NULL, " + COL_EMAIL + " TEXT NOT NULL, " + COL_AGE + " TEXT NOT NULL, " + COL_CITY + " TEXT NOT NULL, " + COL_COUNTRY + " TEXT NOT NULL, " +
            COL_STREET + " TEXT NOT NULL, " + COL_STREETNO + " TEXT NOT NULL, " + COL_DESC + " TEXT NOT NULL " + COL_GENDER + " TEXT NOT NULL " + COL_BPLACE + " TEXT NOT NULL " +
            COL_PHONE + " TEXT NOT NULL " + COL_SSN + " TEXT NOT NULL);";

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
