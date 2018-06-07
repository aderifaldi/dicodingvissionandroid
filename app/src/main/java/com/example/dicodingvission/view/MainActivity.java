package com.example.dicodingvission.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dicodingvission.Constant;
import com.example.dicodingvission.R;
import com.example.dicodingvission.view.select_photo.PhotoSelectorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Bundle bundle;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
    }

    private void initView() {
        Button btnAnalizeImage = findViewById(R.id.btnAnalizeImage);
        Button btnAutoCaption = findViewById(R.id.btnAutoCaption);
        Button btnActrees = findViewById(R.id.btnActrees);

        btnAnalizeImage.setOnClickListener(this);
        btnAutoCaption.setOnClickListener(this);
        btnActrees.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        bundle = new Bundle();
        intent = new Intent(this, PhotoSelectorActivity.class);

        switch (view.getId()){
            case R.id.btnAnalizeImage:
                runIntent(Constant.Data.ANALYZE);
                break;
            case R.id.btnAutoCaption:
                runIntent(Constant.Data.AUTO_CAPTION);
                break;
            case R.id.btnActrees:
                runIntent(Constant.Data.ACTRESS);
                break;
        }

    }

    private void runIntent(int vision){
        bundle.putInt("vision", vision);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
