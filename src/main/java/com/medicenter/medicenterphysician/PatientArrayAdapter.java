package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PatientArrayAdapter extends ArrayAdapter<Patient> {
    private final Activity context;
    private final Patient[] patients;

    static class ViewHolder {
        public TextView text;
        //public TextView last;
    }

    public PatientArrayAdapter(Activity context, Patient[] patients) {
        super(context, R.layout.patients_item_list_layout, patients);
        this.context = context;
        this.patients = patients;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.patients_item_list_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            //viewHolder.last = (TextView) rowView.findViewById(R.id.secondLine);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Patient p = patients[position];
        holder.text.setText(p.name.concat(" ").concat(p.fName));
        //holder.last.setText("Last Visit: ".concat(p.lastMeet));

        return rowView;
    }
}
