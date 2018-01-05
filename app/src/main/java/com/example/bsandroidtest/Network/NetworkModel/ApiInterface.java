package com.example.bsandroidtest.Network.NetworkModel;

import android.media.Image;

import com.example.bsandroidtest.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by BS83 on 12/8/2017.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST(Constants.apiAlbum)
    Call<ArrayList<ImageItem>> getAlbumList(@Field("authKey") String authKey);
}
