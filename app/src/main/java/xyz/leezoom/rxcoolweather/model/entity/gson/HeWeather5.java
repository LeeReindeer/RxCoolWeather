
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HeWeather5 {

    @SerializedName("status")
    private String mStatus;
    @SerializedName("aqi")
    private Aqi mAqi;
    @SerializedName("basic")
    private Basic mBasic;
    @SerializedName("daily_forecast")
    private List<DailyForecast> mDailyForecast;
    @SerializedName("HeWeather5")
    private List<HeWeather5> mHeWeather5;
    @SerializedName("hourly_forecast")
    private List<HourlyForecast> mHourlyForecast;
    @SerializedName("now")
    private Now mNow;
    @SerializedName("suggestion")
    private Suggestion mSuggestion;

    @Override
    public String toString() {
        HeWeather5 weather = getHeWeather5().get(0);
        return "Status: " + weather.getStatus() + "\n" + weather.getBasic().getCity() +
                "\n" + weather.getNow().getCond().getTxt();
    }

    public Aqi getAqi() {
        return mAqi;
    }

    public void setAqi(Aqi aqi) {
        mAqi = aqi;
    }

    public Basic getBasic() {
        return mBasic;
    }

    public void setBasic(Basic basic) {
        mBasic = basic;
    }

    public List<DailyForecast> getDailyForecast() {
        return mDailyForecast;
    }

    public void setDailyForecast(List<DailyForecast> dailyForecast) {
        mDailyForecast = dailyForecast;
    }

    public List<HeWeather5> getHeWeather5() {
        return mHeWeather5;
    }

    public void setHeWeather5(List<HeWeather5> HeWeather5) {
        mHeWeather5 = HeWeather5;
    }

    public List<HourlyForecast> getHourlyForecast() {
        return mHourlyForecast;
    }

    public void setHourlyForecast(List<HourlyForecast> hourlyForecast) {
        mHourlyForecast = hourlyForecast;
    }

    public Now getNow() {
        return mNow;
    }

    public void setNow(Now now) {
        mNow = now;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Suggestion getSuggestion() {
        return mSuggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        mSuggestion = suggestion;
    }

}
