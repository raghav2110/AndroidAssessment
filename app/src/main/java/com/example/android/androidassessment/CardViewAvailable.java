package com.example.android.androidassessment;

import androidx.cardview.widget.CardView;

public class CardViewAvailable {
    private int mImageRes;
    private String mDeviceName, mDeviceStatus;

    public CardViewAvailable(int imageRes,String deviceName,String deviceStatus){
        mImageRes = imageRes;
        mDeviceName = deviceName;
        mDeviceStatus = deviceStatus;
    }
    public void changeMDeviceStatus(String text){
        mDeviceStatus = text;
    }
    public int getImageRes(){
        return mImageRes;
    }
    public String getDeviceName(){
        return mDeviceName;
    }
    public String getDeviceStatus(){
        return mDeviceStatus;
    }
}
