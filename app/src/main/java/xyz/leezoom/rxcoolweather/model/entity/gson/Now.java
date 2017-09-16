
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Now {

    @SerializedName("cond")
    private Cond mCond;
    @SerializedName("fl")
    private String mFl;
    @SerializedName("hum")
    private String mHum;
    @SerializedName("pcpn")
    private String mPcpn;
    @SerializedName("pres")
    private String mPres;
    @SerializedName("tmp")
    private String mTmp;
    @SerializedName("vis")
    private String mVis;
    @SerializedName("wind")
    private Wind mWind;

    public Cond getCond() {
        return mCond;
    }

    public void setCond(Cond cond) {
        mCond = cond;
    }

    public String getFl() {
        return mFl;
    }

    public void setFl(String fl) {
        mFl = fl;
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
