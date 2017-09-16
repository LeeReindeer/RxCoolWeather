package xyz.leezoom.rxcoolweather.model.api;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author lee
 * @Time 9/15/17.
 */

public class NetWorkHelper {

    private Context mContext;
    private OkHttpClient client = new OkHttpClient();
    private static NetWorkHelper helperInstance = null;
    private Retrofit retrofit = null;
    private WeatherApi weatherApi = null;

    private NetWorkHelper(Context context){
        this.mContext = context;
        init();
    }

    public static NetWorkHelper getHelperInstance(Context context){
        if (helperInstance == null){
            helperInstance = new NetWorkHelper(context);
        }
        return helperInstance;
    }

    private void init(){
        if (weatherApi == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://free-api.heweather.com/v5/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    public  WeatherApi getWeatherApi(){
        weatherApi = retrofit.create(WeatherApi.class);
        return weatherApi;
    }
}
