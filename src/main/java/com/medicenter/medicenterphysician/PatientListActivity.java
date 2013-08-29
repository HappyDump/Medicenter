package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class PatientListActivity extends ListActivity {
    DatabaseHandler db;
    PatientArrayAdapter patientAdapter;
    Button addPatient;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patients_list_activity_layout);

        db = new DatabaseHandler(this);

        int patientsCount = db.getPatientCount();
        Patient[] values = new Patient[patientsCount];
        List<Patient> patients = db.getAllPatients();
        int incr = 0;
        for (Patient patient : patients) {
            values[incr] = new Patient(patient);
            incr++;
        }

        //Patient[] values = new Patient[2];
        //values[0] = new Patient(0, "Jean", "Dupont", "10/08/2013 12h42", "15/08/2013 15h00", "Blah Blah MEDECIN blah blah TEST blah blah LUPUS");
        //values[1] = new Patient(1, "Janine", "Dupont", "12/06/2013 16h24", "01/09/2013 18h00", "Blah Blah MEDECIN blah blah TEST blah blah ");

        patientAdapter = new PatientArrayAdapter(this, values);
        setListAdapter(patientAdapter);
        //addPatient = (Button) findViewById(R.id.addpatient);

        //addPatient.setOnClickListener(new View.OnClickListener()
        //{
        //    public void onClick(View v)
        //    {
        //        Intent i = new Intent(getApplicationContext(), AddPatient.class);
        //        startActivity(i);
        //    }
        //});
        imgView = (ImageView) findViewById(R.id.headerImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            }
        });
    }

    /**
     * Launches the Patient activity corresponding to the selected patient.
     *
     * @param l        ListView target.
     * @param v        View source.
     * @param position int item position.
     * @param id       long item id.
     */

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        Patient p = new Patient();
        p = (Patient) this.getListAdapter().getItem(position);
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("patient", p);
        i.putExtras(b);
        i.setClass(this, PatientActivity.class);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.patients_list_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addPatient:
                startActivity(new Intent(this, AddPatient.class));
                updateData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void updateData() {
        //int patientsCount = db.getPatientCount();
        //Patient[] values = new Patient[patientsCount];
        //List<Patient> patients = db.getAllPatients();
        //int incr = 0;
        //for (Patient patient : patients) {
        //    values[incr] = new Patient(patient);
        //    incr++;
        //}
        //patientAdapter.clear();
        //patientAdapter.addAll(values);
        //patientAdapter.notifyDataSetChanged();

    }
}
