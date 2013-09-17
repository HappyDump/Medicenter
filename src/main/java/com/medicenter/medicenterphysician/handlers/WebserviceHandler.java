package com.medicenter.medicenterphysician.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: HappyDump
 * Date: 9/11/13
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class WebserviceHandler {

    public String send(String action, ArrayList<NameValuePair> params) throws Exception {
        InputStream is = null;
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            String url = "http://medicenter.px751.fr/ws/patients/" + action;
            HttpPost httppost = new HttpPost(url);


            httppost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            throw new Exception("Connexion au serveur impossible." + e.getMessage());
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
                sb.append(line + "\n");
            is.close();
            result = sb.toString();
            return result;
        } catch (Exception e) {
            throw new Exception("Impossible d'interpréter la réponse du serveur.");
        }
    }
}