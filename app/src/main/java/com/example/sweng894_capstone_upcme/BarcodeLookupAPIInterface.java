package com.example.sweng894_capstone_upcme;

import com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarcodeLookupAPIInterface
{
    @GET("v3/products")
    Call<ProductList> doGetProductList(@Query("barcode") String barcode,
                                       @Query("formatted") String formatString,
                                               @Query("key") String apikey);
}
