package xyz.leezoom.rxcoolweather.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
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
import xyz.leezoom.rxcoolweather.model.entity.gson.HeWeather5;
import xyz.leezoom.rxcoolweather.presenter.WeatherPresenter;
import xyz.leezoom.rxcoolweather.view.WeatherView;

public class MainActivity extends AppCompatActivity {

    private WeatherPresenter mWeatherPresenter = new WeatherPresenter(this);
    private WeatherView mWeatherView = new WeatherView() {
        @Override
        public void onSuccess(HeWeather5 weather) {
            HeWeather5 wea = weather.getHeWeather5().get(0);
            textView.setText(wea.getBasic().getCity());
        }

        @Override
        public void onError(String status) {
            Toast.makeText(MainActivity.this, status, Toast.LENGTH_LONG).show();
        }
    };

    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.request_button)
    Button button;

    @OnClick(R.id.request_button) void request(){
        mWeatherPresenter.getWeather("CN101010100", "fdbad6cfbfca42948ba6336424232aa5");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mWeatherPresenter.onCreate();
        mWeatherPresenter.attachView(mWeatherView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWeatherPresenter.onStop();
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
