package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/07/13
 * Time: 00:43
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionMenuAdapter extends ArrayAdapter<Prescription> {
    private final Activity context;
    private final Prescription[] prescriptions;
    DatabaseHandler dbh;

    static class ViewHolder {
        public TextView text;
        public TextView last;
    }

    public PrescriptionMenuAdapter(Activity context, Prescription[] prescriptions) {
        super(context, R.layout.prescription_menu_list_layout, prescriptions);
        this.context = context;
        this.prescriptions = prescriptions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.meeting_menu_list_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            viewHolder.last = (TextView) rowView.findViewById(R.id.secondLine);
            rowView.setTag(viewHolder);
        }
        Patient patient = new Patient();
        ViewHolder holder = (ViewHolder) rowView.getTag();
        Prescription p = prescriptions[position];
        holder.text.setText(p.getMedic());
        dbh = new DatabaseHandler(getContext());
        patient = dbh.getPatient(p.getPatientId());
        Meeting m = dbh.getMeeting(p.getMeetingId());
        holder.last.setText(patient.getName() + " " + patient.getfName() + " " + m.getDate());

        return rowView;
    }
}