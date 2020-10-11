package com.smart.school.adapter.item;

/**
 * Created by art on 2017-06-21.
 */

public class IntroItem {

    private String strImg;
    private int nImg;
    private String strMsg;

    public IntroItem(String strImg, String strMsg) {
        this.strImg = strImg;
        this.strMsg = strMsg;
    }

    public IntroItem(int nImg, String strMsg) {
        this.nImg = nImg;
        this.strMsg = strMsg;
    }

    public String getStrImg() {
        return strImg;
    }

    public int getnImg() {
        return nImg;
    }

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrImg(String strImg) {
        this.strImg = strImg;
    }

    public void setnImg(int nImg) {
        this.nImg = nImg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }
}