package com.example.bsandroidtest.Network.NetworkModel;

import com.example.bsandroidtest.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BS83 on 12/8/2017.
 */

public class RetrofitClient {
    public static Retrofit getRetrofitClient(){
        return new Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static ApiInterface getApiInterface() {
        return  getRetrofitClient().create(ApiInterface.class);
    }
}
