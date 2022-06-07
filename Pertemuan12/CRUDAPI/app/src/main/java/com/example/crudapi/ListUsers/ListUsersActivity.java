package com.example.crudapi.ListUsers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class ListUsersActivity extends AppCompatActivity {

    @BindView(R.id.rvListUser)
    RecyclerView rvListUser;

    private List<DataItemList> listItem;
    private AdapterListUsers adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        ButterKnife.bind(this);

        RestClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()){
                    listItem = response.body().getData();

                    adapter = new AdapterListUsers(listItem, ListUsersActivity.this);
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