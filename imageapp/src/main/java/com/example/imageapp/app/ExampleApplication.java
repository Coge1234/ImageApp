package com.example.imageapp.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/3/18.
 */

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
