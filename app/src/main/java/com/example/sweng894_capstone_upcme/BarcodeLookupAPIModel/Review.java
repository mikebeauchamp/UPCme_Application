package com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
    public class Review {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("review")
        @Expose
        private String review;
        @SerializedName("date")
        @Expose
        private String date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

}