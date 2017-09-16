
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Suggestion {

    @SerializedName("air")
    private Air mAir;
    @SerializedName("comf")
    private Comf mComf;
    @SerializedName("cw")
    private Cw mCw;
    @SerializedName("drsg")
    private Drsg mDrsg;
    @SerializedName("flu")
    private Flu mFlu;
    @SerializedName("sport")
    private Sport mSport;
    @SerializedName("trav")
    private Trav mTrav;
    @SerializedName("uv")
    private Uv mUv;

    public Air getAir() {
        return mAir;
    }

    public void setAir(Air air) {
        mAir = air;
    }

    public Comf getComf() {
        return mComf;
    }

    public void setComf(Comf comf) {
        mComf = comf;
    }

    public Cw getCw() {
        return mCw;
    }

    public void setCw(Cw cw) {
        mCw = cw;
    }

    public Drsg getDrsg() {
        return mDrsg;
    }

    public void setDrsg(Drsg drsg) {
        mDrsg = drsg;
    }

    public Flu getFlu() {
        return mFlu;
    }

    public void setFlu(Flu flu) {
        mFlu = flu;
    }

    public Sport getSport() {
        return mSport;
    }

    public void setSport(Sport sport) {
        mSport = sport;
    }

    public Trav getTrav() {
        return mTrav;
    }

    public void setTrav(Trav trav) {
        mTrav = trav;
    }

    public Uv getUv() {
        return mUv;
    }

    public void setUv(Uv uv) {
        mUv = uv;
    }

}
