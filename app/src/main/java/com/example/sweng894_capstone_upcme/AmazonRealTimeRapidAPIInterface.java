package com.example.sweng894_capstone_upcme;

import com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel.RealTimeRapidAPIResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AmazonRealTimeRapidAPIInterface
{
    @GET("product-reviews")
    Call <RealTimeRapidAPIResult> getProductReviews(@Header("X-RapidAPI-Host") String host,
                                                           @Header("X-RapidAPI-Key") String key,
                                                           @Query("asin") String asin,
                                                           @Query("country") String country,
                                                           @Query("sort_by") String sortBy,
                                                           @Query("star_rating") String starRating,
                                                           @Query("verified_purchases_only") String verifiedPurchasesOnly,
                                                           @Query("images_or_videos_only") String imagesOrVideosOnly,
                                                           @Query("page") String page,
                                                           @Query("page_size") String pageSize
                                                 );
}
