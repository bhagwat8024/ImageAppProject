package com.example.imageappproject.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.imageappproject.SingleImage;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ImageDAO{

    @Insert
    void insertImage(SingleImageEntity image);

    @Query("SELECT * FROM `image-table`")
    LiveData<List<SingleImageEntity>> getAllImages();

    @Query("SELECT * FROM `image-table` ORDER BY mAlbumId")
    LiveData<List<SingleImageEntity>> getAllImagesByAlbumId();

    @Query("SELECT COUNT(mImageId) FROM `image-table` ")
    int getCount();
}
