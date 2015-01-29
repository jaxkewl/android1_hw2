package com.marshong.homework2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private Button mNextPageButton;
    private EditText mNameEditText;
    private EditText mEmailEditText;
    private CheckBox mCheckBoxEmailSub;

    //extra information
    public static final String extraName = "extra_name";
    public static final String extraEmail = "extra_email";
    public static final String extraBoxChecked ="extra_box_checked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.editTextName);
        mEmailEditText = (EditText) findViewById(R.id.editTextEmail);
        mCheckBoxEmailSub = (CheckBox) findViewById(R.id.checkBoxEmailSub);

        mNextPageButton = (Button) findViewById(R.id.buttonSubmit);
        mNextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                intent.putExtra(extraName, mNameEditText.getText().toString());
                intent.putExtra(extraEmail, mEmailEditText.getText().toString());
                intent.putExtra(extraBoxChecked, mCheckBoxEmailSub.isChecked());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
