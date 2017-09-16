package xyz.leezoom.rxcoolweather.model.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xyz.leezoom.rxcoolweather.model.entity.City;
import xyz.leezoom.rxcoolweather.model.entity.gson.HeWeather5;

/**
 * @Author lee
 * @Time 9/15/17.
 */

public interface WeatherApi {

    /**
     *
     * @param city
     * @param key
     * @return weather entity
     */
    @GET("weather")
    Observable<HeWeather5> getWeather(@Query("city") String city,
                                      @Query("key") String key);

    /***
     *
     * @param city
     * @param key
     * @return City's weather id
     */
    @GET("search")
    Observable<City> getCityWeatherId(@Query("city") String city,
                                      @Query("key") String key);
}
