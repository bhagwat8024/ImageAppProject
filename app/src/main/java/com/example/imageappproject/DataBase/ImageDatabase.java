package com.example.imageappproject.DataBase;

import android.content.Context;
import android.media.Image;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

@androidx.room.Database(entities = SingleImageEntity.class,version = 1,exportSchema = false)
public abstract class ImageDatabase extends RoomDatabase  {

    public static final String DATABASE_NAME = "book-database";
    public static final Object LOCK = new Object();
    public static ImageDatabase sInstance;

    public static ImageDatabase getDataBase(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context,ImageDatabase.class,DATABASE_NAME).allowMainThreadQueries().build();
            }
        }
        return sInstance;
    }

    public abstract ImageDAO imageDAO();

}
