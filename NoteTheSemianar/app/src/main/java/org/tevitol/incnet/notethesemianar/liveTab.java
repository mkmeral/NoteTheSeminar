package org.tevitol.incnet.notethesemianar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by mkmer on 30.05.2015.
 */
public class liveTab extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_live);

        TextView tv = (TextView) findViewById(R.id.add_event_live);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("org.tevitol.incnet.createNewEvent");
                startActivity(intent);
            }
        });

        try {
            generateForTabs tabs = new generateForTabs();
            Log.v("Before Called", "parsedJSON");
            String[][] parsedJSON = new String[10][10];
            parsedJSON = tabs.parsedJSON("0");

            Log.v("JSON 0", parsedJSON[0][0] + " ," +parsedJSON[0][1] + " ," +parsedJSON[0][2] + " ," +parsedJSON[0][3] + " ," +parsedJSON[0][4]);

            ListView listView = (ListView) findViewById(R.id.live_list_view);
            listView.setAdapter(new mainCustomAdapter(this, parsedJSON[1], parsedJSON[0], parsedJSON[3]));
        } catch (Exception e) {
            Log.e("EXCEPTION ", e.toString());
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}