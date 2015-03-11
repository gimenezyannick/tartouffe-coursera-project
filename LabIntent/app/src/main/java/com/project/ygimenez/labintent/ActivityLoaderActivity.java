package com.project.ygimenez.labintent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;
import java.util.List;


public class ActivityLoaderActivity extends ActionBarActivity {

    /**
     * Components
     */
    TextView textViewSomeText;
    Button buttonExplicitActivation;
    Button buttonImplicitActivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_loader);

        /**
         * Components recuperation
         */
        textViewSomeText = (TextView) findViewById(R.id.idTextViewSomeText);
        buttonExplicitActivation = (Button) findViewById(R.id.idButtonExplicitActivation);
        buttonImplicitActivation = (Button) findViewById(R.id.idButtonImplicitActivation);

        /**
         * Init Components
         */
        buttonExplicitActivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLoaderActivity.this, ExplicitActivation.class);
                startActivityForResult(intent, 1);
            }
        });
        buttonImplicitActivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("http://www.google.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);

                String title = getResources().getString(R.string.chooser_title);
                Intent intentChooser = Intent.createChooser(webIntent, title);

                // Verify the intent will resolve to at least one activity
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentChooser);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                textViewSomeText.setText(data.getStringExtra("some_text"));
            default:
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_loader, menu);
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
