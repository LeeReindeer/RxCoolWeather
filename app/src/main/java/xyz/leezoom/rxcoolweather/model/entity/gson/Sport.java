
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Sport {

    @SerializedName("brf")
    private String mBrf;
    @SerializedName("txt")
    private String mTxt;

    public String getBrf() {
        return mBrf;
    }

    public void setBrf(String brf) {
        mBrf = brf;
    }

    public String getTxt() {
        return mTxt;
    }

    public void setTxt(String txt) {
        mTxt = txt;
    }

}
