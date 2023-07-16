package com.example.sweng894_capstone_upcme;

import com.example.sweng894_capstone_upcme.AmazonPriceRapidAPIModel.Asin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AmazonPriceUPCToASINInterface
{

    @GET("upcToAsin")
    Call <Asin> getAsin(@Header("X-RapidAPI-Host") String host,
                         @Header("X-RapidAPI-Key") String key,
                         @Query("upc") String upc,
                         @Query("marketplace") String marketplace
    );
}
