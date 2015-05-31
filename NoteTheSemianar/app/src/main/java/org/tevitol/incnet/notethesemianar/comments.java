package org.tevitol.incnet.notethesemianar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class comments extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        Bundle extras = getIntent().getExtras();
        String topic = extras.getString("Topic");
        String subtopic = extras.getString("subTopic");
        setTitle(subtopic);

        //String [] params = {"BASE URL", "topic", topic, "subtopic", subtopic};

        try {
            String[] dataOne = {"Note -1","Note -2","Note-3","Note-4","Note-5"};
            String[] dataTwo = {"Description-1","Description-2","Description-3","Description-4","Description-5"};
            String[] dataThree = {"0","0","1","2","2"};
            String[] dataFour = {"1","2","3","4","5"};
            //String getData = new GetJSON().execute(params).get();
            //String[][] data = new eventsJSON().execute(getData).get();

            ListView lv = (ListView) findViewById(R.id.comment_list_view);
            lv.setAdapter(new commentCustomAdapter(getApplicationContext(), dataOne, dataTwo, dataThree, dataFour));
        }catch (Exception e){
            Log.e("PROBLEM WITH COMMENTS -  " ,e.toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        Intent intent = new Intent("org.tevitol.incnet.notethesemianar.addComment");
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
