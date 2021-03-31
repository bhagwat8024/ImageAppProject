package com.example.imageappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ImageAdapter mImageAdapter;
    ArrayList<SingleImage> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mImageAdapter = new ImageAdapter(this);
        mRecyclerView.setAdapter(mImageAdapter);

        loadData();

    }
    private void loadData(){
        DataLoadAsyncTask  task = new DataLoadAsyncTask();
        task.execute();
    }
    public class DataLoadAsyncTask extends AsyncTask<Void,Void,ArrayList<SingleImage>>{

        @Override
        protected ArrayList<SingleImage> doInBackground(Void... voids) {
            return NetworkUtils.getDataFromUrl();
        }

        @Override
        protected void onPostExecute(ArrayList<SingleImage> singleImages) {
            mList = singleImages;
            updateUI();
            super.onPostExecute(singleImages);
        }

        private void updateUI() {
            mImageAdapter.setList(mList);
        }
    }
}