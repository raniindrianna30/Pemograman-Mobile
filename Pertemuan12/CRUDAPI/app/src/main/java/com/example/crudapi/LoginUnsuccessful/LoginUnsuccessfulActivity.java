package com.example.crudapi.LoginUnsuccessful;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.LoginUnsuccessful.DataItem.BodyLoginUnsuccessful;
import com.example.crudapi.LoginUnsuccessful.Response.LoginUnsuccessfulResponse;
import com.example.crudapi.R;
import com.example.crudapi.RestClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUnsuccessfulActivity extends AppCompatActivity {

    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_unsuccessful);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {

        BodyLoginUnsuccessful bodyLoginUnsuccessful =  new BodyLoginUnsuccessful();
        bodyLoginUnsuccessful.setEmail(edtEmail.getText().toString());


        RestClient.getService().postUnsuccessLogin(bodyLoginUnsuccessful).enqueue(new Callback<LoginUnsuccessfulResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<LoginUnsuccessfulResponse> call, Response<LoginUnsuccessfulResponse> response) {
                Toast.makeText(getApplicationContext(),"error : Missing password",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginUnsuccessfulResponse> call, Throwable t) {

            }
        });
    }
}