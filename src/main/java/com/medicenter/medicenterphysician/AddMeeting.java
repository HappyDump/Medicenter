package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/07/13
 * Time: 00:53
 * To change this template use File | Settings | File Templates.
 */
public class AddMeeting extends Activity {
    EditText pDate;
    EditText pObs;
    Patient p;
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbh = new DatabaseHandler(this);
        setContentView(R.layout.add_meeting);
        p = new Patient();
        final Bundle b = this.getIntent().getExtras();
        p = b.getParcelable("patient");

        pDate = (EditText) findViewById(R.id.newMeetingDate);
        pObs = (EditText) findViewById(R.id.newMeetingObs);
        Log.w("patient", "blibli => bla" + p.getId());
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
            Meeting meeting = new Meeting();
            meeting.setPatientId(p.getId());
            meeting.setDate(buttonDate);
            meeting.setObs(buttonObs);
            dbh.addMeeting(meeting);

            /*Intent i = new Intent(getApplicationContext(), Menu_Page.class);
            startActivity(i);*/
            Patient toGive = new Patient(p);
            Intent i2 = new Intent();
            Bundle b2 = new Bundle();
            b2.putParcelable("patient", toGive);
            i2.putExtras(b2);
            i2.setClass(getApplicationContext(), MeetingListPatientActivity.class);
            startActivity(i2);
        }
    };
}
