package com.example.imageappproject;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.imageappproject.DataBase.SingleImageEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static void getDataForUi(){

        if(MainActivity.viewModel.getCount()==0){
            loadData();
        }
        setImageAllData();

    }
    public static void loadData(){

        DataLoadAsyncTask task = new DataLoadAsyncTask();
        task.execute();

    }

    public static void sortData() {
        MainActivity.mList = MainActivity.viewModel.getAllImageByAlbumId();
        updateUI();
    }

    public static void showSearchData(String s)
    {
        if(s.length()==0){
            setImageAllData();
        }
        else {
            filter(s);
        }
    }

    public static void filter(String charText) {
        List<SingleImageEntity> list = MainActivity.mList;
        MainActivity.mList = new ArrayList<>();

        charText = charText.toLowerCase(Locale.getDefault());
        if (charText.length() == 0) {
            setImageAllData();
        } else {

            for (SingleImageEntity wp : list) {
                if (wp.getmTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    MainActivity.mList.add(wp);
                }
            }
        }
        updateUI();
    }

    public static class DataLoadAsyncTask extends AsyncTask<Void,Void, List<SingleImageEntity>> {

        @Override
        protected List<SingleImageEntity> doInBackground(Void... voids) {
            return NetworkUtils.getDataFromUrl();
        }

        @Override
        protected void onPostExecute(List<SingleImageEntity> singleImages) {
            pushInDataBase(singleImages);
            super.onPostExecute(singleImages);
        }

    }
    private static void pushInDataBase(List<SingleImageEntity> list){

        for(int i=0;i<list.size();i++){
            SingleImageEntity image = list.get(i);
            MainActivity.viewModel.insertImage(image);
        }
    }
    private static void setImageAllData(){

        MainActivity.mList = MainActivity.viewModel.getAllImage();
        updateUI();

    }
    private static void updateUI() {
        MainActivity.mImageAdapter.setList(MainActivity.mList);
    }
}
