package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
public class Patient_Prescription implements Parcelable {
    String date;
    int id;
    String text;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Patient_Prescription(String date, int id, String text) {
        this.date = date;
        this.id = id;
        this.text = text;
    }

    public Patient_Prescription() {
        this.date = "";
        this.id = 0;
        this.text = "";
    }

    public Patient_Prescription(Parcel source) {
        this.date = source.readString();
        this.id = source.readInt();
        this.text = source.readString();
    }

    public Patient_Prescription(Patient_Prescription source) {
        this.date = source.getDate();
        this.id = source.getId();
        this.text = source.getText();
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(date);
        arg0.writeInt(id);
        arg0.writeString(text);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Patient_Prescription createFromParcel(Parcel in) {
            return new Patient_Prescription(in);
        }

        public Patient_Prescription[] newArray(int size) {
            return new Patient_Prescription[size];
        }
    };
}
