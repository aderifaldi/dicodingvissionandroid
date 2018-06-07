package com.example.dicodingvission.view.photo_selector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.example.dicodingvission.R;
import com.example.dicodingvission.view.analize.AnalizePhotoActivity;

import java.util.ArrayList;
import java.util.List;

public class PhotoSelectorActivity extends AppCompatActivity {

    private RecyclerView listImage;
    private GridLayoutManager gridLayoutManager;
    private PhotoSelectorAdapter adapter;
    private List<Photo> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_selector_activity);

        initView();
        initList();
        initData();
        storeDataToList();

    }

    private void initView() {

        listImage = findViewById(R.id.listImage);

    }

    private void initList() {
        gridLayoutManager = new GridLayoutManager(this, 3);
        adapter = new PhotoSelectorAdapter(this);

        listImage.setAdapter(adapter);
        listImage.setLayoutManager(gridLayoutManager);

        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), AnalizePhotoActivity.class);
                intent.putExtra("imageUrl", adapter.getData().get(i).getUrl());
                startActivity(intent);
            }
        });
    }

    private void initData() {

        images = new ArrayList<>();
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision1.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision2.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision3.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision4.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision5.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision6.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision7.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision8.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision9.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision10.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision11.jpg"));
        images.add(new Photo("https://research5571.blob.core.windows.net/dicoding/vision12.jpg"));


    }

    private void storeDataToList() {
        if (images.size() != 0){
            for (int i = 0; i < images.size(); i++) {
                adapter.getData().add(images.get(i));
                adapter.notifyItemInserted(adapter.getData().size() - 1);
            }
            adapter.notifyDataSetChanged();
        }
    }

}
