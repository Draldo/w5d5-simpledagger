package com.example.daggersimple;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by evin on 4/28/16.
 */
@Singleton
@Component(modules = {AppModule.class, SharedModule.class})
public interface SharedComponent {
    void inject(MainActivity activity);
}
