package com.arora.divyanshu.sharedpref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

   PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {


                    preferenceManager = new PreferenceManager(Splash.this);

                   // boolean b=preferenceManager.getRegisterSession();

                    if (!preferenceManager.getRegisterSession())
                    {
                        Intent intent = new Intent(Splash.this, Register.class);
                        startActivity(intent);
                    }
                     if (!preferenceManager.getLoginSession())
                    {
                        Intent intent = new Intent(Splash.this, Login.class);
                        startActivity(intent);
                    }
                    else

                    {
                        Intent intent = new Intent(Splash.this, DashBoard.class);
                        startActivity(intent);
                    }




//                        if (!preferenceManager.getLoginSession()) {
//                        Intent intent = new Intent(Splash.this, Login.class);
//                        startActivity(intent);
//                    } else {
//                        Intent intent = new Intent(Splash.this, DashBoard.class);
//                        startActivity(intent);
//                    }



                    finish();

                }
            }
        };
        timerThread.start();
    }

}