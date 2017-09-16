package xyz.leezoom.rxcoolweather.view;

import xyz.leezoom.rxcoolweather.model.entity.gson.HeWeather5;

/**
 * @Author lee
 * @Time 9/15/17.
 */

public interface WeatherView extends MyView {
    void onSuccess(HeWeather5 weather);
    void onError(String status);
}
