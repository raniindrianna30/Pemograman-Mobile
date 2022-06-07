package com.example.crudapi.Delete;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class DeleteActivity extends AppCompatActivity {
    TextView statusDelete;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        ButterKnife.bind(this);
        delete = findViewById(R.id.doneDelete);
        statusDelete = findViewById(R.id.statusDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestClient.getService().deleteList().enqueue(new Callback<SingleResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SingleResponse> call, @NonNull Response<SingleResponse> response) {
                        if (response.isSuccessful()){
                            statusDelete.setText(Integer.toString(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SingleResponse> call, @NonNull Throwable t) {

                    }
                });
            }
        });
    }
}