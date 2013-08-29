package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created with IntelliJ IDEA.
 * User: Koj
 * Date: 13/05/13
 * Time: 18:44
 */
public class Appointment implements Parcelable {
    int id;
    int patientId;
    String notes;

    public Appointment(int id, int patientId, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.notes = notes;
    }

    public Appointment() {
        this.id = 0;
        this.patientId = 0;
        this.notes = "";
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Appointment(Parcel source) {
        id = source.readInt();
        patientId = source.readInt();
        notes = source.readString();
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(id);
        arg0.writeInt(patientId);
        arg0.writeString(notes);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Appointment createFromParcel(Parcel in) {
            return new Appointment(in);
        }

        public Appointment[] newArray(int size) {
            return new Appointment[size];
        }
    };

}
