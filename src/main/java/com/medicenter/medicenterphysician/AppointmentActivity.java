package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Koj
 * Date: 13/05/13
 * Time: 20:28
 */

/**
 * Creates a new view and ca ListView in order to store the appointments and create the Appointment List.
 */

public class AppointmentActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_activity_layout);

        Appointment a = new Appointment();

        TextView number = (TextView) findViewById(R.id.number);
        TextView patient_id = (TextView) findViewById(R.id.patient_id);
        TextView desc = (TextView) findViewById(R.id.desc);

        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            a = b.getParcelable("appointment");
            number.setText("" + a.id);
            patient_id.setText("" + a.patientId);
            desc.setText(a.notes);
        }
    }
}
