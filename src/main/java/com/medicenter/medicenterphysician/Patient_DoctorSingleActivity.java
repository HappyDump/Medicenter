package com.medicenter.medicenterphysician;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 25/10/13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Patient_DoctorSingleActivity extends Activity {
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_doctorlist_singe_layout);

        Patient_DataObj dataObj;
        TextView dateOfBirth = (TextView) findViewById(R.id.dateOfBirthFill);
        TextView firstName = (TextView) findViewById(R.id.firstNameFill);
        TextView gender = (TextView) findViewById(R.id.genderFill);
        TextView mail = (TextView) findViewById(R.id.mailFill);
        TextView name = (TextView) findViewById(R.id.nameFill);
        TextView pc = (TextView) findViewById(R.id.pcFill);
        TextView phone = (TextView) findViewById(R.id.phoneFill);
        TextView speciality = (TextView) findViewById(R.id.specialityFill);
        TextView street1 = (TextView) findViewById(R.id.street1Fill);
        TextView street2 = (TextView) findViewById(R.id.street2Fill);
        TextView town = (TextView) findViewById(R.id.townFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            dataObj = b.getParcelable("data");

            dateOfBirth.setText(dataObj.getDOB());
            firstName.setText(dataObj.getFirstName());
            gender.setText(dataObj.getGender());
            mail.setText(dataObj.getMail());
            name.setText(dataObj.getName());
            pc.setText(dataObj.getPc());
            phone.setText(dataObj.getPhone());
            speciality.setText(dataObj.getSpeciality());
            street1.setText(dataObj.getStreet1());
            street2.setText(dataObj.getStreet2());
            town.setText(dataObj.getTown());
        }
        imgView = (ImageView) findViewById(R.id.headerImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            }
        });
    }
}

