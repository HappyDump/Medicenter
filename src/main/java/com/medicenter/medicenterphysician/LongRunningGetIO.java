package com.medicenter.medicenterphysician;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 25/10/13
 * Time: 03:51
 * To change this template use File | Settings | File Templates.
 */
public class LongRunningGetIO extends AsyncTask<Void, Void, String> {
    int id = 0;
    String result = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    LongRunningGetIO(int id) {
        this.id = id;
    }

    protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
        InputStream in = entity.getContent();


        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n > 0) {
            byte[] b = new byte[4096];
            n = in.read(b);


            if (n > 0) out.append(new String(b, 0, n));
        }


        return out.toString();
    }


    @Override


    protected String doInBackground(Void... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet("http://medicenter.px751.fr/ws/patients/get-patient-data/id/" + this.id);
        String text = null;
        try {
            HttpResponse response = httpClient.execute(httpGet, localContext);


            HttpEntity entity = response.getEntity();


            text = getASCIIContentFromEntity(entity);


        } catch (Exception e) {
            return e.getLocalizedMessage();
        }


        return text;
    }


    protected void onPostExecute(String results) {
        if (results != null) {
            Log.w("toto", results);
            result = results;
            id = 1;


        }

    }


}
