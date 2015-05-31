package org.tevitol.incnet.notethesemianar;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostJSON extends AsyncTask <String[], Void, Boolean> {

    private String BASE_URI = null;

    @Override
    protected Boolean doInBackground(String[]... params) {
        Boolean done = false;
        int i;
        int timeout = 150000;

        try {

            Uri.Builder postUri = Uri.parse(BASE_URI).buildUpon();
            //Get all Parameters for UR� and set them.
            for (i = 1; i < (params.length - 1); i++) {
                postUri.appendQueryParameter(params[i].toString(), params[i++].toString());
            }
            postUri.build();


            URL restUrl = new URL(postUri.toString());

            //Set Connection Variables
            HttpURLConnection connection = (HttpURLConnection) restUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setAllowUserInteraction(false);
            connection.setUseCaches(false);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            //Start Connection
            connection.connect();

            //Get Status Of Connection
            int status = connection.getResponseCode();

            switch (status){
                case 200:
                case 201:
                    done = true;
                    break;
            }

        }catch (Exception e){
            Log.e("ERROR -  ", e.toString());
        }


        return done;
    }
}

class ASD extends AsyncTask<String [], Void, JSONObject>{

    @Override
    protected JSONObject doInBackground(String[]... params) {
        JSONObject result =null;
        try {
            String BASE_URL = params[0].toString();

            URL object = new URL(BASE_URL);

            HttpURLConnection con = (HttpURLConnection) object.openConnection();

            con.setDoOutput(true);

            con.setDoInput(true);

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            con.setRequestProperty("Accept", "application/json; charset=UTF-8");

            con.setRequestMethod("POST");

            JSONObject output = null;

            for(int i=1; i<params.length;i++){
                output.put(params[i].toString(), params[i++].toString());
            }

            OutputStream os = con.getOutputStream();

            os.write(output.toString().getBytes("UTF-8"));

            os.close();

        //display what returns the POST request

            StringBuilder sb = new StringBuilder();

            int HttpResult = con.getResponseCode();

            if (HttpResult == HttpURLConnection.HTTP_OK) {

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

                String line = null;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }

                br.close();

                result = new JSONObject(sb.toString());

            } else {
                System.out.println(con.getResponseMessage());
            }

        }catch (Exception e){

        }
        return result;
    }
}