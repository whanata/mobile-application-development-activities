package com.id11993577.exercise2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    private TextView showName;
    private TextView showEmail;
    private TextView showPhoneNumber;
    private TextView showPhoneType;

    private Bundle data;
    private String name;
    private String email;
    private int phoneNumber;
    private String phoneType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        showName = (TextView) findViewById(R.id.showName);
        showEmail = (TextView) findViewById(R.id.showEmail);
        showPhoneNumber = (TextView) findViewById(R.id.showPhoneNumber);
        showPhoneType = (TextView) findViewById(R.id.showPhoneType);

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


    public void onSubmit(View v) {
        Log.d("status123", "Submit Button Clicked");
    }

}
