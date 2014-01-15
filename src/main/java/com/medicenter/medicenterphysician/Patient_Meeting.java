package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public class Patient_Meeting implements Parcelable {
    String createdBy;
    String dateBegin;
    String dateEnd;
    int id;
    String reason;
    String status;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Patient_Meeting(String createdBy, String dateBegin, String dateEnd, int id, String reason, String status) {
        this.createdBy = createdBy;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.id = id;
        this.reason = reason;
        this.status = status;
    }

    public Patient_Meeting() {
        this.createdBy = "";
        this.dateBegin = "";
        this.dateEnd = "";
        this.id = 0;
        this.reason = "";
        this.status = "";
    }

    public Patient_Meeting(Parcel source) {
        this.createdBy = source.readString();
        this.dateBegin = source.readString();
        this.dateEnd = source.readString();
        this.id = source.readInt();
        this.reason = source.readString();
        this.status = source.readString();
    }

    public Patient_Meeting(Patient_Meeting source) {
        this.createdBy = source.getCreatedBy();
        this.dateBegin = source.getDateBegin();
        this.dateEnd = source.getDateEnd();
        this.id = source.getId();
        this.reason = source.getReason();
        this.status = source.getStatus();
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(createdBy);
        arg0.writeString(dateBegin);
        arg0.writeString(dateEnd);
        arg0.writeInt(id);
        arg0.writeString(reason);
        arg0.writeString(status);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Patient_Meeting createFromParcel(Parcel in) {
            return new Patient_Meeting(in);
        }

        public Patient_Meeting[] newArray(int size) {
            return new Patient_Meeting[size];
        }
    };
}
