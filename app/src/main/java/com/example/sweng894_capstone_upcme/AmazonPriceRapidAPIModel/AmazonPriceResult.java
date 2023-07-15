package com.example.sweng894_capstone_upcme.AmazonPriceRapidAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AmazonPriceResult {

    @SerializedName("ASIN")
    @Expose
    private String asin;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("listPrice")
    @Expose
    private String listPrice;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("detailPageURL")
    @Expose
    private String detailPageURL;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("totalReviews")
    @Expose
    private String totalReviews;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("isPrimeEligible")
    @Expose
    private String isPrimeEligible;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetailPageURL() {
        return detailPageURL;
    }

    public void setDetailPageURL(String detailPageURL) {
        this.detailPageURL = detailPageURL;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(String totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIsPrimeEligible() {
        return isPrimeEligible;
    }

    public void setIsPrimeEligible(String isPrimeEligible) {
        this.isPrimeEligible = isPrimeEligible;
    }

}