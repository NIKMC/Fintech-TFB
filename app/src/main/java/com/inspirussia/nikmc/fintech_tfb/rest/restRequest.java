package com.inspirussia.nikmc.fintech_tfb.rest;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.internal.http.StatusLine;

/**
 * Created by NIKMC on 18-Sep-16.
 */
public class restRequest {


    public boolean signIn(String login, String password){
        String webPage = "http://40.85.141.154:8083";

        String authString = login + ":" + password;
        System.out.println("auth string: " + authString);
        String authEncBytes = Base64.encodeToString(authString.getBytes(),Base64.NO_WRAP);
        System.out.println("Base64 encoded auth string: " + authEncBytes);


        StringBuilder result = new StringBuilder();

        URL serverUrl;
        HttpURLConnection urlConnection;
        try {
            serverUrl = new URL(webPage + "/rest/personal/product");

            urlConnection = (HttpURLConnection) serverUrl.openConnection();
            Log.d("myLogs", serverUrl.toString());
            urlConnection.setRequestProperty("Content-Type", "application/json");
             urlConnection.setRequestProperty("Authorization", "Basic " + authEncBytes); //Base64.encodeToString((Extras.CLIENT_ID + ":" + Extras.SECRET_KEY).getBytes("UTF-8"), Base64.DEFAULT));
            urlConnection.setRequestMethod("GET");

            /*String param ="Phone=" + URLEncoder.encode(phone, "UTF-8")+
                    "&OfferAgree="+URLEncoder.encode("true","UTF-8")+
                    "&isMobile="+URLEncoder.encode("true","UTF-8");*/


            /*urlConnection.setRequestProperty("Phone", phone);
            urlConnection.setRequestProperty("OfferAgree", "true");
            urlConnection.setRequestProperty("isMobile", "true");*/
            InputStream in;

            int status = urlConnection.getResponseCode();

            if(status >= HttpURLConnection.HTTP_BAD_REQUEST || status == HttpURLConnection.HTTP_UNAUTHORIZED)
                in = urlConnection.getErrorStream();
            else
                in = urlConnection.getInputStream();
            //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }

            Log.d("myLogs", "result: " + result.toString());

            urlConnection.disconnect();
        } catch (Exception e) {
            Log.e("myLogs", e.toString());
            e.printStackTrace();
        }




return true;


    }


/*
    public boolean getPerson(String login, String password){
    StringBuilder result = new StringBuilder();

    URL serverUrl;
    HttpURLConnection urlConnection;
    try {
        serverUrl = new URL("http://40.85.141.154:8083" + "/rest/personal/product");

        urlConnection = (HttpURLConnection) serverUrl.openConnection();
        Log.d("myLogs", serverUrl.toString());
        urlConnection.setRequestProperty("Content-Type", "application/json");
        // urlConnection.setRequestProperty("Authorization", "Basic " + Base64.encodeToString((Extras.CLIENT_ID + ":" + Extras.SECRET_KEY).getBytes("UTF-8"), Base64.DEFAULT));
        urlConnection.setRequestMethod("GEt");

            */
/*String param ="Phone=" + URLEncoder.encode(phone, "UTF-8")+
                    "&OfferAgree="+URLEncoder.encode("true","UTF-8")+
                    "&isMobile="+URLEncoder.encode("true","UTF-8");*//*


        JSONObject jsonParam = new JSONObject();
        jsonParam.put("Phone", phone);
        jsonParam.put("OfferAgree", true);
        jsonParam.put("isMobile", true);

        Log.d("myLogs", jsonParam.toString());

        PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
        //printWriter.print(param);

        printWriter.print(jsonParam.toString());
        //   printWriter.print();
        printWriter.close();

            */
/*urlConnection.setRequestProperty("Phone", phone);
            urlConnection.setRequestProperty("OfferAgree", "true");
            urlConnection.setRequestProperty("isMobile", "true");*//*

        InputStream in;

        int status = urlConnection.getResponseCode();

        String cookie = urlConnection.getHeaderField("Set-Cookie");
        if (cookie != null) {
            Log.d("myLogs","cookie: " + cookie);
            cookie = cookie.substring(0, cookie.indexOf(";") + 1);
            Log.d("myLogs","cookie: " + cookie);
            SharedPreferences sPref = mContext.getSharedPreferences(Extras.AUTH, mContext.MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(Extras.COOKIE, cookie);
            ed.apply();
        } else {
            Log.e("myLogs", "have no cookie");
        }

        if(status >= HttpURLConnection.HTTP_BAD_REQUEST || status == HttpURLConnection.HTTP_UNAUTHORIZED)
            in = urlConnection.getErrorStream();
        else
            in = urlConnection.getInputStream();
        //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        Log.d("myLogs", "result: " + result.toString());

        urlConnection.disconnect();
    } catch (Exception e) {
        Log.e("myLogs", e.toString());
        e.printStackTrace();
    }

    return result.toString();
}
*/
}
