package com.example.bsandroidtest.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.bsandroidtest.Adapter.AdapterAlbum;
import com.example.bsandroidtest.Interfaces.OnAlbumApiListenter;
import com.example.bsandroidtest.Network.NetworkModel.ImageItem;
import com.example.bsandroidtest.Presenter.PresenterMainActivity;
import com.example.bsandroidtest.R;
import com.example.bsandroidtest.Utils.Constants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements OnAlbumApiListenter,AdapterAlbum.AlbumAdapterCommunicator{
    PresenterMainActivity presenterMainActivity;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    AdapterAlbum albumAdapter;
    private String TAG="GalleryFragment";
    SendDataToActivity sendDataToActivity;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sendDataToActivity= (SendDataToActivity) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_gallery, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView= (RecyclerView) view.findViewById(R.id.albumRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Fetching album list");
        presenterMainActivity=new PresenterMainActivity(this);
        presenterMainActivity.getAlbum(Constants.authKey);

    }


    AdapterAlbum.AlbumAdapterCommunicator communication=new AdapterAlbum.AlbumAdapterCommunicator() {
        @Override
        public void onAlbumItemClicked(String url) {
            sendDataToActivity.imageLink(url);
        }
    };
    //album api response


    @Override
    public void onSuccess(ArrayList<ImageItem> album) {

        Log.e(TAG,"successfully parsed data");
        albumAdapter=new AdapterAlbum(album,getActivity(),communication);
        recyclerView.setAdapter(albumAdapter);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {

        Log.e(TAG,"Error parsed data");
    }

    @Override
    public void startLoading() {

        progressDialog.show();
    }

    @Override
    public void stopLoading() {

        progressDialog.dismiss();
    }

    @Override
    public Context getAppContext() {
        return null;
    }


    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onAlbumItemClicked(String url) {

    }


    public interface SendDataToActivity{
        void imageLink(String imageLink);
    }
}
