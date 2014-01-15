package com.medicenter.medicenterphysician;

import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 24/10/13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
public class Patient_WebService {
    int id;
    String url = "http://medicenter.px751.fr/ws/patients/get-patient-data/id/2";

    Patient_WebService(int id) {
        this.id = id;
    }

    public String retrieveStream() {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(url);

        try {

            HttpResponse getResponse = client.execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w("toto", "blablablablablalbalblablalblablal");
                Log.w(getClass().getSimpleName(),
                        "Error " + statusCode + " for URL " + url);
                Log.w("toto", "blablablablablalbalblablalblablal");
                return null;
            }
            HttpEntity getResponseEntity = getResponse.getEntity();
            InputStream is = getResponseEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            String result;
            while ((line = reader.readLine()) != null)
                sb.append(line + "\n");
            is.close();
            result = sb.toString();
            return result;

        } catch (IOException e) {
            getRequest.abort();
            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        return null;
    }
}
