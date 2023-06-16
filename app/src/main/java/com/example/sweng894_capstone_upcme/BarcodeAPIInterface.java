package com.example.sweng894_capstone_upcme;

import com.example.sweng894_capstone_upcme.Model.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarcodeAPIInterface
{
    @GET("v3/products")
    //Call<ProductList> doGetProductList(@Query(value = "barcode", encoded = true) String barcodeQueryString);

    Call<ProductList> doGetProductList(@Query("barcode") String barcode,
                                       @Query("formatted") String formatString,
                                               @Query("key") String apikey);
}
