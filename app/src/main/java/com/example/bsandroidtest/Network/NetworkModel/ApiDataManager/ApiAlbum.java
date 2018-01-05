package com.example.bsandroidtest.Network.NetworkModel.ApiDataManager;

import android.content.Context;
import android.media.Image;
import android.util.Log;

import com.example.bsandroidtest.Interfaces.AlbumResponse;
import com.example.bsandroidtest.Network.NetworkModel.ApiInterface;
import com.example.bsandroidtest.Network.NetworkModel.ImageItem;
import com.example.bsandroidtest.Network.NetworkModel.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BS83 on 12/8/2017.
 */

public class ApiAlbum {
    AlbumResponse albumResponse;
    public ApiAlbum(Context context, final String authKey, final AlbumResponse albumResponse){
        this.albumResponse=albumResponse;

        ApiInterface apiService = RetrofitClient.getApiInterface();

        Call<ArrayList<ImageItem>> call = apiService.getAlbumList(authKey);
        call.enqueue(new Callback<ArrayList<ImageItem>>() {
            @Override
            public void onResponse(Call<ArrayList<ImageItem>> call, Response<ArrayList<ImageItem>> response) {
                int statusCode = response.code();
                Log.e("apiAlbum", statusCode+"Succesfully parsed json");
                albumResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ImageItem>> call, Throwable t) {
                // Log error here since request failed
                albumResponse.onError(t.toString());
            }
        });
    }
}
