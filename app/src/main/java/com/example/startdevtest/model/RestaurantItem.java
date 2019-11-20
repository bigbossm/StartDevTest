package com.example.startdevtest.model;

public class RestaurantItem {
    private String mImageUrl;
    private String mrestaurentName;
    private int mMinOrder;

    public RestaurantItem(String imageUrl, String restaurentName, int min) {
        mImageUrl = imageUrl;
        mrestaurentName = restaurentName;
        mMinOrder = min;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getMrestaurentName() {
        return mrestaurentName;
    }

    public int getmMinOrder() {
        return mMinOrder;
    }
}