package xyz.leezoom.rxcoolweather.presenter;

import android.content.Intent;

import xyz.leezoom.rxcoolweather.view.MyView;

/**
 * @Author lee
 * @Time 9/16/17.
 */

public interface MyPresenter {
    void onCreate();
    void onStop();
    void attachView(MyView myView);

}
