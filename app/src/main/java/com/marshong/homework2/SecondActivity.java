package com.marshong.homework2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity {

    //setup text views to display submitted information from bundle
    private TextView mNameTextView;
    private TextView mEmailTextView;
    private TextView mCheckedSub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //get the bundle information from the intent
        Bundle extraBundle = getIntent().getExtras();

        //setup objects
        mNameTextView = (TextView) findViewById(R.id.textViewName);
        mEmailTextView = (TextView) findViewById(R.id.textViewEmail);
        mCheckedSub = (TextView) findViewById(R.id.textViewSignedUp);

        //set the text for display
        mNameTextView.setText(extraBundle.getString(MainActivity.extraName));
        mEmailTextView.setText(extraBundle.getString(MainActivity.extraEmail));

        //setup display for check box state
        boolean isChecked = extraBundle.getBoolean(MainActivity.extraBoxChecked);

        if (isChecked) {
            mCheckedSub.setText("Yes");
        } else {
            mCheckedSub.setText("No");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
