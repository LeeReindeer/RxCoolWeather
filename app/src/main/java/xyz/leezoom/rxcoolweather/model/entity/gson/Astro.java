
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Astro {

    @SerializedName("mr")
    private String mMr;
    @SerializedName("ms")
    private String mMs;
    @SerializedName("sr")
    private String mSr;
    @SerializedName("ss")
    private String mSs;

    public String getMr() {
        return mMr;
    }

    public void setMr(String mr) {
        mMr = mr;
    }

    public String getMs() {
        return mMs;
    }

    public void setMs(String ms) {
        mMs = ms;
    }

    public String getSr() {
        return mSr;
    }

    public void setSr(String sr) {
        mSr = sr;
    }

    public String getSs() {
        return mSs;
    }

    public void setSs(String ss) {
        mSs = ss;
    }

}
