package com.example.restaurantrasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailActivity extends AppCompatActivity {
    ImageView ImageDetail;
    TextView MenuDetail, DescDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        ImageDetail = findViewById(R.id.image_Detail);
        MenuDetail = findViewById(R.id.title_Detail);
        DescDetail = findViewById(R.id.desc_Detail);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("image_detail") &&
                getIntent().hasExtra("menu_detail") &&
                getIntent().hasExtra("desc_detail")) {

            String pict = getIntent().getStringExtra("image_detail");
            String menu = getIntent().getStringExtra("menu_detail");
            String desc = getIntent().getStringExtra("desc_detail");


            setDataActivity(pict, menu, desc);
        }
    }

    private void setDataActivity(String image, String menu, String desc){
        Glide.with(this).asBitmap().load(image).into(ImageDetail);
        MenuDetail.setText(menu);
        DescDetail.setText(desc);

    }
}