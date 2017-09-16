
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Basic {

    @SerializedName("city")
    private String mCity;
    @SerializedName("cnty")
    private String mCnty;
    @SerializedName("id")
    private String mId;
    @SerializedName("lat")
    private String mLat;
    @SerializedName("lon")
    private String mLon;
    @SerializedName("update")
    private Update mUpdate;

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getCnty() {
        return mCnty;
    }

    public void setCnty(String cnty) {
        mCnty = cnty;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLon() {
        return mLon;
    }

    public void setLon(String lon) {
        mLon = lon;
    }

    public Update getUpdate() {
        return mUpdate;
    }

    public void setUpdate(Update update) {
        mUpdate = update;
    }

}
