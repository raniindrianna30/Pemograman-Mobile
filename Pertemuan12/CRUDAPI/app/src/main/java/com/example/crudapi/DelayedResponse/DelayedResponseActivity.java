package com.example.crudapi.DelayedResponse;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapi.ListUsers.AdapterListUsers;
import com.example.crudapi.ListUsers.DataItem.DataItemList;
import com.example.crudapi.ListUsers.Response.ListUserResponse;
import com.example.crudapi.R;
import com.example.crudapi.RestClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DelayedResponseActivity extends AppCompatActivity {

    @BindView(R.id.rvListUser)
    RecyclerView rvListUser;

    private List<DataItemList> listItem;
    private AdapterListUsers adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_response);
        ButterKnife.bind(this);

        RestClient.getService().getDelayed().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()){
                    listItem = response.body().getData();

                    adapter = new AdapterListUsers(listItem, DelayedResponseActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {

            }
        });
    }
}