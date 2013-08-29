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
public class AddMeetingMenu extends Activity {
    EditText pDate;
    EditText pObs;
    Spinner spinner;
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbh = new DatabaseHandler(this);
        setContentView(R.layout.add_meeting_menu);
        List<Patient> patients = dbh.getAllPatients();
        List<String> patientsName = new ArrayList<String>();

        for (Patient patient : patients) {
            patientsName.add(patient.getfName() + " " + patient.getName() + " " + patient.getId());
        }

        spinner = (Spinner) findViewById(R.id.spinnerMeeting);
        pDate = (EditText) findViewById(R.id.newMeetingDate);
        pObs = (EditText) findViewById(R.id.newMeetingObs);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                patientsName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        Button createBtn = (Button) findViewById(R.id.createMeetingBtn);

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

            String buttonDate = pDate.getText().toString();
            String buttonObs = pObs.getText().toString();
            String buttonSpinner = String.valueOf(spinner.getSelectedItem());
            String id = buttonSpinner.substring(buttonSpinner.lastIndexOf(' ') + 1);
            Meeting meeting = new Meeting();
            meeting.setPatientId(Integer.parseInt(id));
            meeting.setDate(buttonDate);
            meeting.setObs(buttonObs);
            dbh.addMeeting(meeting);

            /*Intent i = new Intent(getApplicationContext(), Menu_Page.class);
            startActivity(i);*/
            Intent i = new Intent(getApplicationContext(), MeetingMenuListActivity.class);
            startActivity(i);
        }
    };
}
