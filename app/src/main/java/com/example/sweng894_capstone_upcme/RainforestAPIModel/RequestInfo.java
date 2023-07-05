package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestInfo {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("credits_used")
    @Expose
    private int creditsUsed;
    @SerializedName("credits_remaining")
    @Expose
    private int creditsRemaining;
    @SerializedName("credits_used_this_request")
    @Expose
    private int creditsUsedThisRequest;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCreditsUsed() {
        return creditsUsed;
    }

    public void setCreditsUsed(int creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public int getCreditsRemaining() {
        return creditsRemaining;
    }

    public void setCreditsRemaining(int creditsRemaining) {
        this.creditsRemaining = creditsRemaining;
    }

    public int getCreditsUsedThisRequest() {
        return creditsUsedThisRequest;
    }

    public void setCreditsUsedThisRequest(int creditsUsedThisRequest) {
        this.creditsUsedThisRequest = creditsUsedThisRequest;
    }

}
