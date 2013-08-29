package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AppointmentArrayAdapter extends ArrayAdapter<Appointment> {
    private final Activity context;
    private final Appointment[] appointments;

    static class ViewHolder {
        public TextView text;
        public TextView last;
    }

    public AppointmentArrayAdapter(Activity context, Appointment[] appointments) {
        super(context, R.layout.schedule_list_item, appointments);
        this.context = context;
        this.appointments = appointments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.schedule_list_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            viewHolder.last = (TextView) rowView.findViewById(R.id.secondLine);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Appointment p = appointments[position];
        holder.text.setText(String.valueOf(p.id));
        holder.last.setText("Notes: ".concat(p.notes));

        return rowView;
    }
}
