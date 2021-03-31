package com.example.imageappproject;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.imageappproject.DataBase.SingleImageEntity;

import java.util.List;

public class Utils {
    public static void getDataForUi(){

        if(MainActivity.viewModel.getCount()==0){
            loadData();
        }
        setImageLiveData();
    }
    public static void loadData(){

        DataLoadAsyncTask task = new DataLoadAsyncTask();
        task.execute();

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
    private static void setImageLiveData(){

        MainActivity.viewModel.getAllImage().observe((LifecycleOwner) MainActivity.mContext, new Observer<List<SingleImageEntity>>() {
            @Override
            public void onChanged(List<SingleImageEntity> singleImageEntities) {

                MainActivity.mList = singleImageEntities;
                Log.e("hello",singleImageEntities.size()+"");
                updateUI();

            }
        });

    }
    private static void updateUI() {
        MainActivity.mImageAdapter.setList(MainActivity.mList);
    }
}
