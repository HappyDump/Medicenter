package com.medicenter.medicenterphysician;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PatientBDD {
    private static final int VERSION_BDD = 1;
    private static final String NAME_BDD = "patients.db";

    private static final String TABLE_PATIENT = "patient_table";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NAME = "name";
    private static final int NUM_COL_NAME = 1;
    private static final String COL_FNAME = "fName";
    private static final int NUM_COL_FNAME = 2;
    private static final String COL_L_MEET = "lastMeet";
    private static final int NUM_COL_L_MEET = 3;
    private static final String COL_N_MEET = "nextMeet";
    private static final int NUM_COL_N_MEET = 4;
    private static final String COL_DESC = "desc";
    private static final int NUM_COL_DESC = 5;

    private SQLiteDatabase bdd;

    private Mpdb mydb;

    public PatientBDD(Context context) {
        mydb = new Mpdb(context, NAME_BDD, null, VERSION_BDD);
    }

    public void open() {
        bdd = mydb.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertPatient(Patient patient) {
        ContentValues values = new ContentValues();

        values.put(COL_NAME, patient.getName());
        values.put(COL_FNAME, patient.getfName());
        //values.put(COL_L_MEET, patient.getLastMeet());
        //values.put(COL_N_MEET, patient.getNextMeet());
        values.put(COL_DESC, patient.getDesc());

        return bdd.insert(TABLE_PATIENT, null, values);
    }

    public int updatePatient(int id, Patient patient) {
        ContentValues values = new ContentValues();

        values.put(COL_NAME, patient.getName());
        values.put(COL_FNAME, patient.getfName());
        //values.put(COL_L_MEET, patient.getLastMeet());
        //values.put(COL_N_MEET, patient.getNextMeet());
        values.put(COL_DESC, patient.getDesc());

        return bdd.update(TABLE_PATIENT, values, COL_ID + " = " + id, null);
    }

    public int removePatientWithID(int id, Patient patient) {
        return bdd.delete(TABLE_PATIENT, COL_ID + " = " + id, null);
    }

    public Patient getPatientWithName(String name) {
        Cursor cursor = bdd.query(TABLE_PATIENT, new String[]{COL_ID, COL_NAME, COL_FNAME, COL_L_MEET, COL_N_MEET, COL_DESC}, COL_NAME + " LIKE \"" + name + "\"", null, null, null, null);
        return cursorToPatient(cursor);
    }

    private Patient cursorToPatient(Cursor cursor) {
        if (cursor.getCount() == 0)//NOPMD
            return null;
        cursor.moveToFirst();

        Patient patient = new Patient();
        patient.setId(cursor.getInt(NUM_COL_ID));
        patient.setName(cursor.getString(NUM_COL_NAME));
        patient.setfName(cursor.getString(NUM_COL_FNAME));
        //patient.setLastMeet(cursor.getString(NUM_COL_L_MEET));
        //patient.setNextMeet(cursor.getString(NUM_COL_N_MEET));
        patient.setDesc(cursor.getString(NUM_COL_DESC));

        cursor.close();
        return patient;
    }
}
