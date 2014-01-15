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
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public class Patient_MeetingListActivity extends ListActivity {
    Patient_MeetingListArrayAdapter meetingListArrayAdapter;
    ImageView imgView;
    Bundle b;
    Patient_MegaDataObj megaDataObj;
    Patient_DataObj[] dataObj;
    Patient_Meeting[] meetings;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_meetinglist_activity);

        b = this.getIntent().getExtras();
        final Bundle b = this.getIntent().getExtras();
        megaDataObj = new Patient_MegaDataObj((Patient_MegaDataObj) b.getParcelable("megadata"), 1);
        int doctorCount = megaDataObj.getData().length;
        int incr = 0;
        dataObj = new Patient_DataObj[doctorCount];
        int totalMeetings = 0;
        while (incr < doctorCount) {
            dataObj[incr] = new Patient_DataObj(megaDataObj.getData()[incr]);
            totalMeetings = totalMeetings + dataObj[incr].getMeetings().length;
            incr++;
        }
        meetings = new Patient_Meeting[totalMeetings];
        incr = 0;
        int c = 0;
        while (incr < doctorCount) {
            int a = 0;
            while (a < dataObj[incr].getMeetings().length) {
                meetings[c] = new Patient_Meeting(dataObj[incr].getMeetings()[a]);
                c++;
                a++;
            }
            incr++;
        }
        //Patient[] values = new Patient[2];
        //values[0] = new Patient(0, "Jean", "Dupont", "10/08/2013 12h42", "15/08/2013 15h00", "Blah Blah MEDECIN blah blah TEST blah blah LUPUS");
        //values[1] = new Patient(1, "Janine", "Dupont", "12/06/2013 16h24", "01/09/2013 18h00", "Blah Blah MEDECIN blah blah TEST blah blah ");

        meetingListArrayAdapter = new Patient_MeetingListArrayAdapter(this, meetings);
        setListAdapter(meetingListArrayAdapter);
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
        Patient_Meeting meeting;
        meeting = new Patient_Meeting((Patient_Meeting) this.getListAdapter().getItem(position));
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("meeting", meeting);
        i.putExtras(b);
        i.setClass(this, Patient_MeetingSingleActivity.class);
        startActivity(i);
    }
}
