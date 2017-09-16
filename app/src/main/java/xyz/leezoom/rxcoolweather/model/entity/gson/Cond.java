
package xyz.leezoom.rxcoolweather.model.entity.gson;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Cond {

    @SerializedName("code")
    private String mCode;
    @SerializedName("code_d")
    private String mCodeD;
    @SerializedName("code_n")
    private String mCodeN;
    @SerializedName("txt")
    private String mTxt;
    @SerializedName("txt_d")
    private String mTxtD;
    @SerializedName("txt_n")
    private String mTxtN;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getCodeD() {
        return mCodeD;
    }

    public void setCodeD(String codeD) {
        mCodeD = codeD;
    }

    public String getCodeN() {
        return mCodeN;
    }

    public void setCodeN(String codeN) {
        mCodeN = codeN;
    }

    public String getTxt() {
        return mTxt;
    }

    public void setTxt(String txt) {
        mTxt = txt;
    }

    public String getTxtD() {
        return mTxtD;
    }

    public void setTxtD(String txtD) {
        mTxtD = txtD;
    }

    public String getTxtN() {
        return mTxtN;
    }

    public void setTxtN(String txtN) {
        mTxtN = txtN;
    }

}
