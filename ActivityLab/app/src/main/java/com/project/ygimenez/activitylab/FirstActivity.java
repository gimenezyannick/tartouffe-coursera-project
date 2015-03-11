package com.project.ygimenez.activitylab;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class FirstActivity extends ActionBarActivity {


    /**
     * Components
     */
    private TextView onCreateCptView;
    private TextView onStartCptView;
    private TextView onResumeCptView;
    private TextView onRestartCptView;
    private Button startActivity2Button;

    /**
     * Variables
     */
    private int onCreateCpt;
    private int onStartCpt;
    private int onResumeCpt;
    private int onRestartCpt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        /**
         * Components recovery
         */
        onCreateCptView = (TextView) findViewById(R.id.onCreateCptId);
        onStartCptView = (TextView) findViewById(R.id.onStartCptId);
        onResumeCptView = (TextView) findViewById(R.id.onResumeCptId);
        onRestartCptView = (TextView) findViewById(R.id.onRestartCptId);
        startActivity2Button = (Button) findViewById(R.id.startActivity2ButtonId);

        /**
         * Init Components
         */
        if (savedInstanceState != null) {
            onCreateCpt = savedInstanceState.getInt("createCpt");
            onStartCpt = savedInstanceState.getInt("startCpt");
            onResumeCpt = savedInstanceState.getInt("resumeCpt");
            onRestartCpt = savedInstanceState.getInt("restartCpt");
        }else{
            onCreateCpt = 0;
            onStartCpt = 0;
            onResumeCpt = 0;
            onRestartCpt = 0;
        }
        onCreateCptView.setText(""+onCreateCpt);
        onStartCptView.setText(""+onStartCpt);
        onResumeCptView.setText(""+onResumeCpt);
        onRestartCptView.setText(""+onRestartCpt);
        startActivity2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        /**
         * Core onCreate
         */
        onCreateCpt++;
        onCreateCptView.setText(""+onCreateCpt);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStartCpt++;
        onStartCptView.setText(""+onStartCpt);
        Log.i("onStart()", "onStart() method successful");
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumeCpt++;
        onResumeCptView.setText(""+onResumeCpt);
        Log.i("onResume()", "onResume() method successful");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onRestartCpt++;
        onRestartCptView.setText(""+onRestartCpt);
        Log.i("onRestart()", "onRestart() method successful");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop()", "onStop() method successful");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause()", "onPause() method successful");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy()", "onDestroy() method successful");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("createCpt",onCreateCpt);
        outState.putInt("startCpt",onStartCpt);
        outState.putInt("resumeCpt",onResumeCpt);
        outState.putInt("restartCpt",onRestartCpt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
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
