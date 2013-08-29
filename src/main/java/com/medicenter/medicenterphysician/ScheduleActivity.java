package com.medicenter.medicenterphysician;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ScheduleActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_layout);

        Appointment[] values = new Appointment[2];
        values[0] = new Appointment(1, 1, "ejfkzfbkeufbzkeufbz kdjsfdnfjks fiejfieks");
        values[1] = new Appointment(2, 2, "oijd ejksej subfuskdjf sebufksjd");

        AppointmentArrayAdapter appointmentArrayAdapter = new AppointmentArrayAdapter(this, values);
        setListAdapter(appointmentArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        Appointment p = new Appointment();
        p = (Appointment) this.getListAdapter().getItem(position);
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("appointment", p);
        i.putExtras(b);
        i.setClass(this, AppointmentActivity.class);
        startActivity(i);
    }
}