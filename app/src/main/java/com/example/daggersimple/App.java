package com.example.daggersimple;

import android.app.Application;

/**
 * Created by evin on 4/28/16.
 */
public class App extends Application {

    private SharedComponent mSharedComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mSharedComponent = DaggerSharedComponent.builder().appModule(new AppModule(this)).sharedModule(new SharedModule("Hello")).build();

    }

    public SharedComponent getSharedComponent() {
        return mSharedComponent;
    }
}
