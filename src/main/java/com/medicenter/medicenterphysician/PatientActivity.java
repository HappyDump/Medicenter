package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.medicenter.medicenterphysician.handlers.WebserviceHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class PatientActivity extends Activity {
    Button btn_general, btn_medication, btn_specificities;
    ImageView imgView;
    ImageView pic;
    Bundle b;
    WebserviceHandler ws;
    ArrayList<NameValuePair> nameValuePairs;
    WebserviceConnectionDelete wc;
    Patient p;
    DatabaseHandler dbh;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_layout);

        dbh = new DatabaseHandler(this);

        p = new Patient();
        TextView name = (TextView) findViewById(R.id.nameFill);
        TextView fName = (TextView) findViewById(R.id.fnameFill);
        TextView email = (TextView) findViewById(R.id.emailFill);
        TextView age = (TextView) findViewById(R.id.ageFill);
        TextView street = (TextView) findViewById(R.id.streetFill);
        TextView streetNo = (TextView) findViewById(R.id.streetNoFill);
        TextView city = (TextView) findViewById(R.id.cityFill);
        TextView country = (TextView) findViewById(R.id.countryFill);
        TextView desc = (TextView) findViewById(R.id.descFill);
        TextView gen = (TextView) findViewById(R.id.genderFill);
        TextView bPlace = (TextView) findViewById(R.id.bPlaceFill);
        TextView phone = (TextView) findViewById(R.id.phoneFill);
        TextView ssn = (TextView) findViewById(R.id.ssnFill);
        b = this.getIntent().getExtras();

        if (b != null) {
            p = b.getParcelable("patient");
            name.setText(p.name);
            fName.setText(p.fName);
            email.setText(p.age);
            age.setText(p.email);
            street.setText(p.street);
            streetNo.setText(p.streetNo);
            city.setText(p.city);
            country.setText(p.country);
            desc.setText(p.desc);
            gen.setText(p.gender);
            bPlace.setText(p.birthPlace);
            phone.setText(p.phone);
            ssn.setText(p.ssn);
        }
        btn_general = (Button) findViewById(R.id.general_tab);
        btn_specificities = (Button) findViewById(R.id.specificities_tab);
        btn_medication = (Button) findViewById(R.id.medication_tab);

        imgView = (ImageView) findViewById(R.id.headerImg);
        pic = (ImageView) findViewById(R.id.icon);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            }
        });

        /*btn_edit = (Button)findViewById(R.id.editPatient);
        btn_edit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent i = new Intent(getApplicationContext(), EditPatientActivity.class);

                startActivity(i);
            }
        });  */
        btn_general.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        btn_specificities.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
                startActivity(i);
            }
        });

        pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dispatchPictureIntent(0);
            }
        });

    }

    public void dispatchPictureIntent(int actionCode) {
        boolean hasIntent = false;
        hasIntent = isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE);
        if (hasIntent == true) {
            Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            takePicIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
            takePicIntent.putExtra("crop", "true");
            takePicIntent.putExtra("aspectX", 0);
            takePicIntent.putExtra("aspectY", 0);
            takePicIntent.putExtra("outputX", 150);
            takePicIntent.putExtra("outputY", 150);

            takePicIntent.putExtra("return-data", true);
            startActivityForResult(takePicIntent, actionCode);

        }
    }

    public static boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            pic.setImageBitmap(photo);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.patient_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editPatientDetails:

                Patient toGive = b.getParcelable("patient");
                Intent i2 = new Intent();
                Bundle b2 = new Bundle();
                b2.putParcelable("patient", toGive);
                i2.putExtras(b2);
                i2.setClass(getApplicationContext(), EditPatientActivity.class);
                startActivity(i2);

                return true;

            case R.id.meetingPatient:

                Patient toGive2 = b.getParcelable("patient");
                Intent i3 = new Intent();
                Bundle b3 = new Bundle();
                b3.putParcelable("patient", toGive2);
                i3.putExtras(b3);
                i3.setClass(getApplicationContext(), MeetingListPatientActivity.class);
                startActivity(i3);

                return true;

            case R.id.deletePatient:
                ws = new WebserviceHandler();
                nameValuePairs = new ArrayList<NameValuePair>();

                String id = String.valueOf(p.getId());
                nameValuePairs.add(new BasicNameValuePair("patient_id", id));
                String res = new String("");
                wc = new WebserviceConnectionDelete();
                try {
                    res = wc.execute(nameValuePairs).get();
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (res != "fail")
                    dbh.deletePatient(p);
                Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
