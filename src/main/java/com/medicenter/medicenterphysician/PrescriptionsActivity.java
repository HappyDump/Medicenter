package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PrescriptionsActivity extends Activity {
    Button editPrescription;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescription_single_layout);

        Prescription p = new Prescription();
        TextView med = (TextView) findViewById(R.id.prescriptionMedicationFill);
        TextView duration = (TextView) findViewById(R.id.prescriptionDurationFill);
        TextView dose = (TextView) findViewById(R.id.prescriptionDoseFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            p = b.getParcelable("prescription");
            med.setText(p.getMedic());
            duration.setText(p.getDuration());
            dose.setText(p.getDose());
        }
        editPrescription = (Button) findViewById(R.id.editPrescription);

        editPrescription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Prescription toGive = b.getParcelable("prescription");
                Intent i2 = new Intent();
                Bundle b2 = new Bundle();
                b2.putParcelable("prescription", toGive);
                i2.putExtras(b2);
                i2.setClass(getApplicationContext(), EditPrescriptionActivity.class);
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
    }
}
