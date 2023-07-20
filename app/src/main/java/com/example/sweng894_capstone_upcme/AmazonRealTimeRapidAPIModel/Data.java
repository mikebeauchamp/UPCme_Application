package com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data
{

    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("total_reviews")
    @Expose
    private int totalReviews;
    @SerializedName("total_ratings")
    @Expose
    private int totalRatings;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}

