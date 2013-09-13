package com.medicenter.medicenterphysician;

import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {
    int id;
    String gender;
    String name;
    String fName;
    String email;
    String age;
    String birthPlace;
    String country;
    String city;
    String street;
    String streetNo;
    String desc;
    String phone;
    String ssn;

    /**
     * Class constructor specifying all parameters.
     *
     * @param id    An int that defines the patient ID.
     * @param name  A String that defines the patient name.
     * @param fName A String that defines the patient family name.
     * @param desc  A String that defines the description of the last meeting.
     */

    public Patient(int id, String name, String fName, String email, String age, String city, String country,
                   String street, String streetNo, String desc, String gender, String birthPlace, String phone, String ssn) {
        super();
        this.id = id;
        this.name = name;
        this.fName = fName;
        this.email = email;
        this.age = age;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNo = streetNo;
        this.desc = desc;
        this.gender = gender;
        this.birthPlace = birthPlace;
        this.phone = phone;
        this.ssn = ssn;
    }

    public Patient(String name, String fName, String email, String age, String city, String country,
                   String street, String streetNo, String desc, String gender, String birthPlace, String phone, String ssn) {
        super();
        this.name = name;
        this.fName = fName;
        this.email = email;
        this.age = age;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNo = streetNo;
        this.desc = desc;
        this.gender = gender;
        this.birthPlace = birthPlace;
        this.phone = phone;
        this.ssn = ssn;
    }

    /**
     * Constructor from a parcel.
     *
     * @param source Previously parcelled Patient.
     */

    public Patient(Parcel source) {
        id = source.readInt();
        name = source.readString();
        fName = source.readString();
        email = source.readString();
        age = source.readString();
        country = source.readString();
        city = source.readString();
        street = source.readString();
        streetNo = source.readString();
        desc = source.readString();
        gender = source.readString();
        birthPlace = source.readString();
        phone = source.readString();
        ssn = source.readString();
    }

    public Patient(Patient source) {
        id = source.getId();
        name = source.getName();
        fName = source.getfName();
        email = source.getEmail();
        age = source.getAge();
        country = source.getCountry();
        city = source.getCity();
        street = source.getStreet();
        streetNo = source.getStreetNo();
        desc = source.getDesc();
        gender = source.getGender();
        birthPlace = source.getBirthPlace();
        phone = source.getPhone();
        ssn = source.getSsn();
    }

    /**
     * Constructor without any parameters, creating a null object.
     */

    public Patient() {
        super();
        this.id = 0;
        this.name = "";
        this.fName = "";
        this.age = "";
        this.country = "";
        this.email = "";
        this.city = "";
        this.street = "";
        this.streetNo = "";
        this.desc = "";
        this.gender = "";
        this.phone = "";
        this.birthPlace = "";
        this.ssn = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Serializes a Patient to a Parcel.
     *
     * @param arg0 target Parcel.
     * @param arg1
     */

    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(id);
        arg0.writeString(name);
        arg0.writeString(fName);
        arg0.writeString(email);
        arg0.writeString(age);
        arg0.writeString(country);
        arg0.writeString(city);
        arg0.writeString(street);
        arg0.writeString(streetNo);
        arg0.writeString(desc);
        arg0.writeString(gender);
        arg0.writeString(birthPlace);
        arg0.writeString(phone);
        arg0.writeString(ssn);
    }

    //public ArrayList<String>

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };
}
