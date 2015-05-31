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
public class pastTab extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_past);

        TextView tv = (TextView) findViewById(R.id.add_event_past);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("org.tevitol.incnet.createNewEvent");
                startActivity(intent);
            }
        });


        try {
            generateForTabs tabs = new generateForTabs();
            String[][] parsedJSON = tabs.parsedJSON("-1");


            ListView listView = (ListView) findViewById(R.id.past_list_view);
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