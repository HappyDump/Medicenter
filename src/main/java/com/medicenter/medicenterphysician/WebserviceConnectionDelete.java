package com.medicenter.medicenterphysician;

import android.content.Context;
import android.os.AsyncTask;
import com.medicenter.medicenterphysician.handlers.WebserviceHandler;
import org.apache.http.NameValuePair;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: HappyDump
 * Date: 9/14/13
 * Time: 12:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class WebserviceConnectionDelete extends AsyncTask<ArrayList<NameValuePair>, Void, String> {
    private Context context;
    WebserviceHandler ws;

    protected String doInBackground(ArrayList<NameValuePair>... nLists) {
        android.os.Debug.waitForDebugger();
        ws = new WebserviceHandler();
        try {
            String res = ws.send("remove-patient", nLists[0]);
            System.out.println(res);
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return "fail";
        }

    }

    // protected onPostExecute(){

    //}
}
