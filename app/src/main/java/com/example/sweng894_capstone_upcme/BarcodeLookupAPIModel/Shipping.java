package com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipping

{
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("price")
    @Expose
    private String price;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
