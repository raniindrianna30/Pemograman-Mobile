package com.example.crudapi.SingleResourceNotFound;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.R;
import com.example.crudapi.RestClient;
import com.example.crudapi.SingleUsersResource.Response.SingleResourceResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleResourceNotFound extends AppCompatActivity {
    TextView responseStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_resource_not_found);
        ButterKnife.bind(this);
        responseStatus = findViewById(R.id.responseStatusSingleResourceNotFound);

        RestClient.getService().getSingleResourceNotFound().enqueue(new Callback<SingleResourceResponse>() {
            @Override
            public void onResponse(@NonNull Call<SingleResourceResponse> call, @NonNull Response<SingleResourceResponse> response) {
                if (response.isSuccessful()){
                    responseStatus.setText(Integer.toString(response.code()));
                } else {
                    responseStatus.setText(Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<SingleResourceResponse> call, @NonNull Throwable t) {

            }
        });
    }
}