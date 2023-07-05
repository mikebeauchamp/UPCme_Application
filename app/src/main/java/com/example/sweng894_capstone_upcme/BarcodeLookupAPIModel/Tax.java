package com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax
{
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("tax_ship")
    @Expose
    private String taxShip;

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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTaxShip() {
        return taxShip;
    }

    public void setTaxShip(String taxShip) {
        this.taxShip = taxShip;
    }
}
