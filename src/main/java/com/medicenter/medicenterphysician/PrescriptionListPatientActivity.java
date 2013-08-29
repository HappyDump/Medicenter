package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/07/13
 * Time: 00:24
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionListPatientActivity extends ListActivity {
    DatabaseHandler db;
    PrescriptionArrayAdapter prescriptionArrayAdapter;
    Button addPrescription;
    Patient p;
    Meeting m;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescription_list_activity);

        db = new DatabaseHandler(this);

        p = new Patient();
        final Bundle b = this.getIntent().getExtras();
        m = b.getParcelable("meeting");
        int prescriptionsCount = db.getPrescriptionCountById(m.getId());
        //int meetingsCount = db.getMeetingCount();
        Prescription[] values = new Prescription[prescriptionsCount];
        List<Prescription> prescriptions = db.getAllPrescriptionsById(m.getId());
        //List<Meeting> meetings = db.getAllMeetings();
        int incr = 0;
        for (Prescription prescription : prescriptions) {
            values[incr] = new Prescription(prescription);
            incr++;
        }

        //Patient[] values = new Patient[2];
        //values[0] = new Patient(0, "Jean", "Dupont", "10/08/2013 12h42", "15/08/2013 15h00", "Blah Blah MEDECIN blah blah TEST blah blah LUPUS");
        //values[1] = new Patient(1, "Janine", "Dupont", "12/06/2013 16h24", "01/09/2013 18h00", "Blah Blah MEDECIN blah blah TEST blah blah ");

        prescriptionArrayAdapter = new PrescriptionArrayAdapter(this, values);
        setListAdapter(prescriptionArrayAdapter);
        addPrescription = (Button) findViewById(R.id.addprescription);

        addPrescription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Meeting toGive = b.getParcelable("meeting");
                Intent i2 = new Intent();
                Bundle b2 = new Bundle();
                b2.putParcelable("meeting", toGive);
                i2.putExtras(b2);
                i2.setClass(getApplicationContext(), AddPrescription.class);
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
        Prescription m = new Prescription();
        m = (Prescription) this.getListAdapter().getItem(position);
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("prescription", m);
        i.putExtras(b);
        i.setClass(this, PrescriptionsActivity.class);
        startActivity(i);
    }
}
