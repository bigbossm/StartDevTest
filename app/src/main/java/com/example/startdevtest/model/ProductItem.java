package com.example.startdevtest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductItem  implements Parcelable {
    private String name;
    private int price;

    public ProductItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
