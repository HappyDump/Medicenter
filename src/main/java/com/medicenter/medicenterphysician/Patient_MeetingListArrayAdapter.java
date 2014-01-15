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
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class Patient_MeetingListArrayAdapter extends ArrayAdapter<Patient_Meeting> {
    private final Activity context;
    private final Patient_Meeting[] meetings;

    static class ViewHolder {
        public TextView text;
        //public TextView last;
    }

    public Patient_MeetingListArrayAdapter(Activity context, Patient_Meeting[] meetings) {
        super(context, R.layout.patient_meetinglist_item_layout, meetings);
        this.context = context;
        this.meetings = meetings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.patient_meetinglist_item_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.firstLine);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Patient_Meeting p = meetings[position];
        holder.text.setText(p.getDateBegin() + " " + p.getDateEnd());

        return rowView;
    }
}
