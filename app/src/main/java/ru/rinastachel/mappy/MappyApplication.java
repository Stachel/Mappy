package ru.rinastachel.mappy;

import android.app.Application;

public class MappyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        StethoUtils.init(this);
    }
}
