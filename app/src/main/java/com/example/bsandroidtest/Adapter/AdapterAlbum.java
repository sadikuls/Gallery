package com.example.bsandroidtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bsandroidtest.Network.NetworkModel.ImageItem;
import com.example.bsandroidtest.R;

import java.util.ArrayList;

/**
 * Created by Sadikul on 12/9/2017.
 */

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.MyViewHolder> {

    private ArrayList<ImageItem> albumList;
    AlbumAdapterCommunicator albumAdapterCommunicator;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        ImageView image;
        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.imageTitle);
        }
    }


    public AdapterAlbum(ArrayList<ImageItem> albumList, Context context, AlbumAdapterCommunicator communicator) {
        this.albumList = albumList;
        this.context=context;
        albumAdapterCommunicator= communicator;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ImageItem imageItem = albumList.get(position);
        holder.title.setText(imageItem.getText());

        Glide.with(context)
                .load(imageItem.getPhoto())
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                albumAdapterCommunicator.onAlbumItemClicked(imageItem.getPhoto());
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public interface AlbumAdapterCommunicator{
        public void onAlbumItemClicked(String url);
    }
}