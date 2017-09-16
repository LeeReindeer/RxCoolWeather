package xyz.leezoom.rxcoolweather.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xyz.leezoom.rxcoolweather.R;
import xyz.leezoom.rxcoolweather.model.api.NetWorkHelper;
import xyz.leezoom.rxcoolweather.model.entity.gson.DailyForecast;
import xyz.leezoom.rxcoolweather.model.entity.gson.HeWeather5;
import xyz.leezoom.rxcoolweather.presenter.WeatherPresenter;
import xyz.leezoom.rxcoolweather.view.WeatherView;

public class MainActivity extends AppCompatActivity {

    private final static String KEY = "fdbad6cfbfca42948ba6336424232aa5";
    private String weatherId;
    private LocationManager locationManager;
    private String lon; //经度
    private String lat; //纬度
    private WeatherPresenter mWeatherPresenter = new WeatherPresenter(this);

    @BindView(R.id.nav_button)
    Button homeButton;
    @BindView(R.id.wt_refresh_view)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.wt_scroll_view)
    ScrollView weatherLayout;
    @BindView(R.id.title_city)
    TextView titleCity;
    @BindView(R.id.title_update_time)
    TextView updateTimeText;
    @BindView(R.id.now_degree_text)
    TextView nowDegreeText;
    @BindView(R.id.now_weather_info_text)
    TextView nowWeatherInfoText;
    @BindView(R.id.forecast_layout)
    LinearLayout forecastLayout;
    @BindView(R.id.aqi_text)
    TextView aqiText;
    @BindView(R.id.aqi_pm25_text)
    TextView pm25Text;
    @BindView(R.id.sg_comfort_text)
    TextView comfortText;
    @BindView(R.id.sg_sport_text)
    TextView sportText;
    @BindView(R.id.sg_dress_text)
    TextView dressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mWeatherPresenter.onCreate();
        mWeatherPresenter.attachView(mWeatherView);
        checkPermission();
        if (lon != null && lat != null) {
            mWeatherPresenter.getWeather(lon + "," + lat, KEY);
        } else if (weatherId != null){
            mWeatherPresenter.getWeather(weatherId, KEY);
        } else {
            Toast.makeText(MainActivity.this, "无法定位", Toast.LENGTH_SHORT).show();
            mWeatherPresenter.getWeather("CN101010100", KEY);
        }
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWeatherPresenter.getWeather(weatherId, KEY);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWeatherPresenter.onStop();
    }

    private WeatherView mWeatherView = new WeatherView() {
        @Override
        public void onSuccess(HeWeather5 weather5) {
            HeWeather5 weather = weather5.getHeWeather5().get(0);
            weatherId = weather.getBasic().getId();
            String cityName = weather.getBasic().getCity();
            String updateTime = weather.getBasic().getUpdate().getUpdateTime().split(" ")[1];
            String degree = weather.getNow().getTmp();
            String weatherInfo = weather.getNow().getCond().getTxt();
            titleCity.setText(cityName);
            updateTimeText.setText(updateTime);
            nowDegreeText.setText(degree);
            nowWeatherInfoText.setText(weatherInfo);
            forecastLayout.removeAllViews();
            for (DailyForecast forecast : weather.getDailyForecast()) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.forecast_item, forecastLayout, false);
                TextView dateText = (TextView) view.findViewById(R.id.date_text);
                TextView infoText = (TextView) view.findViewById(R.id.info_text);
                TextView maxText = (TextView) view.findViewById(R.id.max_text);
                TextView minText = (TextView) view.findViewById(R.id.min_text);
                dateText.setText(forecast.getDate());
                infoText.setText(forecast.getCond().getTxtD());
                maxText.setText(forecast.getTmp().getMax());
                minText.setText(forecast.getTmp().getMin());
                forecastLayout.addView(view);
            }
            if (weather.getAqi() != null) {
                aqiText.setText(weather.getAqi().getCity().getAqi());
                pm25Text.setText(weather.getAqi().getCity().getPm25());
            }
            String comfort = "舒适度: " + weather.getSuggestion().getComf().getTxt();
            String sport = "运动建议: " + weather.getSuggestion().getSport().getTxt();
            String dress = "穿衣指南: " + weather.getSuggestion().getDrsg().getTxt();
            comfortText.setText(comfort);
            sportText.setText(sport);
            dressText.setText(dress);
            weatherLayout.setVisibility(View.VISIBLE);
            refreshLayout.setRefreshing(false);
        }

        @Override
        public void onError(String status) {
            Toast.makeText(MainActivity.this, status, Toast.LENGTH_LONG).show();
        }
    };

    private void checkPermission() {

        try{
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }else {
                getLocation();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getLocation(){
        //Geocoder geocoder = new Geocoder(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            Toast.makeText(this,"请打开GPS或网络定位",Toast.LENGTH_LONG).show();
            return;
        }
        try {
            if (location == null) return;
            lon = String.valueOf(location.getLongitude());
            lat = String.valueOf(location.getLatitude());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLocation();
            }else {
                Toast.makeText(MainActivity.this, "没有定位权限", Toast.LENGTH_LONG).show();
            }
        }
    }
}
//WeatherApi weatherApi = NetWorkHelper.getWeatherApi();
//Observable<HeWeather5> observable= weatherApi.getWeather("CN101010100", "fdbad6cfbfca42948ba6336424232aa5");
        /*NetWorkHelper.getWeatherApi()
                .getWeather("CN101010100", "fdbad6cfbfca42948ba6336424232aa5")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HeWeather5>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HeWeather5 weather) {
                        textView.setText(weather.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                */

        /*Call<HeWeather5> call = weatherApi.getWeather("CN101010100", "fdbad6cfbfca42948ba6336424232aa5");
        call.enqueue(new Callback<HeWeather5>() {
            @Override
            public void onResponse(Call<HeWeather5> call, Response<HeWeather5> response) {
                textView.setText(response.body().getHeWeather5().get(0).getNow().getTmp());
            }

            @Override
            public void onFailure(Call<HeWeather5> call, Throwable t) {

            }
        });*/
