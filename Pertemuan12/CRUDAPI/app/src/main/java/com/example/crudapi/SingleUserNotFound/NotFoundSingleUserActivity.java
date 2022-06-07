package com.example.crudapi.SingleUserNotFound;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.R;
import com.example.crudapi.RestClient;
import com.example.crudapi.SingleUsers.Response.SingleResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotFoundSingleUserActivity extends AppCompatActivity {
    TextView responseStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_found_single_user2);
        ButterKnife.bind(this);
        responseStatus = findViewById(R.id.responseStatusSingleNotFound);

        RestClient.getService().getSingleNotFound().enqueue(new Callback<SingleResponse>() {
            @Override
            public void onResponse(@NonNull Call<SingleResponse> call, @NonNull Response<SingleResponse> response) {
                if (response.isSuccessful()){
                    responseStatus.setText(Integer.toString(response.code()));
                } else {
                    responseStatus.setText(Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<SingleResponse> call, @NonNull Throwable t) {

            }
        });
    }
}
