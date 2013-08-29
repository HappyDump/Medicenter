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
public class EditPrescriptionActivity extends Activity {

    EditText pMed;
    EditText pDuration;
    EditText pDose;

    DatabaseHandler dbh;
    int id;
    int patientId;
    int meetingId;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_prescription);
        dbh = new DatabaseHandler(this);

        pMed = (EditText) findViewById(R.id.editPrescriptionMedication);
        pDuration = (EditText) findViewById(R.id.editPrescriptionDuration);
        pDose = (EditText) findViewById(R.id.editPrescriptionDose);

        Prescription p = new Prescription();
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("prescription");
            pMed.setText(p.getMedic(), TextView.BufferType.EDITABLE);
            pDuration.setText(p.getDuration(), TextView.BufferType.EDITABLE);
            pDose.setText(p.getDose(), TextView.BufferType.EDITABLE);
            id = p.getId();
            patientId = p.getPatientId();
            meetingId = p.getMeetingId();
        }

        Button updateBtn = (Button) findViewById(R.id.updatePrescriptionBtn);

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

            String buttonMed = pMed.getText().toString();
            String buttonDuration = pDuration.getText().toString();
            String buttonDose = pDose.getText().toString();

            Prescription prescription = new Prescription();
            prescription.setId(id);
            prescription.setPatientId(patientId);
            prescription.setMeetingId(meetingId);
            prescription.setMedic(buttonMed);
            prescription.setDuration(buttonDuration);
            prescription.setDose(buttonDose);

            dbh.updatePrescription(prescription);
            Meeting m = new Meeting(dbh.getMeeting(meetingId));
            Intent i2 = new Intent();
            Bundle b2 = new Bundle();
            b2.putParcelable("meeting", m);
            i2.putExtras(b2);
            i2.setClass(getApplicationContext(), PrescriptionListPatientActivity.class);
            startActivity(i2);
        }
    };
}
