package com.arora.divyanshu.sharedpref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText name,email,number,pass,confPass;
    Button register;

    private PreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);
        pass=findViewById(R.id.pass);
        confPass=findViewById(R.id.ConfPass);

        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Register();
            }
        });
    }



    public void Register()
    {
        String name1,email1,number1,pass1,confPass1;



        name1=name.getText().toString();
        email1=email.getText().toString();
        number1=number.getText().toString();
        pass1=pass.getText().toString();
        confPass1=confPass.getText().toString();


        if (!pass1.matches(confPass1))
        {
            confPass.setError("Password not Matched");
            return;
        }



        preferenceManager = new PreferenceManager(this);
        preferenceManager.setRegisterSession(email1);

        preferenceManager.setKeyValueStringRegister("EMAIL",email1);
        preferenceManager.setKeyValueStringRegister("NAME",name1);
        preferenceManager.setKeyValueStringRegister("LOGINNUMBER",number1);
        preferenceManager.setKeyValueStringRegister("PASSWORD",pass1);


        Intent register = new Intent(getApplicationContext(),Login.class);
        startActivity(register);















    }









}
