package com.example.imageappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {
    ImageView FullImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        FullImageView = (ImageView) findViewById(R.id.full_image_view);
        Intent intent = getIntent();

        String image_url = intent.getStringExtra("URL");
        Picasso.get().load(image_url).into(FullImageView);
    }
}