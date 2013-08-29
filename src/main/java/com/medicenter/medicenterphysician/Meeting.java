package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 23/07/13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class Meeting implements Parcelable {
    int id;
    int patientId;
    String date;
    String obs;

    public Meeting() {
        super();
        this.id = 0;
        this.patientId = 0;
        this.date = "";
        this.obs = "";
    }

    public Meeting(int id, int patientId, String date, String obs) {
        super();
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.obs = obs;
    }

    public Meeting(int patientId, String date, String obs) {
        super();
        this.patientId = patientId;
        this.date = date;
        this.obs = obs;
    }

    public Meeting(Parcel source) {
        this.id = source.readInt();
        this.patientId = source.readInt();
        this.date = source.readString();
        this.obs = source.readString();
    }

    public Meeting(Meeting source) {
        this.id = source.getId();
        this.patientId = source.getPatientId();
        this.date = source.getDate();
        this.obs = source.getObs();
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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
        arg0.writeString(date);
        arg0.writeString(obs);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Meeting createFromParcel(Parcel in) {
            return new Meeting(in);
        }

        public Meeting[] newArray(int size) {
            return new Meeting[size];
        }
    };
}
