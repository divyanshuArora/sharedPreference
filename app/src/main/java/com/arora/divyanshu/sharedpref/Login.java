package com.arora.divyanshu.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText number,pass;
    Button login,registerIntent;




    private PreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        number=findViewById(R.id.number);
        pass=findViewById(R.id.pass);

        login = findViewById(R.id.login);
        registerIntent=findViewById(R.id.registerIntent);
        registerIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent xyz = new Intent(getApplicationContext(),Register.class);
                startActivity(xyz);
            }
        });


        preferenceManager = new PreferenceManager(getApplicationContext());
        number.setText(preferenceManager.getKeyValueStringRegister("LOGINNUMBER"));


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }



    public void loginUser()
    {
        String num1,pass1;

        num1= number.getText().toString();
        pass1=pass.getText().toString();


        String matchNumber = preferenceManager.getKeyValueString("LOGINNUMBER");
        String matchPass = preferenceManager.getKeyValueString("PASSWORD");



        if (num1.isEmpty())
        {
            number.setError("Enter Number");
            return;
        }

        if (pass1.isEmpty())
        {
            pass.setError("Enter Password");
        }

        if (!num1.matches(matchNumber))
        {
            pass.setError("enter correct password");
            return;
        }

        if (!pass1.matches(matchPass))
        {
            pass.setError("enter correct password");
            return;
        }

        preferenceManager = new PreferenceManager(this);
        preferenceManager.setLoginSession(num1);

        preferenceManager.setKeyValueString("LOGINNUMBER",num1);


        Intent xyz = new Intent(getApplicationContext(),DashBoard.class);
        startActivity(xyz);
        finish();
    }
}
