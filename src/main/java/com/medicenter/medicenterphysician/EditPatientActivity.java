package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.medicenter.medicenterphysician.handlers.WebserviceHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Koj
 * Date: 18/06/13
 * Time: 15:09
 */
public class EditPatientActivity extends Activity {

    EditText pName;
    EditText pSurname;
    EditText pEmail;
    EditText pAge;
    EditText pCountry;
    EditText pCity;
    EditText pStreet;
    EditText pStreetNo;
    EditText pDesc;
    EditText pGender;
    EditText pbPLace;
    EditText pPhone;
    EditText pSsn;
    DatabaseHandler dbh;
    WebserviceHandler ws;
    ArrayList<NameValuePair> nameValuePairs;
    WebserviceConnectionEdit wc;
    int id;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_patient_layout);
        dbh = new DatabaseHandler(this);

        pName = (EditText) findViewById(R.id.editPatientName);
        pSurname = (EditText) findViewById(R.id.editPatientSurname);
        pEmail = (EditText) findViewById(R.id.editPatientEmail);
        pAge = (EditText) findViewById(R.id.editPatientAge);
        pCountry = (EditText) findViewById(R.id.editPatientCountry);
        pCity = (EditText) findViewById(R.id.editPatientCity);
        pStreet = (EditText) findViewById(R.id.editPatientStreet);
        pStreetNo = (EditText) findViewById(R.id.editPatientStreetNumber);
        pDesc = (EditText) findViewById(R.id.editPatientDesc);
        Patient p = new Patient();
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("patient");
            pName.setText(p.getName(), TextView.BufferType.EDITABLE);
            pSurname.setText(p.getfName(), TextView.BufferType.EDITABLE);
            pEmail.setText(p.getEmail(), TextView.BufferType.EDITABLE);
            pAge.setText(p.getAge(), TextView.BufferType.EDITABLE);
            pCountry.setText(p.getCountry(), TextView.BufferType.EDITABLE);
            pCity.setText(p.getCity(), TextView.BufferType.EDITABLE);
            pStreet.setText(p.getStreet(), TextView.BufferType.EDITABLE);
            pStreetNo.setText(p.getStreetNo(), TextView.BufferType.EDITABLE);
            pDesc.setText(p.getDesc(), TextView.BufferType.EDITABLE);
            id = p.getId();
        }

        Button updateBtn = (Button) findViewById(R.id.updatePatientBtn);

        updateBtn.setOnClickListener(updateListener);
        imgView = (ImageView) findViewById(R.id.headerImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            }
        });
    }

    protected View.OnClickListener updateListener = new View.OnClickListener() {

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
            patient.setId(id);
            patient.setDesc(buttonDesc);
            patient.setName(buttonName);
            patient.setAge(buttonAge);
            patient.setEmail(buttonEmail);
            patient.setCountry(buttonCountry);
            patient.setCity(buttonCity);
            patient.setStreet(buttonStreet);
            patient.setStreetNo(buttonStreetNo);
            patient.setfName(buttonSurName);

            ws = new WebserviceHandler();
            nameValuePairs = new ArrayList<NameValuePair>();

            String id = String.valueOf(patient.getId());
            nameValuePairs.add(new BasicNameValuePair("patient_id", id));
            nameValuePairs.add(new BasicNameValuePair("civility", patient.getGender()));
            nameValuePairs.add(new BasicNameValuePair("first_name", patient.getName()));
            nameValuePairs.add(new BasicNameValuePair("last_name", patient.getfName()));
            nameValuePairs.add(new BasicNameValuePair("birth_date", patient.getAge()));
            nameValuePairs.add(new BasicNameValuePair("birth_place", patient.getBirthPlace()));
            nameValuePairs.add(new BasicNameValuePair("mail", patient.getEmail()));
            nameValuePairs.add(new BasicNameValuePair("address_street", patient.getStreetNo() + " " + patient.getStreet()));
            nameValuePairs.add(new BasicNameValuePair("address_city", patient.getCity()));
            nameValuePairs.add(new BasicNameValuePair("address_zip_code", patient.getCountry()));
            nameValuePairs.add(new BasicNameValuePair("phone", patient.getPhone()));
            nameValuePairs.add(new BasicNameValuePair("ssn", patient.getSsn()));

            new WebserviceConnectionEdit().execute(nameValuePairs);

            dbh.updatePatient(patient);
            Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
            startActivity(i);
        }
    };
}
