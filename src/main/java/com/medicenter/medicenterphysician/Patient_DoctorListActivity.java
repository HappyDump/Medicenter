package com.medicenter.medicenterphysician;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 25/10/13
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/07/13
 * Time: 00:24
 * To change this template use File | Settings | File Templates.
 */
public class Patient_DoctorListActivity extends ListActivity {
    Patient_DoctorListArrayAdapter doctorListArrayAdapter;
    ImageView imgView;
    Bundle b;
    Patient_MegaDataObj megaDataObj;
    Patient_DataObj[] dataObj;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_doctorlist_activity);

        b = this.getIntent().getExtras();
        final Bundle b = this.getIntent().getExtras();
        megaDataObj = new Patient_MegaDataObj((Patient_MegaDataObj) b.getParcelable("megadata"), 0);
        int doctorCount = megaDataObj.getData().length;
        int incr = 0;
        dataObj = new Patient_DataObj[doctorCount];
        while (incr < doctorCount) {
            dataObj[incr] = new Patient_DataObj(megaDataObj.getData()[incr]);
            incr++;
        }
        //Patient[] values = new Patient[2];
        //values[0] = new Patient(0, "Jean", "Dupont", "10/08/2013 12h42", "15/08/2013 15h00", "Blah Blah MEDECIN blah blah TEST blah blah LUPUS");
        //values[1] = new Patient(1, "Janine", "Dupont", "12/06/2013 16h24", "01/09/2013 18h00", "Blah Blah MEDECIN blah blah TEST blah blah ");

        doctorListArrayAdapter = new Patient_DoctorListArrayAdapter(this, dataObj);
        setListAdapter(doctorListArrayAdapter);
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
        Patient_DataObj patient_dataObj;
        patient_dataObj = (Patient_DataObj) this.getListAdapter().getItem(position);
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("data", patient_dataObj);
        i.putExtras(b);
        i.setClass(this, Patient_DoctorSingleActivity.class);
        startActivity(i);
    }
}

