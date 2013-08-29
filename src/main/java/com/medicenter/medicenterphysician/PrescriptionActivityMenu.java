package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PrescriptionActivityMenu extends Activity {
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescription_singe_layout_menu);

        dbh = new DatabaseHandler(this);
        Prescription p = new Prescription();
        TextView med = (TextView) findViewById(R.id.prescriptionMedicationFill);
        TextView duration = (TextView) findViewById(R.id.prescriptionDurationFill);
        TextView dose = (TextView) findViewById(R.id.prescriptionDoseFill);
        TextView patient = (TextView) findViewById(R.id.prescriptionPatientFill);
        TextView date = (TextView) findViewById(R.id.prescriptionDateFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("prescription");
            Meeting m = dbh.getMeeting(p.getMeetingId());
            Patient pat = dbh.getPatient(p.getPatientId());
            med.setText(p.getMedic());
            duration.setText(p.getDuration());
            dose.setText(p.getDose());
            patient.setText(pat.getName() + " " + pat.getfName());
            date.setText(m.getDate());

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
