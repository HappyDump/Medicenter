package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
public class PrescriptionMenuListActivity extends ListActivity {
    DatabaseHandler db;
    PrescriptionMenuAdapter prescriptionMenuAdapter;
    //Button addPrescription;
    Patient p;
    ImageView imgView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescription_menu_list_activity);

        db = new DatabaseHandler(this);

        int prescriptionsCount = db.getPrescriptionCount();
        Prescription[] values = new Prescription[prescriptionsCount];
        List<Prescription> prescriptions = db.getAllPrescriptions();
        int incr = 0;
        for (Prescription prescription : prescriptions) {
            values[incr] = new Prescription(prescription);
            incr++;
        }

        //Patient[] values = new Patient[2];
        //values[0] = new Patient(0, "Jean", "Dupont", "10/08/2013 12h42", "15/08/2013 15h00", "Blah Blah MEDECIN blah blah TEST blah blah LUPUS");
        //values[1] = new Patient(1, "Janine", "Dupont", "12/06/2013 16h24", "01/09/2013 18h00", "Blah Blah MEDECIN blah blah TEST blah blah ");

        prescriptionMenuAdapter = new PrescriptionMenuAdapter(this, values);
        setListAdapter(prescriptionMenuAdapter);
        //addPrescription = (Button) findViewById(R.id.addprescription);

        //addPrescription.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v) {
        //        Intent i2 = new Intent();
        //        i2.setClass(getApplicationContext(), AddPrescriptionMenu.class);
        //        startActivity(i2);
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
        Prescription p = new Prescription();
        p = (Prescription) this.getListAdapter().getItem(position);
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("prescription", p);
        i.putExtras(b);
        i.setClass(this, PrescriptionActivityMenu.class);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.prescription_menu_list_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addPrescription:
                startActivity(new Intent(this, AddPrescriptionMenu.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
