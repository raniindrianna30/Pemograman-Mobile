package com.example.crudapi.UpdatePut;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.R;
import com.example.crudapi.RestClient;
import com.example.crudapi.UpdatePut.Response.PutResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePutActivity extends AppCompatActivity {

    EditText putName, putJob;
    Button UpdatePut;
    TextView name, job, updateJob, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_put);
        ButterKnife.bind(this);

        putName = findViewById(R.id.putName);
        putJob = findViewById(R.id.putJob);
        UpdatePut = findViewById(R.id.donePut);
        name = findViewById(R.id.textViewNamePut);
        job = findViewById(R.id.textViewJobPut);
        updateJob = findViewById(R.id.textViewCreateAtPut);
        status = findViewById(R.id.textViewStatusPut);

        UpdatePut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestClient.getService().updatePut(putName.getText().toString(), putJob.getText().toString()).enqueue(new Callback<PutResponse>() {
                    @Override
                    public void onResponse(Call<PutResponse> call, Response<PutResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body() != null) {

                                status.setText(Integer.toString(response.code()));
                                name.setText(response.body().getName());
                                job.setText(response.body().getJob());
                                updateJob.setText(response.body().getUpdatedAt());
                            }
                            Toast.makeText(getApplicationContext(),
                                            "Name :" + response.body().getName() +
                                            "Job :" + response.body().getJob(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PutResponse> call, Throwable t) {

                    }
                });
            }
        });


    }
}