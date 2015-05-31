package org.tevitol.incnet.notethesemianar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(NTS.username != null){
            Intent intent= new Intent(String.valueOf(TabBar.class));
            startActivity(intent);
        }
        final EditText uname = (EditText) findViewById(R.id.login_uname);
        final EditText password = (EditText) findViewById(R.id.login_pass);
        Button login = (Button) findViewById(R.id.login_button);
        Button register = (Button) findViewById(R.id.login_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String[] params = {"BASE URL",
                    //"username", String.valueOf(uname.getText()),
                    //"password", String.valueOf(password.getText())};

                    //JSONObject output = new ASD().execute(params).get();
                    //if(output != null) {
                      //  String[][] data = new eventsJSON().execute(output.toString()).get();
                        NTS.username = "uname";
                        NTS.TOKEN = "token";
                        Intent intent= new Intent("org.tevitol.incnet.TabBar");
                        startActivity(intent);
                   /* }else{
                        Toast.makeText(getApplicationContext(), "Wrong Username or Password.", Toast.LENGTH_LONG).show();
                    }*/

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("org.tevitol.incnet.notethesemianar.Register");
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
