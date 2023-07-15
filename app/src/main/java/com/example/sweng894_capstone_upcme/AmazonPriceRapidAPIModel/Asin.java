package com.example.sweng894_capstone_upcme.AmazonPriceRapidAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asin {

    @SerializedName("asin")
    @Expose
    private String asin;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

}
