package com.example.daggersimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    private static final String SHARED_PREF_KEY = "SHARED_KEY";
    private static final String SHARED_PREF_VALUE = "SHARED_VALUE";
    private static final String SHARED_PREF_DEFAULT = "SHARED_DEFAULT";

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    OkHttpClient mClient;

    @Inject
    Request mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ((App) getApplication()).getSharedComponent().inject(this);

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SHARED_PREF_KEY, SHARED_PREF_VALUE);
        editor.apply();

        try {
            Response response = mClient.newCall(mRequest).execute();
            String str = response.body().string();
            Log.d(TAG, "onCreate OkHttp: " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void doMagic(View view) {
        Log.d(TAG, "doMagic: " + mSharedPreferences.getString(SHARED_PREF_KEY, SHARED_PREF_DEFAULT));
    }
}
