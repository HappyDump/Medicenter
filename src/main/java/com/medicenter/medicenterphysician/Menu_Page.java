package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Menu_Page extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.dashboard_layout);
        setContentView(R.layout.menu);

        /**
         * Creating all buttons instances
         * */
        // Dashboard Patients List button
        Button btn_patients = (Button) findViewById(R.id.btn_patients_list);

        // Dashboard Calendar button
        Button btn_schedule = (Button) findViewById(R.id.btn_schedule);

        // Dashboard Messages button
        Button btn_messages = (Button) findViewById(R.id.btn_messages);

        // Dashboard Prescriptions button
        Button btn_prescriptions = (Button) findViewById(R.id.btn_prescriptions);


        /**
         * Handling all button click events
         * */

        // Listening to News Feed button click
        btn_patients.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
                startActivity(i);
            }
        });

        // Listening Friends button click
        btn_schedule.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MeetingMenuListActivity.class);
                startActivity(i);
            }
        });

        // Listening Messages button click
        btn_messages.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MessagesActivity.class);
                startActivity(i);
            }
        });

        // Listening to Places button click
        btn_prescriptions.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), PrescriptionMenuListActivity.class);
                startActivity(i);
            }
        });

    }
}
