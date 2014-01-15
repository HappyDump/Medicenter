package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 25/10/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Patient_PrescriptionListActivity extends ListActivity {
    Patient_PrescriptionArrayAdapter prescriptionListArrayAdapter;
    ImageView imgView;
    Bundle b;
    Patient_MegaDataObj megaDataObj;
    Patient_DataObj[] dataObj;
    Patient_Prescription[] prescriptions;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_prescriptionlist_activity);

        b = this.getIntent().getExtras();
        final Bundle b = this.getIntent().getExtras();
        megaDataObj = new Patient_MegaDataObj((Patient_MegaDataObj) b.getParcelable("megadata"), 2);
        int doctorCount = megaDataObj.getData().length;
        int incr = 0;
        dataObj = new Patient_DataObj[doctorCount];
        int totalPrescription = 0;
        while (incr < doctorCount) {
            dataObj[incr] = new Patient_DataObj(megaDataObj.getData()[incr]);
            totalPrescription = totalPrescription + dataObj[incr].getPrescriptions().length;
            incr++;
        }
        prescriptions = new Patient_Prescription[totalPrescription];
        incr = 0;
        int c = 0;
        while (incr < doctorCount) {
            int a = 0;
            while (a < dataObj[incr].getPrescriptions().length) {
                prescriptions[c] = new Patient_Prescription(dataObj[incr].getPrescriptions()[a]);
                c++;
                a++;
            }
            incr++;
        }
        //Patient[] values = new Patient[2];
        //values[0] = new Patient(0, "Jean", "Dupont", "10/08/2013 12h42", "15/08/2013 15h00", "Blah Blah MEDECIN blah blah TEST blah blah LUPUS");
        //values[1] = new Patient(1, "Janine", "Dupont", "12/06/2013 16h24", "01/09/2013 18h00", "Blah Blah MEDECIN blah blah TEST blah blah ");

        prescriptionListArrayAdapter = new Patient_PrescriptionArrayAdapter(this, prescriptions);
        setListAdapter(prescriptionListArrayAdapter);
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
        Patient_Prescription prescription;
        prescription = new Patient_Prescription((Patient_Prescription) this.getListAdapter().getItem(position));
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("prescription", prescription);
        i.putExtras(b);
        i.setClass(this, Patient_PrescriptionSingleActivity.class);
        startActivity(i);
    }
}
