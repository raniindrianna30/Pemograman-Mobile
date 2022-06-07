package com.example.crudapi.ListUsersResource;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapi.ListUsersResource.DataItem.DataItemListResource;
import com.example.crudapi.ListUsersResource.Response.ListUserResourceResponse;
import com.example.crudapi.R;
import com.example.crudapi.RestClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserResourceActivity extends AppCompatActivity {

    @BindView(R.id.rvListResource)
    RecyclerView rvListResource;

    private List<DataItemListResource> listItemResource;
    private AdapterListResource adapterListResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_resource);
        ButterKnife.bind(this);

        RestClient.getService().getListResource().enqueue(new Callback<ListUserResourceResponse>() {
            @Override
            public void onResponse(Call<ListUserResourceResponse> call, Response<ListUserResourceResponse> response) {
                if (response.isSuccessful()){
                    listItemResource = response.body().getData();

                    adapterListResource = new AdapterListResource(listItemResource, ListUserResourceActivity.this);
                    rvListResource.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListResource.setAdapter(adapterListResource);
                }
            }

            @Override
            public void onFailure(Call<ListUserResourceResponse> call, Throwable t) {

            }
        });
    }
}