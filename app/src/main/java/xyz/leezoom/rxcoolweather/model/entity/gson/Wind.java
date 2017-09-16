
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Wind {

    @SerializedName("deg")
    private String mDeg;
    @SerializedName("dir")
    private String mDir;
    @SerializedName("sc")
    private String mSc;
    @SerializedName("spd")
    private String mSpd;

    public String getDeg() {
        return mDeg;
    }

    public void setDeg(String deg) {
        mDeg = deg;
    }

    public String getDir() {
        return mDir;
    }

    public void setDir(String dir) {
        mDir = dir;
    }

    public String getSc() {
        return mSc;
    }

    public void setSc(String sc) {
        mSc = sc;
    }

    public String getSpd() {
        return mSpd;
    }

    public void setSpd(String spd) {
        mSpd = spd;
    }

}
