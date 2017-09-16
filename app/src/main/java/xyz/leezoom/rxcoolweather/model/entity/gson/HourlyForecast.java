
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HourlyForecast {

    @SerializedName("cond")
    private Cond mCond;
    @SerializedName("date")
    private String mDate;
    @SerializedName("hum")
    private String mHum;
    @SerializedName("pop")
    private String mPop;
    @SerializedName("pres")
    private String mPres;
    @SerializedName("tmp")
    private String mTmp;
    @SerializedName("wind")
    private Wind mWind;

    public Cond getCond() {
        return mCond;
    }

    public void setCond(Cond cond) {
        mCond = cond;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getHum() {
        return mHum;
    }

    public void setHum(String hum) {
        mHum = hum;
    }

    public String getPop() {
        return mPop;
    }

    public void setPop(String pop) {
        mPop = pop;
    }

    public String getPres() {
        return mPres;
    }

    public void setPres(String pres) {
        mPres = pres;
    }

    public String getTmp() {
        return mTmp;
    }

    public void setTmp(String tmp) {
        mTmp = tmp;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

}
