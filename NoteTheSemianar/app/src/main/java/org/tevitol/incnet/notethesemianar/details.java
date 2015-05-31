package org.tevitol.incnet.notethesemianar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class details extends ActionBarActivity {

    private String API_KEY = "AIzaSyDLSTqPXt3WwDeWaK17WNxhNcsAWH7931s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("ID");



        TextView presenter = (TextView) findViewById(R.id.details_presenter);
        TextView date = (TextView) findViewById(R.id.details_date);
        TextView time = (TextView) findViewById(R.id.details_time);
        TextView desc = (TextView) findViewById(R.id.details_desc);
        //ImageView image = (ImageView) findViewById(R.id.details_image);
        ListView subTopics = (ListView) findViewById(R.id.sub_topics);
        //String[][] details = null;
        String [] params = {"BASE_URL", "OTHER THINGS"};
        Log.v("Before Try","");
        try {
            Log.v("In Try","");
            //String jsonOut = new GetJSON().execute(params).get();
            //details = new eventsJSON().execute(jsonOut).get();
            String[] details = new String[5];
            details = new String []{"Seminar #1","Ali", "10/12/2015", "10:10:10", "This is an description about this event and it might be long"};
            String[] subtopicList = new String[10];
            subtopicList = new String[]{"GEAGEA", "AEGADF", "ASFSAF", "Entelli şeyler hakkında çok ateşli ve entelli konuşmalar var burda bide yemek ;)"};
            setTitle(details[0]);
            presenter.setText(details[1]);
            date.setText(details[2]);
            time.setText(details[3]);
            desc.setText(details[4]);

            //image.setImageResource(R.drawable.seminarpic);
            Log.e("ARRAY ADAPTER ", subtopicList[0]);
            Log.e("ARRAY ADAPTER ", subtopicList[1]);
            Log.e("ARRAY ADAPTER ", subtopicList[2]);
            Log.e("ARRAY ADAPTER ", subtopicList[3]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.subtopic_listview, subtopicList);
            subTopics.setAdapter(adapter);

            final String[] finalSubtopicList = subtopicList;
            subTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent("org.tevitol.incnet.notethesemianar.comments");
                    intent.putExtra("Topic", getTitle().toString());
                    intent.putExtra("subTopic", finalSubtopicList[position]);
                    startActivity(intent);
                }
            });

        } catch (Exception  e) {
            e.printStackTrace();
            Log.e("ERROR DETAILS ", e.toString());
        }

        /*final String[] finalDetails = details[4];
        subTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("Topic", finalDetails);
                intent.putExtra("Subtopic", finalDetails[position]);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
