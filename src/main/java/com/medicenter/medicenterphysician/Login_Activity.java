package com.medicenter.medicenterphysician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class Login_Activity extends Activity {

    String userName, passWord;
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //return; // C'est gratuit ;)
        super.onCreate(savedInstanceState);
        DatabaseHandler db = new DatabaseHandler(this);
        //db.clearTable();
        /*db.addPatient(new Patient("Jb", "Meyer", "04/06/2013", "27/06/2013", "Lorem Ipsum..." ));
        db.addPatient(new Patient("Edy", "Chain", "04/06/2013", "27/06/2013", "Lorem Ipsum..." ));
        db.addPatient(new Patient("François", "de Berry", "08/06/2013", "28/06/2013", "Lorem Ipsum..." ));
        db.addPatient(new Patient("Anna", "Brotherson", "17/06/2013", "27/06/2013", "Lorem Ipsum..." ));
        db.addPatient(new Patient("Hugo", "Avenal", "02/08/2013", "27/06/2013", "Lorem Ipsum..." ));
        db.addPatient(new Patient("Claire", "Peniche", "31/8/2013", "27/06/2013", "Lorem Ipsum..." ));
        db.addPatient(new Patient("Karl-Oscar", "Davidson", "04/06/2013", "27/06/2013", "Lorem Ipsum..." ));*/

        setContentView(R.layout.login_activity);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(loginListener);
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception ex) {

        }
    }

    private OnClickListener loginListener = new OnClickListener() {

        public void onClick(View v) {
            System.out.println(username.getText().toString());
            System.out.println(password.getText().toString());
            if (username.getText().toString().equals("admin") &&
                    password.getText().toString().equals("admin")) {
//responding to the User inputs
                Intent i = new Intent(getApplicationContext(), Menu_Page.class);
                startActivity(i);
            } else if (username.getText().toString().equals("patient") &&
                    password.getText().toString().equals("patient")) {
                Intent i = new Intent(getApplicationContext(), Patient_Menu_Page.class);
                startActivity(i);
            } else if (username.getText().toString().equals("patient") &&
                    password.getText().toString().equals("patient")) {
                Intent i = new Intent(getApplicationContext(), Patient_Menu_Page.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Error! Bad Login or Password.", Toast.LENGTH_SHORT).show();
                System.out.println("---ELSE---");
            }
        }

        ;

        @SuppressWarnings("unused")
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.login_activity, menu);
            return true;
        }
    };
}
