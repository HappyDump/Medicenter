package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 */
public class Patient_Menu_Page extends ListActivity {
    Patient_MegaDataObj megaData = new Patient_MegaDataObj();
    LongRunningGetIO lrg;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.dashboard_layout);
        setContentView(R.layout.menu_patient);

        /**
         * Creating all buttons instances
         * */
        // Dashboard Patients List button
        Button btn_patients = (Button) findViewById(R.id.btn_medecin_list);

        // Dashboard Calendar button
        Button btn_schedule = (Button) findViewById(R.id.btn_schedule);

        // Dashboard Messages button
        Button btn_messages = (Button) findViewById(R.id.btn_messages);

        // Dashboard Prescriptions button
        Button btn_prescriptions = (Button) findViewById(R.id.btn_prescriptions);
        Button btn_sync = (Button) findViewById(R.id.btn_sync);

        /**
         * Handling all button click events
         * */

        btn_sync.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                lrg = new LongRunningGetIO(18);
                lrg.execute();
            }
        });
        // Listening to News Feed button click
        btn_patients.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Patient_DoctorListActivity.class);
                Bundle b = new Bundle();
                String res = lrg.getResult();
                Gson gson = new Gson();
                megaData = gson.fromJson(res, Patient_MegaDataObj.class);
                b.putParcelable("megadata", megaData);
                Log.w("test", megaData.getData()[0].getDOB());
                i.putExtras(b);
                startActivity(i);
            }
        });

        // Listening Friends button click
        btn_schedule.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Patient_MeetingListActivity.class);
                Bundle b = new Bundle();
                String res = lrg.getResult();
                Gson gson = new Gson();
                megaData = gson.fromJson(res, Patient_MegaDataObj.class);
                b.putParcelable("megadata", megaData);
                i.putExtras(b);
                startActivity(i);
            }
        });
          /*
        // Listening Messages button click
        btn_messages.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Patient_MessagesActivity.class);
                Bundle b = new Bundle();
                String res = lrg.getResult();
                Gson gson = new Gson();
                megaData = gson.fromJson(res, Patient_MegaDataObj.class);
                b.putParcelable("megadata", megaData);
                i.putExtras(b);
                startActivity(i);
            }
        });  */

        // Listening to Places button click
        btn_prescriptions.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Patient_PrescriptionListActivity.class);
                Bundle b = new Bundle();
                String res = lrg.getResult();
                Gson gson = new Gson();
                megaData = gson.fromJson(res, Patient_MegaDataObj.class);
                b.putParcelable("megadata", megaData);
                i.putExtras(b);
                Log.w("test", "prescription");
                startActivity(i);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_activity, menu);
        return true;
    }
}
