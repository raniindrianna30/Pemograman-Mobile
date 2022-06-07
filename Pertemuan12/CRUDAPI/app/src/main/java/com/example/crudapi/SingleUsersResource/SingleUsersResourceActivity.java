package com.example.crudapi.SingleUsersResource;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.R;
import com.example.crudapi.RestClient;
import com.example.crudapi.SingleUsersResource.Response.SingleResourceResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUsersResourceActivity extends AppCompatActivity {
    TextView singleName, singleColor, singlePantone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_users_resource);
        ButterKnife.bind(this);

        singleName = findViewById(R.id.tv_name);
        singleColor = findViewById(R.id.tv_color);
        singlePantone = findViewById(R.id.tv_pantone_value);

        RestClient.getService().getSingleResource().enqueue(new Callback<SingleResourceResponse>() {
            @Override
            public void onResponse(Call<SingleResourceResponse> call, Response<SingleResourceResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    singleName.setText(response.body().getData().getName());
                    singleColor.setText(response.body().getData().getColor());
                    singlePantone.setText(response.body().getData().getPantoneValue());
                }
            }

            @Override
            public void onFailure(Call<SingleResourceResponse> call, Throwable t) {

            }
        });
    }
}