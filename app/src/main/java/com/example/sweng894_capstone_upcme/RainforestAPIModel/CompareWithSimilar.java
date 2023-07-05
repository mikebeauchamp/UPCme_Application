package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompareWithSimilar {

    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("ratings_total")
    @Expose
    private int ratingsTotal;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("price")
    @Expose
    private Price price;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatingsTotal() {
        return ratingsTotal;
    }

    public void setRatingsTotal(int ratingsTotal) {
        this.ratingsTotal = ratingsTotal;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

}
