package com.project.ygimenez.labintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ExplicitActivation extends ActionBarActivity {

    /**
     * Components
     */
    EditText editTextSomeText;
    Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_activation);

        /**
         * Components recuperation
         */
        editTextSomeText = (EditText) findViewById(R.id.idEditTextSomeText);
        buttonEnter = (Button) findViewById(R.id.idButtonEnter);

        /**
         * Init components
         */
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWithExtra = new Intent(ExplicitActivation.this,ActivityLoaderActivity.class);
                String someText = editTextSomeText.getText().toString();
                if(!someText.equals("")){
                    intentWithExtra.putExtra("some_text", someText);
                    setResult(RESULT_OK,intentWithExtra);
                    finish();
                }else{
                    Toast toast = Toast.makeText(ExplicitActivation.this, R.string.no_text_entered, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explicit_activation, menu);
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
