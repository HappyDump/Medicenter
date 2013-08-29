package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/07/13
 * Time: 00:53
 * To change this template use File | Settings | File Templates.
 */
public class AddPrescriptionMenu extends Activity {
    EditText pMed;
    EditText pDuration;
    EditText pDose;
    Spinner spinner;
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbh = new DatabaseHandler(this);
        setContentView(R.layout.add_prescription_menu);
        List<Meeting> meetings = dbh.getAllMeetings();
        List<String> meetingsName = new ArrayList<String>();

        for (Meeting meeting : meetings) {
            Patient p = dbh.getPatient(meeting.patientId);
            meetingsName.add(p.getfName() + " " + meeting.getDate() + " " + meeting.getId());
        }

        spinner = (Spinner) findViewById(R.id.spinnerPrescription);
        pMed = (EditText) findViewById(R.id.newPrescriptionMedication);
        pDuration = (EditText) findViewById(R.id.newPrescriptionDuration);
        pDose = (EditText) findViewById(R.id.newPrescriptionDose);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                meetingsName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        Button createBtn = (Button) findViewById(R.id.createPrescriptionBtn);

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

            String buttonMed = pMed.getText().toString();
            String buttonDuration = pDuration.getText().toString();
            String buttonDose = pDose.getText().toString();
            String buttonSpinner = String.valueOf(spinner.getSelectedItem());
            String id = buttonSpinner.substring(buttonSpinner.lastIndexOf(' ') + 1);
            Prescription prescription = new Prescription();
            prescription.setMeetingId(Integer.parseInt(id));
            Meeting meeting = dbh.getMeeting(Integer.parseInt(id));
            prescription.setPatientId(meeting.getPatientId());
            prescription.setMedic(buttonMed);
            prescription.setDuration(buttonDuration);
            prescription.setDose(buttonDose);

            dbh.addPrescription(prescription);

            /*Intent i = new Intent(getApplicationContext(), Menu_Page.class);
            startActivity(i);*/
            Intent i = new Intent(getApplicationContext(), PrescriptionMenuListActivity.class);
            startActivity(i);
        }
    };
}
