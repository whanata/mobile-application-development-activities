/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.id11993577.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/*
* Input contact details in a form for ActivityTwo
*/
public class ActivityOne extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String PHONE_TYPE = "phoneType";
    public static final int SEND_DATA = 1;

    private EditText fillName;
    private EditText fillEmail;
    private EditText fillPhoneNumber;
    private Spinner phoneOptions;

    private String name;
    private String email;
    private int phoneNumber;
    private String phoneType;

    /** Creates interface for this class, initialize elements needed in this class, creates spinner */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ActivityLifeCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fillName = (EditText) findViewById(R.id.fillName);
        fillEmail = (EditText) findViewById(R.id.fillEmail);
        fillPhoneNumber = (EditText) findViewById(R.id.fillPhoneNumber);
        phoneOptions = (Spinner) findViewById(R.id.phoneOptions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phoneOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneOptions.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("ActivityLifeCycle", "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("ActivityLifeCycle", "onResume");
    }
    @Override
    public void onRestart() {
        super.onRestart();
        Log.d("ActivityLifeCycle", "onRestart");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("ActivityLifeCycle", "onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("ActivityLifeCycle", "onStop");
    }
    public void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifeCycle", "onDestroy");
    }

    /** Sends contact information to Activity Two when Submit Button is pressed. */
    public void onSubmit(View v) {
        Snackbar submitMessage = Snackbar
                .make(v, R.string.clickSubmit, Snackbar.LENGTH_LONG);
        submitMessage.show();

        name = fillName.getText().toString();
        email = fillEmail.getText().toString();
        phoneNumber = Integer.parseInt(fillPhoneNumber.getText().toString());
        phoneType = phoneOptions.getSelectedItem().toString();

        Intent sendActivityOneToTwo = new Intent(this, ActivityTwo.class);

        sendActivityOneToTwo.putExtra(NAME, name);
        sendActivityOneToTwo.putExtra(EMAIL, email);
        sendActivityOneToTwo.putExtra(PHONE_NUMBER, phoneNumber);
        sendActivityOneToTwo.putExtra(PHONE_TYPE, phoneType);
        Log.d("phoneNumber", Integer.toString(phoneNumber));

        startActivityForResult(sendActivityOneToTwo, SEND_DATA);
    }

    /** Receive Activity Result from ActivityTwo */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ActivityOne.SEND_DATA :
                if (resultCode == Activity.RESULT_OK) {
                    String isAgreed = data.getExtras().getString(ActivityTwo.AGREED);
                    Toast.makeText(this, isAgreed, Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    /** Clears the contact form when Clear All button is clicked. */
    public void onClear(View v) {
        fillName.setText("");
        fillEmail.setText("");
        fillPhoneNumber.setText("");
        phoneOptions.setSelection(0);
    }

    /** Exit the Application when Exit button is clicked. */
    public void onExit(View v) {
        System.exit(0);
    }
}
