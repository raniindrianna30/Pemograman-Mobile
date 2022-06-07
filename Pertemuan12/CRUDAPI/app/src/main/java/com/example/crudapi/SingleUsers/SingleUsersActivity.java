package com.example.crudapi.SingleUsers;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.crudapi.R;
import com.example.crudapi.RestClient;
import com.example.crudapi.SingleUsers.Response.SingleResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUsersActivity extends AppCompatActivity {
    TextView singleName, singleLastName;
    ImageView singleAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_users);
        ButterKnife.bind(this);

        singleName = findViewById(R.id.single_name);
        singleLastName = findViewById(R.id.single_last_name);
        singleAvatar = findViewById(R.id.single_img);

        RestClient.getService().getSingleUser().enqueue(new Callback<SingleResponse>() {
            @Override
            public void onResponse(Call<SingleResponse> call, Response<SingleResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    singleName.setText(response.body().getData().getFirstName());
                    singleLastName.setText(response.body().getData().getLastName());
                    Glide.with(singleAvatar).load(response.body().getData().getAvatar()).into(singleAvatar);
                }
            }

            @Override
            public void onFailure(Call<SingleResponse> call, Throwable t) {

            }
        });
    }
}