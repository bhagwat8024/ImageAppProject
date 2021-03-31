package com.example.imageappproject.DataBase;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Image-Table")
public class SingleImageEntity {

    @PrimaryKey
    int mImageId;

    String mThumnailUrl;
    String mTitle;
    int mAlbumId;
    String mImageUrl;

    public SingleImageEntity() {
    }

    public SingleImageEntity(String mThumnailUrl, String mTitle, int mAlbumId, String mImageUrl) {
        this.mThumnailUrl = mThumnailUrl;
        this.mTitle = mTitle;
        this.mAlbumId = mAlbumId;
        this.mImageUrl = mImageUrl;
    }

    public SingleImageEntity(int mImageId, String mThumnailUrl, String mTitle, int mAlbumId, String mImageUrl) {
        this.mImageId = mImageId;
        this.mThumnailUrl = mThumnailUrl;
        this.mTitle = mTitle;
        this.mAlbumId = mAlbumId;
        this.mImageUrl = mImageUrl;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getmThumnailUrl() {
        return mThumnailUrl;
    }

    public void setmThumnailUrl(String mThumnailUrl) {
        this.mThumnailUrl = mThumnailUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmAlbumId() {
        return mAlbumId;
    }

    public void setmAlbumId(int mAlbumId) {
        this.mAlbumId = mAlbumId;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
