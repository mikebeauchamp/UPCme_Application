package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopReview {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("date")
    @Expose
    private Date date;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("vine_program")
    @Expose
    private boolean vineProgram;
    @SerializedName("verified_purchase")
    @Expose
    private boolean verifiedPurchase;
    @SerializedName("review_country")
    @Expose
    private String reviewCountry;
    @SerializedName("is_global_review")
    @Expose
    private boolean isGlobalReview;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean isVineProgram() {
        return vineProgram;
    }

    public void setVineProgram(boolean vineProgram) {
        this.vineProgram = vineProgram;
    }

    public boolean isVerifiedPurchase() {
        return verifiedPurchase;
    }

    public void setVerifiedPurchase(boolean verifiedPurchase) {
        this.verifiedPurchase = verifiedPurchase;
    }

    public String getReviewCountry() {
        return reviewCountry;
    }

    public void setReviewCountry(String reviewCountry) {
        this.reviewCountry = reviewCountry;
    }

    public boolean isIsGlobalReview() {
        return isGlobalReview;
    }

    public void setIsGlobalReview(boolean isGlobalReview) {
        this.isGlobalReview = isGlobalReview;
    }

}
