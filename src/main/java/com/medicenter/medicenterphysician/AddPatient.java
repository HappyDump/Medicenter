package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created with IntelliJ IDEA.
 * User: Koj
 * Date: 18/06/13
 * Time: 15:09
 */
public class AddPatient extends Activity implements OnItemSelectedListener {

    EditText pName;
    EditText pSurname;
    EditText pEmail;
    EditText pAge;
    EditText pCountry;
    EditText pCity;
    EditText pStreet;
    EditText pStreetNo;
    EditText pDesc;
    Spinner pGender;
    String gender;
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbh = new DatabaseHandler(this);
        setContentView(R.layout.add_patients);

        pName = (EditText) findViewById(R.id.newPatientName);
        pSurname = (EditText) findViewById(R.id.newPatientSurname);
        pEmail = (EditText) findViewById(R.id.newPatientEmail);
        pAge = (EditText) findViewById(R.id.newPatientAge);
        pCountry = (EditText) findViewById(R.id.newPatientCountry);
        pCity = (EditText) findViewById(R.id.newPatientCity);
        pStreet = (EditText) findViewById(R.id.newPatientStreet);
        pStreetNo = (EditText) findViewById(R.id.newPatientStreetNumber);
        pDesc = (EditText) findViewById(R.id.newPatientDesc);
        pGender = (Spinner) findViewById(R.id.newPatientCivilitySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pGender.setAdapter(adapter);

        Button createBtn = (Button) findViewById(R.id.createPatientBtn);

        createBtn.setOnClickListener(createListener);
        imgView = (ImageView) findViewById(R.id.headerImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            }
        });
    }

    protected View.OnClickListener createListener = new View.OnClickListener() {

        public void onClick(View v) {

            String buttonName = pName.getText().toString();
            String buttonSurName = pSurname.getText().toString();
            String buttonEmail = pEmail.getText().toString();
            String buttonAge = pAge.getText().toString();
            String buttonCountry = pCountry.getText().toString();
            String buttonCity = pCity.getText().toString();
            String buttonStreet = pStreet.getText().toString();
            String buttonStreetNo = pStreetNo.getText().toString();
            String buttonDesc = pDesc.getText().toString();
            Patient patient = new Patient();
            patient.setDesc(buttonDesc);
            patient.setName(buttonName);
            patient.setAge(buttonAge);
            patient.setEmail(buttonEmail);
            patient.setCountry(buttonCountry);
            patient.setCity(buttonCity);
            patient.setStreet(buttonStreet);
            patient.setStreetNo(buttonStreetNo);
            patient.setfName(buttonSurName);
            dbh.addPatient(patient);

            Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
            startActivity(i);
        }
    };

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        gender = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        gender = null;
    }

    ;
}
