package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Koj
 * Date: 18/06/13
 * Time: 15:09
 */
public class EditMeetingActivity extends Activity {

    EditText pDate;
    EditText pObs;
    Meeting p;
    DatabaseHandler dbh;
    int id;
    int patientId;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_meeting);
        dbh = new DatabaseHandler(this);

        pDate = (EditText) findViewById(R.id.editMeetingDate);
        pObs = (EditText) findViewById(R.id.editMeetingObs);

        p = new Meeting();
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("meeting");
            pDate.setText(p.getDate(), TextView.BufferType.EDITABLE);
            pObs.setText(p.getObs(), TextView.BufferType.EDITABLE);
            id = p.getId();
            patientId = p.getPatientId();
        }

        Button updateBtn = (Button) findViewById(R.id.updateMeetingBtn);

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

            String buttonDate = pDate.getText().toString();
            String buttonObs = pObs.getText().toString();

            Meeting meeting = new Meeting();
            meeting.setId(id);
            meeting.setPatientId(patientId);
            meeting.setDate(buttonDate);
            meeting.setObs(buttonObs);

            dbh.updateMeeting(meeting);
            /*Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
            startActivity(i);*/

            Patient toGive = dbh.getPatient(p.getPatientId());
            Intent i2 = new Intent();
            Bundle b2 = new Bundle();
            b2.putParcelable("patient", toGive);
            i2.putExtras(b2);
            i2.setClass(getApplicationContext(), MeetingListPatientActivity.class);
            startActivity(i2);
        }
    };
}
