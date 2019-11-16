package com.example.www.smartgate.Preferences;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;

    int PRIVATE_MODE=0;

    private static final String PREF_NAME= "SMARTGATE-WELCOME";

    private static final String IS_FIRST_TIME_LAUNCH="IsFirstTimeLaunch";

    public PrefManager(Context mContext){
        this.mContext = mContext;
        pref = mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setFirstTimeLaunch(boolean IsFirstTime){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,IsFirstTime);
    }
    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH,true);
    }
}
