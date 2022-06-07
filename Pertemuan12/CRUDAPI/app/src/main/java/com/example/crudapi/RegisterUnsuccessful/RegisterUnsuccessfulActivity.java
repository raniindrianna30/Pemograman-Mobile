package com.example.crudapi.RegisterUnsuccessful;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.R;
import com.example.crudapi.RegisterUnsuccessful.DataItem.BodyRegisterUnsuccessful;
import com.example.crudapi.RegisterUnsuccessful.Response.RegisterUnsuccessfulResponse;
import com.example.crudapi.RestClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUnsuccessfulActivity extends AppCompatActivity {
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.btnRegisterUnsuccessful)
    Button btnRegisterUnsuccessful;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unsuccessful);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegisterUnsuccessful)
    public void onViewClicked() {

        BodyRegisterUnsuccessful bodyRegisterUnsuccessful =  new BodyRegisterUnsuccessful();
        bodyRegisterUnsuccessful.setEmail(edtEmail.getText().toString());


        RestClient.getService().postRegisterUnsuccessful(bodyRegisterUnsuccessful).enqueue(new Callback<RegisterUnsuccessfulResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<RegisterUnsuccessfulResponse> call, Response<RegisterUnsuccessfulResponse> response) {
                Toast.makeText(getApplicationContext(),"error : Missing password",Toast.LENGTH_SHORT).show();
                Log.i("Response",response.message());
            }

            @Override
            public void onFailure(Call<RegisterUnsuccessfulResponse> call, Throwable t) {

            }
        });
    }
}