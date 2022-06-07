package com.example.crudapi.Post;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.Post.Response.PostResponse;
import com.example.crudapi.R;
import com.example.crudapi.RestClient;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    EditText postName, postJob;
    Button btnPost;
    TextView id, name, job, createJob, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);

        postName = findViewById(R.id.postName);
        postJob = findViewById(R.id.postJob);
        btnPost = findViewById(R.id.donePost);
        id = findViewById(R.id.textViewId);
        name = findViewById(R.id.textViewName);
        job = findViewById(R.id.textViewJob);
        createJob = findViewById(R.id.textViewCreateAt);
        status = findViewById(R.id.textViewStatus);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestClient.getService().createPost(postName.getText().toString(), postJob.getText().toString()).enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body() != null) {

                                status.setText(Integer.toString(response.code()));
                                id.setText(response.body().getId());
                                name.setText(response.body().getName());
                                job.setText(response.body().getJob());
                                createJob.setText(response.body().getCreatedAt());
                            }
                            Toast.makeText(getApplicationContext(),
                                    "ID :" + response.body().getId() +
                                            "Name :" + response.body().getName() +
                                            "Job :" + response.body().getJob(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {

                    }
                });
            }
        });


    }
}