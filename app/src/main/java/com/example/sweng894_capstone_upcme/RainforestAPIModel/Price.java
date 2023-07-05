package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("value")
    @Expose
    private float value;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("raw")
    @Expose
    private String raw;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

}
