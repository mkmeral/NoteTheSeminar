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


public class addComment extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SubTopic - 1");
        setContentView(R.layout.activity_add_comment);
        EditText title = (EditText) findViewById(R.id.add_comment_title);
        EditText note = (EditText) findViewById(R.id.add_comment_note);
        Button addComment = (Button) findViewById(R.id.add_comment_button);
        String [] params = {"BASE URL", "title", title.getText().toString(), "note", note.getText().toString()};

        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your note has been successfully uploaded", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("org.tevitol.incnet.notethesemianar.viewComment");
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_comment, menu);
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
