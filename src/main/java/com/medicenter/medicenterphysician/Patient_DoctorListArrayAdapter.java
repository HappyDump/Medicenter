package com.medicenter.medicenterphysician;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 25/10/13
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */

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
public class Patient_DoctorListArrayAdapter extends ArrayAdapter<Patient_DataObj> {
    private final Activity context;
    private final Patient_DataObj[] dataObjs;

    static class ViewHolder {
        public TextView text;
        //public TextView last;
    }

    public Patient_DoctorListArrayAdapter(Activity context, Patient_DataObj[] dataObj) {
        super(context, R.layout.patient_doctorlist_item_layout, dataObj);
        this.context = context;
        this.dataObjs = dataObj;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.patient_doctorlist_item_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Patient_DataObj p = dataObjs[position];
        holder.text.setText(p.getFirstName().concat(p.getName()));

        return rowView;
    }
}
