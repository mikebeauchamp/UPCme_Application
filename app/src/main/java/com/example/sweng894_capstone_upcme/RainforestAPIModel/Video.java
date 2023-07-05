package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("duration_seconds")
    @Expose
    private int durationSeconds;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("is_hero_video")
    @Expose
    private boolean isHeroVideo;
    @SerializedName("variant")
    @Expose
    private String variant;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("group_type")
    @Expose
    private String groupType;
    @SerializedName("title")
    @Expose
    private String title;

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isIsHeroVideo() {
        return isHeroVideo;
    }

    public void setIsHeroVideo(boolean isHeroVideo) {
        this.isHeroVideo = isHeroVideo;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
