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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/*
* Show contact data from the contact details in ActivityOne
*/
public class ActivityTwo extends AppCompatActivity {

    public static final String AGREED = "boolAgree";

    private TextView showName;
    private TextView showEmail;
    private TextView showPhoneNumber;
    private TextView showPhoneType;
    private CheckBox checkAgreed;

    private Bundle data;
    private String name;
    private String email;
    private int phoneNumber;
    private String phoneType;
    private boolean isAgree;

    /** Create instance of the Activity */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showName = (TextView) findViewById(R.id.showName);
        showEmail = (TextView) findViewById(R.id.showEmail);
        showPhoneNumber = (TextView) findViewById(R.id.showPhoneNumber);
        showPhoneType = (TextView) findViewById(R.id.showPhoneType);
        checkAgreed = (CheckBox) findViewById(R.id.checkedAgree);

        data = getIntent().getExtras();
        name = data.getString(ActivityOne.NAME);
        email = data.getString(ActivityOne.EMAIL);
        phoneNumber = data.getInt(ActivityOne.PHONE_NUMBER);
        phoneType = data.getString(ActivityOne.PHONE_TYPE);

        showName.setText(name);
        showEmail.setText(email);
        showPhoneNumber.setText(Integer.toString(phoneNumber));
        showPhoneType.setText(phoneType);

    }

    /** Send result if they agree or not to ActivityOne when they click on the Submit Button. */
    public void onSubmit(View v) {
        isAgree = checkAgreed.isChecked();
        String agreedStr = isAgree ? getString(R.string.agreed) : getString(R.string.notAgreed);

        Intent agreedResult = new Intent();
        agreedResult.putExtra(AGREED, agreedStr);

        setResult(Activity.RESULT_OK, agreedResult);

        finish();
    }

}
