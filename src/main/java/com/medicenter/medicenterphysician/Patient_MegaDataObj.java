package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
public class Patient_MegaDataObj implements Parcelable {
    Patient_DataObj[] data;
    String error;

    public Patient_DataObj[] getData() {
        return data;
    }

    public void setData(Patient_DataObj[] data, String error) {
        this.data = data;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public Patient_MegaDataObj() {
        this.data = null;
        this.error = "";
    }

    public Patient_MegaDataObj(Parcel source) {
        this.data = (Patient_DataObj[]) source.createTypedArray(Patient_DataObj.CREATOR);
        this.error = source.readString();
    }

    public Patient_MegaDataObj(Patient_MegaDataObj megaDataObj) {
        this.error = megaDataObj.getError();
        int incr = 0;
        this.data = new Patient_DataObj[megaDataObj.getData().length];
        Log.w("toto", megaDataObj.getData()[0].getDOB());
        while (incr < megaDataObj.getData().length) {
            this.data[incr] = new Patient_DataObj(megaDataObj.getData()[incr]);
            incr++;
        }
    }

    public Patient_MegaDataObj(Patient_MegaDataObj megaDataObj, int flag) {
        this.error = megaDataObj.getError();
        int incr = 0;
        this.data = new Patient_DataObj[megaDataObj.getData().length];
        Log.w("toto", megaDataObj.getData()[0].getDOB());
        while (incr < megaDataObj.getData().length) {
            this.data[incr] = new Patient_DataObj(megaDataObj.getData()[incr], flag);
            incr++;
        }
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeTypedArray(this.data, arg1);
        arg0.writeString(error);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Patient_MegaDataObj createFromParcel(Parcel in) {
            return new Patient_MegaDataObj(in);
        }

        public Patient_MegaDataObj[] newArray(int size) {
            return new Patient_MegaDataObj[size];
        }
    };


}
