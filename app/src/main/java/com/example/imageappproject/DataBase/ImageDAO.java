package com.example.imageappproject.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDAO{

    @Insert
    void insertImage(SingleImageEntity image);

    @Query("SELECT * FROM `image-table`")
    List<SingleImageEntity> getAllImages();

    @Query("SELECT * FROM `image-table` ORDER BY mAlbumId")
    List<SingleImageEntity> getAllImagesByAlbumId();

    @Query("SELECT COUNT(mImageId) FROM `image-table` ")
    int getCount();

    @Query("DELETE FROM `image-table`")
    void deleteAllData();
}
