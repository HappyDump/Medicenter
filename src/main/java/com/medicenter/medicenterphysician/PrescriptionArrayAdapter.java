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
public class PrescriptionArrayAdapter extends ArrayAdapter<Prescription> {
    private final Activity context;
    private final Prescription[] prescriptions;

    static class ViewHolder {
        public TextView text;
        //public TextView last;
    }

    public PrescriptionArrayAdapter(Activity context, Prescription[] prescriptions) {
        super(context, R.layout.prescription_item_list_layout, prescriptions);
        this.context = context;
        this.prescriptions = prescriptions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.prescription_item_list_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Prescription p = prescriptions[position];
        holder.text.setText(p.getMedic());
        //holder.last.setText("Last Visit: ".concat(p.lastMeet));

        return rowView;
    }
}