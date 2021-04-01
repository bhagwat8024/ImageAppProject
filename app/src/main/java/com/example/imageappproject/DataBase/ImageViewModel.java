package com.example.imageappproject.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class ImageViewModel extends AndroidViewModel {

    public static ImageDatabase DB ;

    public ImageViewModel(@NonNull Application application) {
        super(application);
        DB = ImageDatabase.getDataBase(application.getApplicationContext());
    }

    public void insertImage(SingleImageEntity image){
        DB.imageDAO().insertImage(image);
    }

    public List<SingleImageEntity> getAllImage(){
        return DB.imageDAO().getAllImages();
    }

    public List<SingleImageEntity> getAllImageByAlbumId(){
        return DB.imageDAO().getAllImagesByAlbumId();
    }

    public int getCount(){
        return DB.imageDAO().getCount();
    }

    public void deleteAllData(){
        DB.imageDAO().deleteAllData();
    }
}
