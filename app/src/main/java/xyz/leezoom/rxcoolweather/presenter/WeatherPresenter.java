package xyz.leezoom.rxcoolweather.presenter;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xyz.leezoom.rxcoolweather.model.api.DataManager;
import xyz.leezoom.rxcoolweather.model.entity.gson.HeWeather5;
import xyz.leezoom.rxcoolweather.view.MyView;
import xyz.leezoom.rxcoolweather.view.WeatherView;

/**
 * @Author lee
 * @Time 9/15/17.
 */

public class WeatherPresenter implements MyPresenter{

    private Context mContext;
    private DataManager manager;
    private CompositeDisposable compositeDisposable;
    private WeatherView mWeatherView;
    private HeWeather5 mWeather;

    public WeatherPresenter(Context context){
        this.mContext = context;
    }

    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
    }

    public void addDisposable(Disposable subscription){
        compositeDisposable.add(subscription);
    }

    @Override
    public void onStop() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    @Override
    public void attachView(MyView myView) {
        this.mWeatherView = (WeatherView) myView;
    }

    public void getWeather(String city, String key){
        manager.getWeather(city, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HeWeather5>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(HeWeather5 weather) {
                        mWeather = weather;
                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherView.onError("请求失败!");
                    }

                    @Override
                    public void onComplete() {
                        mWeatherView.onSuccess(mWeather);
                    }
                });
    }
}
