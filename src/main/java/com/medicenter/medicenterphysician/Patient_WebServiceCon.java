package com.medicenter.medicenterphysician;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class Patient_WebServiceCon extends AsyncTask<Void, Void, String> {
    private Context context;
    Patient_WebService ws;
    int id;
    String res;

    Patient_WebServiceCon(int id) {
        this.id = id;
        this.res = null;
    }

    String getRes() {
        return res;
    }

    @Override
    protected String doInBackground(Void... params) {
        android.os.Debug.waitForDebugger();
        ws = new Patient_WebService(id);
        try {
            res = ws.retrieveStream();
            Log.w("toto", res);
            return res;
        } catch (Exception e) {
            System.out.println(e);
            res = "fail";
            return "fail";
        }
    }
}
