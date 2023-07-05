package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestMetadata {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("processed_at")
    @Expose
    private String processedAt;
    @SerializedName("total_time_taken")
    @Expose
    private float totalTimeTaken;
    @SerializedName("amazon_url")
    @Expose
    private String amazonUrl;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public float getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void setTotalTimeTaken(float totalTimeTaken) {
        this.totalTimeTaken = totalTimeTaken;
    }

    public String getAmazonUrl() {
        return amazonUrl;
    }

    public void setAmazonUrl(String amazonUrl) {
        this.amazonUrl = amazonUrl;
    }

}