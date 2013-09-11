package com.medicenter.medicenterphysician;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 30/05/13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "Medicenter";
    private static final String TABLE_PATIENTS = "patients";
    private static final String TABLE_MEETING = "meeting";
    private static final String TABLE_PRESCRIPTION = "prescription";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_AGE = "age";
    private static final String KEY_STREET = "street";
    private static final String KEY_STREETNO = "streetno";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_CITY = "city";
    private static final String KEY_DESC = "desc";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_BPLACE = "birthplace";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_SSN = "ssn";

    private static final String KEY_MEETING_ID = "id";
    private static final String KEY_MEETING_PATIENTID = "patientid";
    private static final String KEY_MEETING_DATE = "date";
    private static final String KEY_MEETING_OBS = "obs";

    private static final String KEY_PRESCRIPTION_ID = "id";
    private static final String KEY_PRESCRIPTION_PATIENTID = "patientid";
    private static final String KEY_PRESCRIPTION_MEETINGID = "meetingid";
    private static final String KEY_PRESCRIPTION_MEDICATION = "medication";
    private static final String KEY_PRESCRIPTION_DURATION = "duration";
    private static final String KEY_PRESCRIPTION_DOSE = "dose";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_PATIENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT," + KEY_FNAME + " TEXT," + KEY_EMAIL + " TEXT," + KEY_AGE + " TEXT," + KEY_STREET +
                " TEXT," + KEY_STREETNO + " TEXT," + KEY_COUNTRY + " TEXT," + KEY_CITY + " TEXT,"
                + KEY_DESC + " TEXT" + ")";
        db.execSQL(CREATE_PATIENT_TABLE);
        String CREATE_MEETING_TABLE = "CREATE TABLE " + TABLE_MEETING + "(" + KEY_MEETING_ID + " INTEGER PRIMARY KEY,"
                + KEY_MEETING_PATIENTID + " INTEGER," + KEY_MEETING_DATE + " TEXT," + KEY_MEETING_OBS + " TEXT" +
                ")";
        db.execSQL(CREATE_MEETING_TABLE);
        String CREATE_PRESCRIPTION_TABLE = "CREATE TABLE " + TABLE_PRESCRIPTION + "(" + KEY_PRESCRIPTION_ID + " INTEGER PRIMARY KEY,"
                + KEY_PRESCRIPTION_PATIENTID + " INTEGER," + KEY_PRESCRIPTION_MEETINGID + " INTEGER,"
                + KEY_PRESCRIPTION_MEDICATION + " TEXT," + KEY_PRESCRIPTION_DURATION + " TEXT," + KEY_PRESCRIPTION_DOSE + " TEXT" +
                ")";
        db.execSQL(CREATE_PRESCRIPTION_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEETING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRESCRIPTION);
        onCreate(db);
    }

    public void addPatient(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, patient.getName());
        values.put(KEY_FNAME, patient.getfName());
        values.put(KEY_EMAIL, patient.getEmail());
        values.put(KEY_AGE, patient.getAge());
        values.put(KEY_CITY, patient.getCity());
        values.put(KEY_COUNTRY, patient.getCountry());
        values.put(KEY_STREET, patient.getStreet());
        values.put(KEY_STREETNO, patient.getStreetNo());
        values.put(KEY_DESC, patient.getDesc());
        values.put(KEY_GENDER, patient.getGender());
        values.put(KEY_BPLACE, patient.getBirthPlace());
        values.put(KEY_PHONE, patient.getPhone());
        values.put(KEY_SSN, patient.getSsn());

        db.insert(TABLE_PATIENTS, null, values);
        db.close();
    }

    public void addMeeting(Meeting meeting) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MEETING_OBS, meeting.getObs());
        values.put(KEY_MEETING_DATE, meeting.getDate());
        values.put(KEY_MEETING_PATIENTID, meeting.patientId);

        db.insert(TABLE_MEETING, null, values);
        db.close();
    }

    public void addPrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRESCRIPTION_PATIENTID, prescription.getPatientId());
        values.put(KEY_PRESCRIPTION_MEETINGID, prescription.getMeetingId());
        values.put(KEY_PRESCRIPTION_MEDICATION, prescription.getMedic());
        values.put(KEY_PRESCRIPTION_DURATION, prescription.getDuration());
        values.put(KEY_PRESCRIPTION_DOSE, prescription.getDose());

        db.insert(TABLE_PRESCRIPTION, null, values);
        db.close();
    }

    public Patient getPatient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PATIENTS, new String[]{KEY_ID, KEY_NAME, KEY_FNAME, KEY_EMAIL, KEY_AGE,
                KEY_CITY, KEY_COUNTRY, KEY_STREET, KEY_STREETNO,
                KEY_DESC}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Patient patient = new Patient(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
        return patient;
    }

    public Meeting getMeeting(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_MEETING, new String[]{KEY_MEETING_ID,
                KEY_MEETING_PATIENTID, KEY_MEETING_DATE, KEY_MEETING_OBS,},
                KEY_MEETING_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Meeting meeting = new Meeting(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3));
        return meeting;
    }

    public Prescription getPrescription(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRESCRIPTION, new String[]{KEY_PRESCRIPTION_ID,
                KEY_PRESCRIPTION_PATIENTID, KEY_PRESCRIPTION_MEETINGID, KEY_PRESCRIPTION_MEDICATION,
                KEY_PRESCRIPTION_DURATION, KEY_PRESCRIPTION_DOSE,},
                KEY_PRESCRIPTION_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Prescription prescription = new Prescription(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return prescription;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patientList = new ArrayList<Patient>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PATIENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient patient = new Patient();
                patient.setId(Integer.parseInt(cursor.getString(0)));
                patient.setName(cursor.getString(1));
                patient.setfName(cursor.getString(2));
                patient.setAge(cursor.getString(3));
                patient.setEmail((cursor.getString(4)));
                patient.setCity((cursor.getString(5)));
                patient.setCountry((cursor.getString(6)));
                patient.setStreet((cursor.getString(7)));
                patient.setStreetNo((cursor.getString(8)));
                patient.setDesc(cursor.getString(9));
                // Adding patient to list
                patientList.add(patient);
            } while (cursor.moveToNext());
        }

        // return contact list
        return patientList;
    }

    public List<Meeting> getAllMeetings() {
        List<Meeting> meetingList = new ArrayList<Meeting>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEETING;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Meeting meeting = new Meeting();
                meeting.setId(Integer.parseInt(cursor.getString(0)));
                meeting.setPatientId(Integer.parseInt(cursor.getString(1)));
                meeting.setDate(cursor.getString(2));
                meeting.setObs(cursor.getString(3));
                meetingList.add(meeting);
            } while (cursor.moveToNext());
        }

        // return contact list
        return meetingList;
    }

    public List<Prescription> getAllPrescriptions() {
        List<Prescription> prescriptionList = new ArrayList<Prescription>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRESCRIPTION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Prescription prescription = new Prescription();
                prescription.setId(Integer.parseInt(cursor.getString(0)));
                prescription.setPatientId(Integer.parseInt(cursor.getString(1)));
                prescription.setMeetingId(Integer.parseInt(cursor.getString(2)));
                prescription.setMedic(cursor.getString(3));
                prescription.setDuration(cursor.getString(4));
                prescription.setDose(cursor.getString(5));
                prescriptionList.add(prescription);
            } while (cursor.moveToNext());
        }

        // return contact list
        return prescriptionList;
    }

    public List<Meeting> getAllMeetingsById(int patientId) {
        List<Meeting> meetingList = new ArrayList<Meeting>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEETING + " WHERE patientid='" + patientId + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_MEETING, new String[]{KEY_MEETING_ID,
                KEY_MEETING_PATIENTID, KEY_MEETING_DATE, KEY_MEETING_OBS,},
                KEY_MEETING_PATIENTID + "=?", new String[]{String.valueOf(patientId)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Meeting meeting = new Meeting();
                meeting.setId(Integer.parseInt(cursor.getString(0)));
                meeting.setPatientId(Integer.parseInt(cursor.getString(1)));
                meeting.setDate(cursor.getString(2));
                meeting.setObs(cursor.getString(3));
                meetingList.add(meeting);
            } while (cursor.moveToNext());
        }

        // return contact list
        return meetingList;
    }

    public List<Prescription> getAllPrescriptionsById(int meetingId) {
        List<Prescription> prescriptionList = new ArrayList<Prescription>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRESCRIPTION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_PRESCRIPTION, new String[]{KEY_PRESCRIPTION_ID,
                KEY_PRESCRIPTION_PATIENTID, KEY_PRESCRIPTION_MEETINGID, KEY_PRESCRIPTION_MEDICATION,
                KEY_PRESCRIPTION_DURATION, KEY_PRESCRIPTION_DOSE,},
                KEY_PRESCRIPTION_MEETINGID + "=?", new String[]{String.valueOf(meetingId)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Prescription prescription = new Prescription();
                prescription.setId(Integer.parseInt(cursor.getString(0)));
                prescription.setPatientId(Integer.parseInt(cursor.getString(1)));
                prescription.setMeetingId(Integer.parseInt(cursor.getString(2)));
                prescription.setMedic(cursor.getString(3));
                prescription.setDuration(cursor.getString(4));
                prescription.setDose(cursor.getString(5));
                prescriptionList.add(prescription);
            } while (cursor.moveToNext());
        }

        // return contact list
        return prescriptionList;
    }

    public int getPatientCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PATIENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }

    public int getMeetingCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MEETING;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }

    public int getPrescriptionCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PRESCRIPTION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }


    public int getMeetingCountById(int patientId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_MEETING, new String[]{KEY_MEETING_ID,
                KEY_MEETING_PATIENTID, KEY_MEETING_DATE, KEY_MEETING_OBS,},
                KEY_MEETING_PATIENTID + "=?", new String[]{String.valueOf(patientId)}, null, null, null, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }

    public int getPrescriptionCountById(int meetingId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRESCRIPTION, new String[]{KEY_PRESCRIPTION_ID,
                KEY_PRESCRIPTION_PATIENTID, KEY_PRESCRIPTION_MEETINGID, KEY_PRESCRIPTION_MEDICATION,
                KEY_PRESCRIPTION_DURATION, KEY_PRESCRIPTION_DOSE,},
                KEY_PRESCRIPTION_MEETINGID + "=?", new String[]{String.valueOf(meetingId)}, null, null, null, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }


    public int updatePatient(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, patient.getName());
        values.put(KEY_FNAME, patient.getfName());
        values.put(KEY_EMAIL, patient.getEmail());
        values.put(KEY_AGE, patient.getAge());
        values.put(KEY_COUNTRY, patient.getCountry());
        values.put(KEY_CITY, patient.getCity());
        values.put(KEY_STREET, patient.getStreet());
        values.put(KEY_STREETNO, patient.getStreetNo());
        values.put(KEY_DESC, patient.getDesc());

        // updating row
        return db.update(TABLE_PATIENTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(patient.getId())});
    }

    public int updateMeeting(Meeting meeting) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MEETING_DATE, meeting.getDate());
        values.put(KEY_MEETING_OBS, meeting.getObs());
        values.put(KEY_MEETING_PATIENTID, meeting.getPatientId());

        // updating row
        return db.update(TABLE_MEETING, values, KEY_ID + " = ?",
                new String[]{String.valueOf(meeting.getId())});
    }

    public int updatePrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRESCRIPTION_PATIENTID, prescription.getPatientId());
        values.put(KEY_PRESCRIPTION_MEETINGID, prescription.getMeetingId());
        values.put(KEY_PRESCRIPTION_MEDICATION, prescription.getMedic());
        values.put(KEY_PRESCRIPTION_DURATION, prescription.getDuration());
        values.put(KEY_PRESCRIPTION_DOSE, prescription.getDose());

        // updating row
        return db.update(TABLE_PRESCRIPTION, values, KEY_PRESCRIPTION_ID + " = ?",
                new String[]{String.valueOf(prescription.getId())});
    }

    public void deletePatient(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PATIENTS, KEY_ID + " = ?",
                new String[]{String.valueOf(patient.getId())});
        db.close();
    }

    public void deleteMeeting(Meeting meeting) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MEETING, KEY_MEETING_ID + " = ?",
                new String[]{String.valueOf(meeting.getId())});
        db.close();
    }

    public void deletePrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRESCRIPTION, KEY_PRESCRIPTION_ID + " = ?",
                new String[]{String.valueOf(prescription.getId())});
        db.close();
    }


    public void clearTable() {
        SQLiteDatabase sdb = this.getWritableDatabase();
        sdb.delete(TABLE_PATIENTS, null, null);
        sdb.delete(TABLE_MEETING, null, null);
        sdb.delete(TABLE_PRESCRIPTION, null, null);
    }
}
