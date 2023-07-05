package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RainforestProduct {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("search_alias")
    @Expose
    private SearchAlias searchAlias;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("keywords_list")
    @Expose
    private List<String> keywordsList;
    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("sell_on_amazon")
    @Expose
    private boolean sellOnAmazon;
    @SerializedName("categories")
    @Expose
    private List<Category> categories;
    @SerializedName("categories_flat")
    @Expose
    private String categoriesFlat;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("sub_title")
    @Expose
    private SubTitle subTitle;
    @SerializedName("marketplace_id")
    @Expose
    private String marketplaceId;
    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("rating_breakdown")
    @Expose
    private RatingBreakdown ratingBreakdown;
    @SerializedName("ratings_total")
    @Expose
    private int ratingsTotal;
    @SerializedName("main_image")
    @Expose
    private MainImage mainImage;
    @SerializedName("images")
    @Expose
    private List<Image> images;
    @SerializedName("images_count")
    @Expose
    private int imagesCount;
    @SerializedName("images_flat")
    @Expose
    private String imagesFlat;
    @SerializedName("videos")
    @Expose
    private List<Video> videos;
    @SerializedName("videos_count")
    @Expose
    private int videosCount;
    @SerializedName("videos_flat")
    @Expose
    private String videosFlat;
    @SerializedName("videos_additional")
    @Expose
    private List<VideosAdditional> videosAdditional;
    @SerializedName("is_bundle")
    @Expose
    private boolean isBundle;
    @SerializedName("feature_bullets")
    @Expose
    private List<String> featureBullets;
    @SerializedName("feature_bullets_count")
    @Expose
    private int featureBulletsCount;
    @SerializedName("feature_bullets_flat")
    @Expose
    private String featureBulletsFlat;
    @SerializedName("important_information")
    @Expose
    private ImportantInformation importantInformation;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes;
    @SerializedName("top_reviews")
    @Expose
    private List<TopReview> topReviews;
    @SerializedName("buybox_winner")
    @Expose
    private BuyboxWinner buyboxWinner;
    @SerializedName("specifications")
    @Expose
    private List<Specification> specifications;
    @SerializedName("specifications_flat")
    @Expose
    private String specificationsFlat;
    @SerializedName("bestsellers_rank")
    @Expose
    private List<BestsellersRank> bestsellersRank;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("first_available")
    @Expose
    private FirstAvailable firstAvailable;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;
    @SerializedName("model_number")
    @Expose
    private String modelNumber;
    @SerializedName("bestsellers_rank_flat")
    @Expose
    private String bestsellersRankFlat;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SearchAlias getSearchAlias() {
        return searchAlias;
    }

    public void setSearchAlias(SearchAlias searchAlias) {
        this.searchAlias = searchAlias;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywordsList() {
        return keywordsList;
    }

    public void setKeywordsList(List<String> keywordsList) {
        this.keywordsList = keywordsList;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isSellOnAmazon() {
        return sellOnAmazon;
    }

    public void setSellOnAmazon(boolean sellOnAmazon) {
        this.sellOnAmazon = sellOnAmazon;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCategoriesFlat() {
        return categoriesFlat;
    }

    public void setCategoriesFlat(String categoriesFlat) {
        this.categoriesFlat = categoriesFlat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubTitle getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(SubTitle subTitle) {
        this.subTitle = subTitle;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public RatingBreakdown getRatingBreakdown() {
        return ratingBreakdown;
    }

    public void setRatingBreakdown(RatingBreakdown ratingBreakdown) {
        this.ratingBreakdown = ratingBreakdown;
    }

    public int getRatingsTotal() {
        return ratingsTotal;
    }

    public void setRatingsTotal(int ratingsTotal) {
        this.ratingsTotal = ratingsTotal;
    }

    public MainImage getMainImage() {
        return mainImage;
    }

    public void setMainImage(MainImage mainImage) {
        this.mainImage = mainImage;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(int imagesCount) {
        this.imagesCount = imagesCount;
    }

    public String getImagesFlat() {
        return imagesFlat;
    }

    public void setImagesFlat(String imagesFlat) {
        this.imagesFlat = imagesFlat;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int getVideosCount() {
        return videosCount;
    }

    public void setVideosCount(int videosCount) {
        this.videosCount = videosCount;
    }

    public String getVideosFlat() {
        return videosFlat;
    }

    public void setVideosFlat(String videosFlat) {
        this.videosFlat = videosFlat;
    }

    public List<VideosAdditional> getVideosAdditional() {
        return videosAdditional;
    }

    public void setVideosAdditional(List<VideosAdditional> videosAdditional) {
        this.videosAdditional = videosAdditional;
    }

    public boolean isIsBundle() {
        return isBundle;
    }

    public void setIsBundle(boolean isBundle) {
        this.isBundle = isBundle;
    }

    public List<String> getFeatureBullets() {
        return featureBullets;
    }

    public void setFeatureBullets(List<String> featureBullets) {
        this.featureBullets = featureBullets;
    }

    public int getFeatureBulletsCount() {
        return featureBulletsCount;
    }

    public void setFeatureBulletsCount(int featureBulletsCount) {
        this.featureBulletsCount = featureBulletsCount;
    }

    public String getFeatureBulletsFlat() {
        return featureBulletsFlat;
    }

    public void setFeatureBulletsFlat(String featureBulletsFlat) {
        this.featureBulletsFlat = featureBulletsFlat;
    }

    public ImportantInformation getImportantInformation() {
        return importantInformation;
    }

    public void setImportantInformation(ImportantInformation importantInformation) {
        this.importantInformation = importantInformation;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<TopReview> getTopReviews() {
        return topReviews;
    }

    public void setTopReviews(List<TopReview> topReviews) {
        this.topReviews = topReviews;
    }

    public BuyboxWinner getBuyboxWinner() {
        return buyboxWinner;
    }

    public void setBuyboxWinner(BuyboxWinner buyboxWinner) {
        this.buyboxWinner = buyboxWinner;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public String getSpecificationsFlat() {
        return specificationsFlat;
    }

    public void setSpecificationsFlat(String specificationsFlat) {
        this.specificationsFlat = specificationsFlat;
    }

    public List<BestsellersRank> getBestsellersRank() {
        return bestsellersRank;
    }

    public void setBestsellersRank(List<BestsellersRank> bestsellersRank) {
        this.bestsellersRank = bestsellersRank;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public FirstAvailable getFirstAvailable() {
        return firstAvailable;
    }

    public void setFirstAvailable(FirstAvailable firstAvailable) {
        this.firstAvailable = firstAvailable;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBestsellersRankFlat() {
        return bestsellersRankFlat;
    }

    public void setBestsellersRankFlat(String bestsellersRankFlat) {
        this.bestsellersRankFlat = bestsellersRankFlat;
    }

}