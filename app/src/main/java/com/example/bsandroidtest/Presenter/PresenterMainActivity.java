package com.example.bsandroidtest.Presenter;

import com.example.bsandroidtest.Interfaces.AlbumResponse;
import com.example.bsandroidtest.Interfaces.OnAlbumApiListenter;
import com.example.bsandroidtest.Network.NetworkModel.ApiDataManager.ApiAlbum;
import com.example.bsandroidtest.Network.NetworkModel.ImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sadikul on 12/9/2017.
 */

public class PresenterMainActivity {
    OnAlbumApiListenter onAlbumApiListener;

    public PresenterMainActivity(OnAlbumApiListenter onAlbumApiListener){
        this.onAlbumApiListener=onAlbumApiListener;
    }

    public void getAlbum(String authKey){
        onAlbumApiListener.startLoading();
        new ApiAlbum(onAlbumApiListener.getAppContext(), authKey, new AlbumResponse() {
            @Override
            public void onSuccess(ArrayList<ImageItem> album) {

                onAlbumApiListener.stopLoading();
                onAlbumApiListener.onSuccess(album);
            }

            @Override
            public void onError(String errorMsg) {

                onAlbumApiListener.stopLoading();
                onAlbumApiListener.onError(errorMsg);
            }
        });
    }
}
