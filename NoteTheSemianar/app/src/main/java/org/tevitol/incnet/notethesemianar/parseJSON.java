package org.tevitol.incnet.notethesemianar;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by mkmer on 30.05.2015.
 */
class eventsJSON extends AsyncTask <String, Void, String[][]> {
    @Override
    protected String[][] doInBackground(String... params) {

        String EVENT_TAG = "Event";
        int INDEX_TITLE_TAG = 0;
        int INDEX_PRESENTER_TAG = 1;
        int INDEX_NO_NOTES_TAG = 2;
        int INDEX_IDs = 3;
        String TOKEN_TAG = "Token";

        String[][] output = null;
       try {
            JSONObject input = new JSONObject(params[0]);

            JSONArray events = input.getJSONArray(EVENT_TAG);
            NTS.TOKEN = input.getString(TOKEN_TAG);

            for (int i = 0; i < events.length(); i++) {
                output[0][i] = events.getString(INDEX_TITLE_TAG);
                output[1][i] = events.getString(INDEX_PRESENTER_TAG);
                output[2][i] = events.getString(INDEX_NO_NOTES_TAG);
                output[3][i] = events.getString(INDEX_IDs);
            }
        }catch(Exception e){
            Log.e("ERROR WITH PARSING", e.toString());
        }
        /*output[0] = {"Seminar1","Seminar2","Seminar3","Seminar4","Seminar5"};
        output[1] = {"Ali","Mehmet","Ayse","Anan""Eben"};
        output[2] = {"3","15","17","1","99"};
        output[3] = {"1","2","3","4","5"};
        return output;
*/return output;
    }
}
