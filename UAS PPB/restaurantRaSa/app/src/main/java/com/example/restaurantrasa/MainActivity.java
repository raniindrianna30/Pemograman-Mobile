package com.example.restaurantrasa;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        if (intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");

            Log.e("TAG","=====>"+loginResponse.getStatus());

        }


    }
}