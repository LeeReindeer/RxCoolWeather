
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Update {

    @SerializedName("loc")
    private String updateTime;
    @SerializedName("utc")
    private String mUtc;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String loc) {
        updateTime = loc;
    }

    public String getUtc() {
        return mUtc;
    }

    public void setUtc(String utc) {
        mUtc = utc;
    }

}
