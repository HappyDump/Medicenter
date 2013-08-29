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
public class Prescription implements Parcelable {
    int id;
    int patientId;
    int meetingId;
    String medic;
    String duration;
    String dose;

    public Prescription() {
        super();
        this.id = 0;
        this.patientId = 0;
        this.meetingId = 0;
        this.medic = "";
        this.duration = "";
        this.dose = "";
    }

    public Prescription(int id, int patientId, int meetingId, String medic, String duration, String dose) {
        super();
        this.id = id;
        this.patientId = patientId;
        this.meetingId = meetingId;
        this.medic = medic;
        this.duration = duration;
        this.dose = dose;
    }

    public Prescription(int patientId, int meetingId, String medic, String duration, String dose) {
        super();
        this.patientId = patientId;
        this.meetingId = meetingId;
        this.medic = medic;
        this.duration = duration;
        this.dose = dose;
    }

    public Prescription(Parcel source) {
        this.id = source.readInt();
        this.patientId = source.readInt();
        this.meetingId = source.readInt();
        this.medic = source.readString();
        this.duration = source.readString();
        this.dose = source.readString();
    }

    public Prescription(Prescription prescription) {
        this.id = prescription.getId();
        this.patientId = prescription.getPatientId();
        this.meetingId = prescription.getMeetingId();
        this.medic = prescription.getMedic();
        this.duration = prescription.getDuration();
        this.dose = prescription.getDose();
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

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
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
        arg0.writeInt(meetingId);
        arg0.writeString(medic);
        arg0.writeString(duration);
        arg0.writeString(dose);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Prescription createFromParcel(Parcel in) {
            return new Prescription(in);
        }

        public Prescription[] newArray(int size) {
            return new Prescription[size];
        }
    };
}
