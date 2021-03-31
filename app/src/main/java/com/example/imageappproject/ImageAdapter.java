package com.example.imageappproject;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    ArrayList<SingleImage> list;
    public Context mContext;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(ArrayList<SingleImage> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_image_item,parent,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        SingleImage singleImage = list.get(position);
        holder.TitleView.setText(singleImage.getmTitle());
        holder.AlbumIdView.setText(String.valueOf(singleImage.getmAlbumId()));
    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }
        else{
            return list.size();
        }
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        ImageView ThumbnailImageView;
        TextView TitleView;
        TextView AlbumIdView;

        public ImageHolder(@NonNull View itemView) {

            super(itemView);
            ThumbnailImageView = itemView.findViewById(R.id.thumbnail_image_view);
            TitleView = itemView.findViewById(R.id.title_view);
            AlbumIdView = itemView.findViewById(R.id.image_id_view);

        }

    }
}
