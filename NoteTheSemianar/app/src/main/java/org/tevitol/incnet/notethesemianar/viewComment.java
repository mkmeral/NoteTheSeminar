package org.tevitol.incnet.notethesemianar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class viewComment extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comment);

        TextView author = (TextView) findViewById(R.id.view_comment_author);
        TextView desc = (TextView) findViewById(R.id.view_comment_desc);
        try {
            //String[] params = {"BASE URL", "noteId", note_id};
            //String getData = new GetJSON().execute(params).get();
            //String[][] data = new eventsJSON().execute(getData).get();


            setTitle("Note - 1");
            author.setText("Murat Kaan Meral");
            desc.setText("This note might be too long and boring so i think you should stop reading this note. Why do you keep reading it, its meaningless !!!");
        }catch (Exception e){
            Log.e("PROBLEM -  ", e.toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_comment, menu);
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
