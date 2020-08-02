package com.example.android.androidassessment;

import androidx.cardview.widget.CardView;

public class CardViewPaired {
    private int mImageRes;
    private String mDeviceName, mDeviceStatus;

    public CardViewPaired(int imageRes,String deviceName,String deviceStatus){
        mImageRes = imageRes;
        mDeviceName = deviceName;
        mDeviceStatus = deviceStatus;
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
