package xyz.leezoom.rxcoolweather.model.api;

import android.content.Context;

import io.reactivex.Observable;
import xyz.leezoom.rxcoolweather.model.entity.gson.HeWeather5;

/**
 * @Author lee
 * @Time 9/16/17.
 */

public class DataManager {
    private WeatherApi weatherApi;

    public DataManager(Context context){
        this.weatherApi = NetWorkHelper.getHelperInstance(context).getWeatherApi();
    }

    public Observable<HeWeather5> getWeather(String city, String key){
        return weatherApi.getWeather(city, key);
    }
}
