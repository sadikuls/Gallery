package com.example.bsandroidtest.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bsandroidtest.Activities.MainActivity;
import com.example.bsandroidtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowImage extends Fragment implements MainActivity.OnDataPassedListener {

    ImageView imageShow;
    public ShowImage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_show_image, container, false);

        imageShow= (ImageView) view.findViewById(R.id.imageShow);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDataPassed(String url) {

        Log.e("PassDataToFragment",url);
        Glide.with(getActivity()).load(url).into(imageShow);
        //Glide.with().load("").into(imageShow);

    }
}
