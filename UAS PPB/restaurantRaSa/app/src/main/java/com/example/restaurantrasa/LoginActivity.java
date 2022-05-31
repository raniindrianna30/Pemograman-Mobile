package com.example.restaurantrasa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText at_username,at_password;
    TextView noAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        at_username = findViewById(R.id.add_email);
        at_password = findViewById(R.id.add_pass);
        noAccount = findViewById(R.id.tvCreateAccount);

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(at_username.getText().toString())
                        || TextUtils.isEmpty(at_password.getText().toString())) {

                    String message = "input all required";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();

                }else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(at_username.getText().toString());
                    loginRequest.setPassword(at_password.getText().toString());

                    loginRequest(loginRequest);
                }
            }
        });
    }
    public void loginRequest(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("data",loginResponse));

                    finish();

                }else {

                    String message = "An error occurred, please try again";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });

    }
}