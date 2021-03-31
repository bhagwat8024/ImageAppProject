package com.example.imageappproject.DataBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageappproject.R;
import com.example.imageappproject.SingleImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    List<SingleImageEntity> list;
    public Context mContext;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(List<SingleImageEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_image_item,parent,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        SingleImageEntity singleImage = list.get(position);
        holder.TitleView.setText(singleImage.getmTitle());
        holder.AlbumIdView.setText(String.valueOf(singleImage.getmAlbumId()));
        Picasso.get().load(singleImage.getmThumnailUrl()).into(holder.ThumbnailImageView);
        return;
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
