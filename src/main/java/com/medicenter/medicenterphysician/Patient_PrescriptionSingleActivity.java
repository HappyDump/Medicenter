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
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Patient_PrescriptionSingleActivity extends Activity {
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_prescriptionlist_single_layout);

        Patient_Prescription prescription;
        TextView date = (TextView) findViewById(R.id.dateFill);
        TextView text = (TextView) findViewById(R.id.textFill);

        final Bundle b = this.getIntent().getExtras();
        if (b != null) {
            prescription = new Patient_Prescription((Patient_Prescription) b.getParcelable("prescription"));

            date.setText(prescription.getDate());
            text.setText(prescription.getText());
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
