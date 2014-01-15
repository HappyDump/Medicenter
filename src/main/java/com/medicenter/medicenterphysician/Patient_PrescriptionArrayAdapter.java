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
 * Date: 25/10/13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class Patient_PrescriptionArrayAdapter extends ArrayAdapter<Patient_Prescription> {
    private final Activity context;
    private final Patient_Prescription[] prescriptions;

    static class ViewHolder {
        public TextView text;
        //public TextView last;
    }

    public Patient_PrescriptionArrayAdapter(Activity context, Patient_Prescription[] prescriptions) {
        super(context, R.layout.patient_prescriptionlist_item_layout, prescriptions);
        this.context = context;
        this.prescriptions = prescriptions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.patient_prescriptionlist_item_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Patient_Prescription p = prescriptions[position];
        holder.text.setText(p.getDate() + " " + p.getText());

        return rowView;
    }
}
