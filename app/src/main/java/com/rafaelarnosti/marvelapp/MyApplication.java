package com.rafaelarnosti.marvelapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by RAFAELLUIZMAZZINIARN on 06/08/2017.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
