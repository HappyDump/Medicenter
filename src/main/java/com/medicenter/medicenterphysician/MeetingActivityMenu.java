package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MeetingActivityMenu extends Activity {
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meeting_single_layout_menu);

        dbh = new DatabaseHandler(this);
        Meeting p = new Meeting();
        TextView date = (TextView) findViewById(R.id.meetingDateFill);
        TextView obs = (TextView) findViewById(R.id.meetingObsFill);
        TextView pat = (TextView) findViewById(R.id.meetingPatientFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("meeting");
            date.setText(p.getDate());
            obs.setText(p.getObs());
            Patient patient = dbh.getPatient(p.getPatientId());
            pat.setText(patient.getName() + " " + patient.getfName());

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
