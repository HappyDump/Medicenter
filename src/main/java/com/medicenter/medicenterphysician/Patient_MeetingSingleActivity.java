package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 25/10/13
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class Patient_MeetingSingleActivity extends Activity {
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_meetinglist_single_layout);

        Patient_Meeting meeting;
        TextView createdBy = (TextView) findViewById(R.id.createdByFill);
        TextView dateBegin = (TextView) findViewById(R.id.dateBeginFill);
        TextView dateEnd = (TextView) findViewById(R.id.dateEndFill);
        TextView reason = (TextView) findViewById(R.id.reasonFill);
        TextView status = (TextView) findViewById(R.id.statusFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            meeting = new Patient_Meeting((Patient_Meeting) b.getParcelable("meeting"));

            createdBy.setText(meeting.getCreatedBy());
            dateBegin.setText(meeting.getDateBegin());
            dateEnd.setText(meeting.getDateEnd());
            reason.setText(meeting.getReason());
            status.setText(meeting.getStatus());
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
