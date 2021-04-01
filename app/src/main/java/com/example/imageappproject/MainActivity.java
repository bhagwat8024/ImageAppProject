package com.example.imageappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imageappproject.DataBase.ImageAdapter;
import com.example.imageappproject.DataBase.ImageViewModel;
import com.example.imageappproject.DataBase.SingleImageEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ImageAdapter.ClickInterface {

    RecyclerView mRecyclerView;
    static ImageAdapter mImageAdapter;
    static Context mContext;
    static List<SingleImageEntity> mList = new ArrayList<>();
    static ImageViewModel viewModel;
    EditText searchEditText;
    Button SearchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Utils.getDataForUi();
    }

    public void init(){

        mContext = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mImageAdapter = new ImageAdapter(this,this);
        mRecyclerView.setAdapter(mImageAdapter);
        viewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        searchEditText = (EditText) findViewById(R.id.searchEditText);
        SearchButton = findViewById(R.id.search_button);
        searchInit();

    }

    public void searchInit(){
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search_String = searchEditText.getText().toString();
                Search_String = Search_String.trim();
                Utils.showSearchData(Search_String);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.refresh:
                                refreshData();
                                return true;
            case R.id.sort:
                                sortData();
                                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshData() {
        viewModel.deleteAllData();
        Utils.loadData();
    }
    private void sortData(){
        Utils.sortData();
    }

    @Override
    public void OnClickMethod(String url) {
        Intent intent = new Intent(this,ImageActivity.class);
        intent.putExtra("URL",url);
        startActivity(intent);
    }


}