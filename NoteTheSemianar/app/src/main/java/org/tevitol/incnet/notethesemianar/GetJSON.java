package org.tevitol.incnet.notethesemianar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetJSON extends AsyncTask<String, Void, String> {
    String result = null;

    @Override
    protected String doInBackground(String... params) {
        Log.v("IN GETJSON 111- ", String.valueOf(params.length));
        try {
            Log.v("IN GETJSON - ", String.valueOf(params.length));
            int i;
            int timeout= 150000;
            String URI_BASE = NTS.IP+params[0];
            // Start building Uri to connect REST API

            Uri.Builder restUri = Uri.parse(URI_BASE).buildUpon()
                    .appendQueryParameter("token", NTS.TOKEN);
            //Get all Parameters for URI and set them.
            for (i = 1; i < params.length; i++) {
                restUri.appendQueryParameter(params[i], params[++i]);
            }
            restUri.build();

            Log.v("URI BUILT - " ,restUri.toString());
            URL restUrl = new URL(restUri.toString());

            Log.v("URL -   ", restUrl.toString());

            //Set Connection Variables
            HttpURLConnection connection = (HttpURLConnection) restUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setAllowUserInteraction(false);
            connection.setUseCaches(false);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            //Start Connection
            connection.connect();

            //Get Status Of Connection
            int status = connection.getResponseCode();
            Log.v("Status - ", String.valueOf(status));
            switch (status){
                case 200:
                case 201:
                    //Completed The Request
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    Log.v("JSON STRING -    ", sb.toString());
                    result = sb.toString();
                    break;
                default:
                    connection.disconnect();
                    break;
            }


        }
        catch (Exception e){
            Log.e("ERROR - ", e.toString());
        }
        return result;
    }

}

class getImage extends AsyncTask<String, Void,Bitmap>{

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap result = null;
        try {

            URL urlConnection = new URL(params.toString());
            HttpURLConnection connection = (HttpURLConnection) urlConnection
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            result = BitmapFactory.decodeStream(input);
        }
        catch (Exception e){
            Log.e("PROBLEM WITH IMAGE - ", e.toString());
        }
        return result;
    }
}