package com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Product {

    @SerializedName("barcode_number")
    @Expose
    private String barcodeNumber;
    @SerializedName("barcode_formats")
    @Expose
    private String barcodeFormats;
    @SerializedName("mpn")
    @Expose
    private String mpn;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("contributors")
    @Expose
    private List<Contributor> contributors;
    @SerializedName("age_group")
    @Expose
    private String ageGroup;
    @SerializedName("ingredients")
    @Expose
    private String ingredients;
    @SerializedName("nutrition_facts")
    @Expose
    private String nutritionFacts;
    @SerializedName("energy_efficiency_class")
    @Expose
    private String energyEfficiencyClass;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("material")
    @Expose
    private String material;
    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("multipack")
    @Expose
    private String multipack;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("features")
    @Expose
    private List<Object> features;
    @SerializedName("images")
    @Expose
    private List<String> images;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("stores")
    @Expose
    private List<OnlineStore> stores;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews;

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public String getBarcodeFormats() {
        return barcodeFormats;
    }

    public void setBarcodeFormats(String barcodeFormats) {
        this.barcodeFormats = barcodeFormats;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(String nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public String getEnergyEfficiencyClass() {
        return energyEfficiencyClass;
    }

    public void setEnergyEfficiencyClass(String energyEfficiencyClass) {
        this.energyEfficiencyClass = energyEfficiencyClass;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMultipack() {
        return multipack;
    }

    public void setMultipack(String multipack) {
        this.multipack = multipack;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getFeatures() {
        return features;
    }

    public void setFeatures(List<Object> features) {
        this.features = features;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<OnlineStore> getStores() {
        return stores;
    }

    public void setStores(List<OnlineStore> stores) {
        this.stores = stores;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
