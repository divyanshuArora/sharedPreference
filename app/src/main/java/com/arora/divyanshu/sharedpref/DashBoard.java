package com.arora.divyanshu.sharedpref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.security.Key;

public class DashBoard extends AppCompatActivity {

    PreferenceManager preferenceManager;
    TextView txt,emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        txt = findViewById(R.id.text);
        emails=findViewById(R.id.email);

        preferenceManager = new PreferenceManager(getApplicationContext());


        String num = preferenceManager.getKeyValueString("LOGINNUMBER");

        String email = preferenceManager.getKeyValueStringRegister("EMAIL");



        txt.setText(num);
        emails.setText(email);




    }
}
