package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BuyboxWinner {

    @SerializedName("unqualified_buy_box")
    @Expose
    private boolean unqualifiedBuyBox;
    @SerializedName("is_prime")
    @Expose
    private boolean isPrime;
    @SerializedName("is_amazon_fresh")
    @Expose
    private boolean isAmazonFresh;
    @SerializedName("condition")
    @Expose
    private Condition condition;

    public boolean isUnqualifiedBuyBox() {
        return unqualifiedBuyBox;
    }

    public void setUnqualifiedBuyBox(boolean unqualifiedBuyBox) {
        this.unqualifiedBuyBox = unqualifiedBuyBox;
    }

    public boolean isIsPrime() {
        return isPrime;
    }

    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }

    public boolean isIsAmazonFresh() {
        return isAmazonFresh;
    }

    public void setIsAmazonFresh(boolean isAmazonFresh) {
        this.isAmazonFresh = isAmazonFresh;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}