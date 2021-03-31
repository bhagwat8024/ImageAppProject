package com.example.imageappproject;

public class SingleImage {
    String mThumnailUrl;
    String mTitle;
    int mAlbumId;
    int mImageId;
    String mImageUrl;

    public SingleImage() {
    }

    public SingleImage(String mThumnailUrl, String mTitle, int mAlbumId, int mImageId, String mImageUrl) {
        this.mThumnailUrl = mThumnailUrl;
        this.mTitle = mTitle;
        this.mAlbumId = mAlbumId;
        this.mImageId = mImageId;
        this.mImageUrl = mImageUrl;
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

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
