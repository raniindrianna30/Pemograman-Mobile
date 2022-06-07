package com.example.crudapi.LoginSuccessful;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.LoginSuccessful.DataItem.BodyLogin;
import com.example.crudapi.LoginSuccessful.Response.LoginResponse;
import com.example.crudapi.R;
import com.example.crudapi.RestClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {

        BodyLogin bodyLogin =  new BodyLogin();
        bodyLogin.setEmail(edtEmail.getText().toString());
        bodyLogin.setPassword(edtPassword.getText().toString());


        RestClient.getService().postLogin(bodyLogin).enqueue(new Callback<LoginResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                Log.i("Response",response.message());
                startActivity(new Intent(getApplicationContext(), LoginSuccessfulActivity.class));
                finish();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}