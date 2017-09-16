
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Tmp {

    @SerializedName("max")
    private String mMax;
    @SerializedName("min")
    private String mMin;

    public String getMax() {
        return mMax;
    }

    public void setMax(String max) {
        mMax = max;
    }

    public String getMin() {
        return mMin;
    }

    public void setMin(String min) {
        mMin = min;
    }

}
