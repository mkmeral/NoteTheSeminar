package org.tevitol.incnet.notethesemianar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class createNewEvent extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_event);

        final EditText title =(EditText) findViewById(R.id.new_title);
        final EditText location =(EditText) findViewById(R.id.new_location);
        final EditText date =(EditText) findViewById(R.id.new_date);
        final EditText time =(EditText) findViewById(R.id.new_time);
        final EditText description =(EditText) findViewById(R.id.new_desc);
        Button button = (Button) findViewById(R.id.new_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] params = {"BASE URL",
                        "title", String.valueOf(title.getText()),
                        "location", String.valueOf(location.getText()),
                        "date", String.valueOf(date.getText()),
                        "time", String.valueOf(time.getText()),
                        "description", String.valueOf(description.getText())};
                /*try {
                    done = new PostJSON().execute(params).get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }*/

                Toast.makeText(getApplicationContext(), "Your event has been sucessfully uploaded", Toast.LENGTH_LONG).show();

                Intent intent = new Intent("org.tevitol.incnet.notethesemianar.details");
                intent.putExtra("ID", "1");
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_new_event, menu);
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
