package com.example.imageappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.imageappproject.DataBase.ImageAdapter;
import com.example.imageappproject.DataBase.ImageViewModel;
import com.example.imageappproject.DataBase.SingleImageEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ImageAdapter mImageAdapter;

    List<SingleImageEntity> mList = new ArrayList<>();
    ImageViewModel viewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadData();
    }

    public void init(){

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mImageAdapter = new ImageAdapter(this);
        mRecyclerView.setAdapter(mImageAdapter);
        viewModel = ViewModelProviders.of(this).get(ImageViewModel.class);

    }
    private void loadData(){

        if(viewModel.getCount()==0){
            DataLoadAsyncTask  task = new DataLoadAsyncTask();
            task.execute();
        }
        else{
            setImageLiveData();
        }

    }
    public class DataLoadAsyncTask extends AsyncTask<Void,Void,List<SingleImageEntity>>{

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

    private void pushInDataBase(List<SingleImageEntity> list){

        for(int i=0;i<list.size();i++){
            SingleImageEntity image = list.get(i);
            viewModel.insertImage(image);
        }
        setImageLiveData();
    }
    private void setImageLiveData(){

        viewModel.getAllImage().observe(this, new Observer<List<SingleImageEntity>>() {
            @Override
            public void onChanged(List<SingleImageEntity> singleImageEntities) {

                mList = singleImageEntities;
                Log.e("hello",singleImageEntities.size()+"");
                updateUI();

            }
        });

    }
    private void updateUI() {
        mImageAdapter.setList(mList);
    }
}