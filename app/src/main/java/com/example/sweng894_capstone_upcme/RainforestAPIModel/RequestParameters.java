package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestParameters {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("amazon_domain")
    @Expose
    private String amazonDomain;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("gtin")
    @Expose
    private String gtin;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmazonDomain() {
        return amazonDomain;
    }

    public void setAmazonDomain(String amazonDomain) {
        this.amazonDomain = amazonDomain;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

}
