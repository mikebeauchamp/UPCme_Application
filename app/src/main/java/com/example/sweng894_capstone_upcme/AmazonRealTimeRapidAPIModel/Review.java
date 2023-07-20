package com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("review_id")
    @Expose
    private String reviewId;
    @SerializedName("review_title")
    @Expose
    private Object reviewTitle;
    @SerializedName("review_comment")
    @Expose
    private String reviewComment;
    @SerializedName("review_star_rating")
    @Expose
    private String reviewStarRating;
    @SerializedName("review_author")
    @Expose
    private String reviewAuthor;
    @SerializedName("review_author_avatar")
    @Expose
    private String reviewAuthorAvatar;
    @SerializedName("review_images")
    @Expose
    private List<String> reviewImages;
    @SerializedName("review_video")
    @Expose
    private Object reviewVideo;
    @SerializedName("review_date")
    @Expose
    private String reviewDate;
    @SerializedName("is_verified_purchase")
    @Expose
    private boolean isVerifiedPurchase;
    @SerializedName("helpful_vote_statement")
    @Expose
    private String helpfulVoteStatement;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Object getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(Object reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public String getReviewStarRating() {
        return reviewStarRating;
    }

    public void setReviewStarRating(String reviewStarRating) {
        this.reviewStarRating = reviewStarRating;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public String getReviewAuthorAvatar() {
        return reviewAuthorAvatar;
    }

    public void setReviewAuthorAvatar(String reviewAuthorAvatar) {
        this.reviewAuthorAvatar = reviewAuthorAvatar;
    }

    public List<String> getReviewImages() {
        return reviewImages;
    }

    public void setReviewImages(List<String> reviewImages) {
        this.reviewImages = reviewImages;
    }

    public Object getReviewVideo() {
        return reviewVideo;
    }

    public void setReviewVideo(Object reviewVideo) {
        this.reviewVideo = reviewVideo;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public boolean isIsVerifiedPurchase() {
        return isVerifiedPurchase;
    }

    public void setIsVerifiedPurchase(boolean isVerifiedPurchase) {
        this.isVerifiedPurchase = isVerifiedPurchase;
    }

    public String getHelpfulVoteStatement() {
        return helpfulVoteStatement;
    }

    public void setHelpfulVoteStatement(String helpfulVoteStatement) {
        this.helpfulVoteStatement = helpfulVoteStatement;
    }

}