package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class Patient_DataObj implements Parcelable {
    String DOB;
    String firstName;
    String gender;
    int id;
    String mail;
    Patient_Meeting[] meetings;
    String name;
    Patient_Note[] notes;
    String pc;
    String phone;
    Patient_Prescription[] prescriptions;
    String speciality;
    String street1;
    String street2;
    String town;

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Patient_Meeting[] getMeetings() {
        return meetings;
    }

    public void setMeetings(Patient_Meeting[] meetings) {
        this.meetings = meetings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient_Note[] getNotes() {
        return notes;
    }

    public void setNotes(Patient_Note[] notes) {
        this.notes = notes;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Patient_Prescription[] getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Patient_Prescription[] prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Patient_DataObj(String DOB, String firstName, String gender, int id, String mail, Patient_Meeting[] meetings, String name, Patient_Note[] notes, String pc, String phone, Patient_Prescription[] prescriptions, String speciality, String street1, String street2, String town) {
        this.DOB = DOB;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.mail = mail;
        this.meetings = meetings;
        this.name = name;
        this.notes = notes;
        this.pc = pc;
        this.phone = phone;
        this.prescriptions = prescriptions;
        this.speciality = speciality;
        this.street1 = street1;
        this.street2 = street2;
        this.town = town;
    }

    public Patient_DataObj() {
        this.DOB = "";
        this.firstName = "";
        this.gender = "";
        this.id = 0;
        this.mail = "";
        this.meetings = null;
        this.name = "";
        this.notes = null;
        this.pc = "";
        this.phone = "";
        this.prescriptions = null;
        this.speciality = "";
        this.street1 = "";
        this.street2 = "";
        this.town = "";
    }

    public Patient_DataObj(Parcel source) {
        this.DOB = source.readString();
        this.firstName = source.readString();
        this.gender = source.readString();
        this.id = source.readInt();
        this.mail = source.readString();
        this.meetings = (Patient_Meeting[]) source.createTypedArray(Patient_Meeting.CREATOR);
        this.name = "";
        this.notes = (Patient_Note[]) source.createTypedArray(Patient_Note.CREATOR);
        this.pc = "";
        this.phone = "";
        this.prescriptions = (Patient_Prescription[]) source.createTypedArray(Patient_Prescription.CREATOR);
        this.speciality = "";
        this.street1 = "";
        this.street2 = "";
        this.town = "";
    }

    public Patient_DataObj(Patient_DataObj dataObj) {
        this.DOB = dataObj.getDOB();
        this.firstName = dataObj.getFirstName();
        this.gender = dataObj.getGender();
        this.id = dataObj.getId();
        this.mail = dataObj.getMail();
        this.name = dataObj.getName();
        this.pc = dataObj.getPc();
        this.phone = dataObj.getPhone();
        this.speciality = dataObj.getSpeciality();
        this.street1 = dataObj.getStreet1();
        this.street2 = dataObj.getStreet2();
        this.town = dataObj.getTown();
        int incr = 0;
        if (dataObj.getMeetings() != null) {
            this.meetings = new Patient_Meeting[dataObj.getMeetings().length];
            while (incr < dataObj.getMeetings().length) {
                this.meetings[incr] = new Patient_Meeting(dataObj.getMeetings()[incr]);
                incr++;
            }
        } else
            this.meetings = null;
        if (dataObj.getNotes() != null) {
            incr = 0;
            int length = dataObj.getNotes().length;
            Log.w("blabla", "" + length);
            this.notes = new Patient_Note[length];
            while (incr < length) {
                this.notes[incr] = new Patient_Note(dataObj.getNotes()[incr]);
                incr++;
            }
        } else
            this.notes = null;
        incr = 0;
        if (dataObj.getPrescriptions() != null) {
            this.prescriptions = new Patient_Prescription[dataObj.getPrescriptions().length];
            while (incr < dataObj.getPrescriptions().length) {
                this.prescriptions[incr] = new Patient_Prescription(dataObj.getPrescriptions()[incr]);
                incr++;
            }
        } else
            this.prescriptions = null;
    }

    public Patient_DataObj(Patient_DataObj dataObj, int flag) {
        this.DOB = dataObj.getDOB();
        this.firstName = dataObj.getFirstName();
        this.gender = dataObj.getGender();
        this.id = dataObj.getId();
        this.mail = dataObj.getMail();
        this.name = dataObj.getName();
        this.pc = dataObj.getPc();
        this.phone = dataObj.getPhone();
        this.speciality = dataObj.getSpeciality();
        this.street1 = dataObj.getStreet1();
        this.street2 = dataObj.getStreet2();
        this.town = dataObj.getTown();
        if (flag == 1) {
            int incr = 0;
            if (dataObj.getMeetings() != null) {
                this.meetings = new Patient_Meeting[dataObj.getMeetings().length];
                while (incr < dataObj.getMeetings().length) {
                    this.meetings[incr] = new Patient_Meeting(dataObj.getMeetings()[incr]);
                    incr++;
                }
            } else
                this.meetings = null;

        }
        if (flag == 2) {
            int incr = 0;
            if (dataObj.getPrescriptions() != null) {
                this.prescriptions = new Patient_Prescription[dataObj.getPrescriptions().length];
                while (incr < dataObj.getPrescriptions().length) {
                    this.prescriptions[incr] = new Patient_Prescription(dataObj.getPrescriptions()[incr]);
                    incr++;
                }
            } else
                this.prescriptions = null;

        }

    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(this.DOB);
        arg0.writeString(this.firstName);
        arg0.writeString(this.gender);
        arg0.writeInt(this.id);
        arg0.writeString(this.mail);
        arg0.writeTypedArray(this.meetings, arg1);
        arg0.writeString(this.name);
        arg0.writeTypedArray(this.notes, arg1);
        arg0.writeString(this.pc);
        arg0.writeString(this.phone);
        arg0.writeTypedArray(this.prescriptions, arg1);
        arg0.writeString(this.speciality);
        arg0.writeString(this.street1);
        arg0.writeString(this.street2);
        arg0.writeString(this.town);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Patient_DataObj createFromParcel(Parcel in) {
            return new Patient_DataObj(in);
        }

        public Patient_DataObj[] newArray(int size) {
            return new Patient_DataObj[size];
        }
    };

}
