
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DailyForecast {

    @SerializedName("astro")
    private Astro mAstro;
    @SerializedName("cond")
    private Cond mCond;
    @SerializedName("date")
    private String mDate;
    @SerializedName("hum")
    private String mHum;
    @SerializedName("pcpn")
    private String mPcpn;
    @SerializedName("pop")
    private String mPop;
    @SerializedName("pres")
    private String mPres;
    @SerializedName("tmp")
    private Tmp mTmp;
    @SerializedName("uv")
    private String mUv;
    @SerializedName("vis")
    private String mVis;
    @SerializedName("wind")
    private Wind mWind;

    public Astro getAstro() {
        return mAstro;
    }

    public void setAstro(Astro astro) {
        mAstro = astro;
    }

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

    public String getPcpn() {
        return mPcpn;
    }

    public void setPcpn(String pcpn) {
        mPcpn = pcpn;
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

    public Tmp getTmp() {
        return mTmp;
    }

    public void setTmp(Tmp tmp) {
        mTmp = tmp;
    }

    public String getUv() {
        return mUv;
    }

    public void setUv(String uv) {
        mUv = uv;
    }

    public String getVis() {
        return mVis;
    }

    public void setVis(String vis) {
        mVis = vis;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

}
