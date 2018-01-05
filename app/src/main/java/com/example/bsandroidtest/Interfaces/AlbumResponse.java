package com.example.bsandroidtest.Interfaces;

import android.media.Image;

import com.example.bsandroidtest.Network.NetworkModel.ImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS83 on 12/8/2017.
 */

public interface AlbumResponse {
    void onSuccess(ArrayList<ImageItem> album);
    void onError(String errorMsg);
}
