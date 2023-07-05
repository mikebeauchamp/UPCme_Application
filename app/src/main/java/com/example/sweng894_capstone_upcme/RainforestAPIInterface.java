package com.example.sweng894_capstone_upcme;

import com.example.sweng894_capstone_upcme.RainforestAPIModel.RainforestAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RainforestAPIInterface
{
    @GET("request")
    Call <RainforestAPI> getRainforestProduct(@Query("api_key") String apikey,
                                              @Query("type") String type,
                                              @Query("amazon_domain") String amazonDomain,
                                              @Query("currency") String currency,
                                              @Query("skip_gtin_cache") String skip_gtin_cache,
                                              @Query("output") String output,
                                              @Query("gtin") String barcode
                                             );
}
