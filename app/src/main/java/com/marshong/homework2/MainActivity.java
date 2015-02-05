package com.marshong.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private Button mNextPageButton;     //submit button
    private EditText mNameEditText;     //first and last name text box
    private EditText mEmailEditText;    //email text box
    private CheckBox mCheckBoxEmailSub; //checkbox for email subscription

    //extra information for saving in the bundles
    public static final String extraName = "extra_name";
    public static final String extraEmail = "extra_email";
    public static final String extraBoxChecked = "extra_box_checked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup objects
        mNameEditText = (EditText) findViewById(R.id.editTextName);
        mEmailEditText = (EditText) findViewById(R.id.editTextEmail);
        mCheckBoxEmailSub = (CheckBox) findViewById(R.id.checkBoxEmailSub);

        //setup event handler for submit button
        mNextPageButton = (Button) findViewById(R.id.buttonSubmit);
        mNextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //before we do anything let's validate the name and email
                String name = mNameEditText.getText().toString();
                String email = mEmailEditText.getText().toString();

                //validate name
                boolean validName = isValidName(name);
                if (!validName) {
                    mNameEditText.setError("Invalid Name");
                }

                //validate email
                boolean validEmail = isValidEmail(email);
                if (!validEmail) {
                    mEmailEditText.setError("Invalid Email");
                }

                //only submit the information if everything is valid
                if (validEmail && validName) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                    //save off user data in case of state changes
                    intent.putExtra(extraName, name);
                    intent.putExtra(extraEmail, email);
                    intent.putExtra(extraBoxChecked, mCheckBoxEmailSub.isChecked());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidName(String name) {
        //these days anything goes for names. including numbers and special characters.
        // its hard to validate this.

        //only thing to validate is that something was at least entered.
        if (0 != name.length()) {
            return true;
        } else return false;

    }

    private boolean isValidEmail(String email) {

        //all email addresses contain an '@' and a '.'
        if (email.contains("@") && email.contains(".")) {
            return true;
        } else return false;
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
