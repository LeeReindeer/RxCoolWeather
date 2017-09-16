
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Aqi {

    @SerializedName("city")
    private City mCity;

    public City getCity() {
        return mCity;
    }

    public void setCity(City city) {
        mCity = city;
    }

}
