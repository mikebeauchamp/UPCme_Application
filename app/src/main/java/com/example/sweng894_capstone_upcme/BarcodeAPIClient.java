package com.example.sweng894_capstone_upcme;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BarcodeAPIClient
{
    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.barcodelookup.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        System.out.println("RETROFIT:" + retrofit.toString());

        return retrofit;
    }
}
