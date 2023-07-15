package com.example.sweng894_capstone_upcme;

import com.example.sweng894_capstone_upcme.AmazonPriceRapidAPIModel.AmazonPriceResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AmazonPriceSearchInterface
{

    @GET("search")
    Call <AmazonPriceResult> getAmazonPriceResult(@Header("X-RapidAPI-Host") String host,
                                                  @Header("X-RapidAPI-Key") String key,
                                                  @Query("keywords") String keywords,
                                                  @Query("marketplace") String marketplace

                                             );
}
