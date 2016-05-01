package com.greetingapp.singhdeepak.greetingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button greetButton;
    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        greetButton = (Button) findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);

        // switchButton is an example to use intent to pass from one screen activity to another.
        switchButton = (Button) findViewById(R.id.switchButton);
        switchButton.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.greetfriend, menu);
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




    @Override
    public void onClick(View v) {
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        TextView textShowMessage = (TextView) findViewById(R.id.textShowMessage);

        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        String friendName = editFriendName.getText().toString();


// To display greetings based on time of the day
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        switch (v.getId()) {
            case R.id.greetButton:
               // if (hour >0){
                textMessage.setText(getString(R.string.greetstring) + friendName + "!");
                break;
                //   }
          //  else hour == 12 {
         //       textMessage.setText("Good Evening " + friendName + "!");
           //     break;
         //   }

            default:
                break;

        }


        // example of intent. passing message from one activity to another.
        switch (v.getId()){
            case R.id.switchButton:
                // start a new activity from current activity
                Intent in = new Intent(this, showMessage.class);

                // putExtra is a method of passing info from one activity to next activity using intent to carry it as a payload.
               in.putExtra("message", getString(R.string.greetFrnd) + friendName + "!");

                startActivity(in);

                // How intent works or starting a new activity within android
                // 1. We create intent object and call StartActivity
                // 2. StartActivity calls Android framework
                // 3. Android Framework issues a call to start e new activity with the intent provided by calling the onCreate() method of new activity
                break;


            default:
                break;
        }

    }
}
