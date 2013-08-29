package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/07/13
 * Time: 00:43
 * To change this template use File | Settings | File Templates.
 */
public class MeetingMenuAdapter extends ArrayAdapter<Meeting> {
    private final Activity context;
    private final Meeting[] meetings;
    DatabaseHandler dbh;
    ImageView imgView;

    static class ViewHolder {
        public TextView text;
        public TextView last;
    }

    public MeetingMenuAdapter(Activity context, Meeting[] meetings) {
        super(context, R.layout.meeting_menu_list_layout, meetings);
        this.context = context;
        this.meetings = meetings;
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
        Meeting p = meetings[position];
        holder.text.setText(p.getDate());
        dbh = new DatabaseHandler(getContext());
        patient = dbh.getPatient(p.getPatientId());
        Log.w("meetingmenu", "blablabla => " + patient.getId());
        Log.w("meetingmenu", "blablabla => " + patient.getName());
        Log.w("meetingmenu", "blablabla => " + patient.getfName());
        holder.last.setText(patient.getName().concat(" ").concat(patient.getfName()));

        return rowView;
    }
}