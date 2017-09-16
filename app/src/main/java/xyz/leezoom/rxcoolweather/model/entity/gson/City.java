
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class City {

    @SerializedName("aqi")
    private String mAqi;
    @SerializedName("pm10")
    private String mPm10;
    @SerializedName("pm25")
    private String mPm25;
    @SerializedName("qlty")
    private String mQlty;

    public String getAqi() {
        return mAqi;
    }

    public void setAqi(String aqi) {
        mAqi = aqi;
    }

    public String getPm10() {
        return mPm10;
    }

    public void setPm10(String pm10) {
        mPm10 = pm10;
    }

    public String getPm25() {
        return mPm25;
    }

    public void setPm25(String pm25) {
        mPm25 = pm25;
    }

    public String getQlty() {
        return mQlty;
    }

    public void setQlty(String qlty) {
        mQlty = qlty;
    }

}
