package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MeetingActivity extends Activity {
    Button btn_general, btn_meeting, btn_medication, btn_specificities;
    Button editMeeting;
    Button prescription;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meeting_single_layout);

        Meeting p = new Meeting();
        TextView date = (TextView) findViewById(R.id.meetingDateFill);
        TextView obs = (TextView) findViewById(R.id.meetingObsFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("meeting");
            date.setText(p.getDate());
            obs.setText(p.getObs());
        }
        btn_general = (Button) findViewById(R.id.general_tab);
        btn_specificities = (Button) findViewById(R.id.specificities_tab);
        btn_medication = (Button) findViewById(R.id.medication_tab);
        editMeeting = (Button) findViewById(R.id.editMeeting);
        prescription = (Button) findViewById(R.id.prescriptions);
        editMeeting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Meeting toGive = b.getParcelable("meeting");
                Intent i2 = new Intent();
                Bundle b2 = new Bundle();
                b2.putParcelable("meeting", toGive);
                i2.putExtras(b2);
                i2.setClass(getApplicationContext(), EditMeetingActivity.class);
                startActivity(i2);
            }
        });

        prescription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Meeting toGive = b.getParcelable("meeting");
                Intent i2 = new Intent();
                Bundle b2 = new Bundle();
                b2.putParcelable("meeting", toGive);
                i2.putExtras(b2);
                i2.setClass(getApplicationContext(), PrescriptionListPatientActivity.class);
                startActivity(i2);
            }
        });
        imgView = (ImageView) findViewById(R.id.headerImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            }
        });

        /*btn_edit = (Button)findViewById(R.id.editPatient);
        btn_edit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent i = new Intent(getApplicationContext(), EditPatientActivity.class);

                startActivity(i);
            }
        });  */
        btn_general.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        btn_specificities.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
                startActivity(i);
            }
        });
    }
}
