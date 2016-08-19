package com.example.daggersimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    private static final String SHARED_PREF_KEY = "SHARED_KEY";
    private static final String SHARED_PREF_VALUE = "SHARED_VALUE";
    private static final String SHARED_PREF_DEFAULT = "SHARED_DEFAULT";

    @Inject
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getSharedComponent().inject(this);


        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SHARED_PREF_KEY, SHARED_PREF_VALUE);
        editor.apply();
    }


    public void doMagic(View view) {
        Log.d(TAG, "doMagic: " + mSharedPreferences.getString(SHARED_PREF_KEY, SHARED_PREF_DEFAULT));
    }
}
