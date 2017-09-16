package xyz.leezoom.rxcoolweather.app;

import android.app.Application;

import org.litepal.LitePalApplication;

/**
 * @Author lee
 * @Time 9/15/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
