package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingBreakdown {

    @SerializedName("five_star")
    @Expose
    private FiveStar fiveStar;
    @SerializedName("four_star")
    @Expose
    private FourStar fourStar;
    @SerializedName("three_star")
    @Expose
    private ThreeStar threeStar;
    @SerializedName("two_star")
    @Expose
    private TwoStar twoStar;
    @SerializedName("one_star")
    @Expose
    private OneStar oneStar;

    public FiveStar getFiveStar() {
        return fiveStar;
    }

    public void setFiveStar(FiveStar fiveStar) {
        this.fiveStar = fiveStar;
    }

    public FourStar getFourStar() {
        return fourStar;
    }

    public void setFourStar(FourStar fourStar) {
        this.fourStar = fourStar;
    }

    public ThreeStar getThreeStar() {
        return threeStar;
    }

    public void setThreeStar(ThreeStar threeStar) {
        this.threeStar = threeStar;
    }

    public TwoStar getTwoStar() {
        return twoStar;
    }

    public void setTwoStar(TwoStar twoStar) {
        this.twoStar = twoStar;
    }

    public OneStar getOneStar() {
        return oneStar;
    }

    public void setOneStar(OneStar oneStar) {
        this.oneStar = oneStar;
    }

}
