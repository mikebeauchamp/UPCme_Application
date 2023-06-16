package com.example.sweng894_capstone_upcme.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OnlineStore
{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("currency_symbol")
    @Expose
    private String currencySymbol;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("tax")
    @Expose
    private List<Tax> tax;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("item_group_id")
    @Expose
    private String itemGroupId;
    @SerializedName("availability")
    @Expose
    private String availability;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("shipping")
    @Expose
    private List<Shipping> shipping;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public List<Tax> getTax() {
        return tax;
    }

    public void setTax(List<Tax> tax) {
        this.tax = tax;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getItemGroupId() {
        return itemGroupId;
    }

    public void setItemGroupId(String itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<Shipping> getShipping() {
        return shipping;
    }

    public void setShipping(List<Shipping> shipping) {
        this.shipping = shipping;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
