package com.example.restaurantrasa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btnSignUp;
    EditText atUsername,atEmail,atPassword,atCpassword,atPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSignUp = findViewById(R.id.btnSignUp);
        atUsername = findViewById(R.id.addUserName);
        atEmail = findViewById(R.id.add_Email);
        atPassword = findViewById(R.id.add_Password);
        atCpassword = findViewById(R.id.addCPassword);
        atPhone = findViewById(R.id.add_Phone);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(atUsername.getText().toString())
                        || TextUtils.isEmpty(atEmail.getText().toString())
                        || TextUtils.isEmpty(atPassword.getText().toString())
                        || TextUtils.isEmpty(atCpassword.getText().toString())
                        || TextUtils.isEmpty(atPhone.getText().toString())) {

                    String message = "All inputs require";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();
                } else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setUsername(atUsername.getText().toString());
                    registerRequest.setEmail(atEmail.getText().toString());
                    registerRequest.setPassword(atPassword.getText().toString());
                    registerRequest.setPhoneNumber(atPhone.getText().toString());
                    registerUser(registerRequest);
                }

            }
        });

    }

    public void registerUser(RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUsers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){

                    String message = "Successful";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    finish();

                }else {

                    String message = "An error occurred, please try again ";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }
}