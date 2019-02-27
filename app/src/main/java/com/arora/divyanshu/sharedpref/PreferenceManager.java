package com.arora.divyanshu.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by in on 22/3/17.
 */

public class PreferenceManager {

    public static final String myPref ="myPref";

    public static PreferenceManager preferenceManager;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static PreferenceManager getInstance() {
        return preferenceManager;
    }

    public PreferenceManager(Context context) {
        preferenceManager = this;
        mSharedPreferences = context.getSharedPreferences(myPref, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void clearPreferences() {
        mEditor.clear();
        mEditor.commit();
    }



    public boolean getLoginSession() {
        boolean login = mSharedPreferences.getBoolean("NUMBER", false);
        return login;
    }

    public void setLoginSession(String number)
    {
        mEditor.putBoolean("NUMBER",true);
        mEditor.commit();
    }




    public void setRegisterSession(String email)
    {
        mEditor.putBoolean("REG",true);
        mEditor.commit();
    }

    public boolean getRegisterSession()
    {
        boolean registerVal = mSharedPreferences.getBoolean("REG", false);
        return registerVal;
    }






    public void setKeyValueString(String key, String value) {
        mEditor.putString(key, value).commit();
    }


    public String getKeyValueString(String key) {
        String getValue = mSharedPreferences.getString(key, "LOGINNUMBER");
        return getValue;
    }



    public void setKeyValueStringRegister(String key, String value) {
        mEditor.putString(key, value).commit();
    }


    public String getKeyValueStringRegister(String key) {
        String getValue = mSharedPreferences.getString(key, "num1");
        return getValue;
    }

}


