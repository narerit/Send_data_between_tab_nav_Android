package com.narerit.tabnavigation.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Narerit on 7/22/2019.
 */
public class Promotions implements Parcelable {
    private String promotion_image;
    private String brand_image;
    private String offer;
    private String point;

    public Promotions(String promotion_image, String brand_image, String offer, String point) {
        this.promotion_image = promotion_image;
        this.brand_image = brand_image;
        this.offer = offer;
        this.point = point;
    }
    public Promotions(){}

    protected Promotions(Parcel in) {
        promotion_image = in.readString();
        brand_image = in.readString();
        offer = in.readString();
        point = in.readString();
    }

    public static final Creator<Promotions> CREATOR = new Creator<Promotions>() {
        @Override
        public Promotions createFromParcel(Parcel in) {
            return new Promotions(in);
        }

        @Override
        public Promotions[] newArray(int size) {
            return new Promotions[size];
        }
    };

    public String getPromotion_image() {
        return promotion_image;
    }

    public void setPromotion_image(String promotion_image) {
        this.promotion_image = promotion_image;
    }

    public String getBrand_image() {
        return brand_image;
    }

    public void setBrand_image(String brand_image) {
        this.brand_image = brand_image;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(promotion_image);
        parcel.writeString(brand_image);
        parcel.writeString(offer);
        parcel.writeString(point);
    }
}
