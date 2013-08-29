package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
public class AddPrescription extends Activity {
    EditText pMedication;
    EditText pDuration;
    EditText pDose;
    Meeting m;
    DatabaseHandler dbh;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbh = new DatabaseHandler(this);
        setContentView(R.layout.add_prescription);
        m = new Meeting();
        final Bundle b = this.getIntent().getExtras();
        m = b.getParcelable("meeting");

        pMedication = (EditText) findViewById(R.id.newPrescriptionMedication);
        pDuration = (EditText) findViewById(R.id.newPrescriptionDuration);
        pDose = (EditText) findViewById(R.id.newPrescriptionDose);
        Button createBtn = (Button) findViewById(R.id.createPrescriptionBtn);

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

            String buttonMed = pMedication.getText().toString();
            String buttonDuration = pDuration.getText().toString();
            String buttonDose = pDose.getText().toString();
            Prescription prescription = new Prescription();
            prescription.setPatientId(m.getPatientId());
            prescription.setMeetingId(m.getId());
            prescription.setMedic(buttonMed);
            prescription.setDuration(buttonDuration);
            prescription.setDose(buttonDose);

            dbh.addPrescription(prescription);

            /*Intent i = new Intent(getApplicationContext(), Menu_Page.class);
            startActivity(i);*/
            Intent i2 = new Intent();
            Bundle b2 = new Bundle();
            b2.putParcelable("meeting", m);
            i2.putExtras(b2);
            i2.setClass(getApplicationContext(), PrescriptionListPatientActivity.class);
            startActivity(i2);
        }
    };
}
