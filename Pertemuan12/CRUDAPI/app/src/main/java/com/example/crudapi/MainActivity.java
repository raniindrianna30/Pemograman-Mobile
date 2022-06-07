package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.crudapi.DelayedResponse.DelayedResponseActivity;
import com.example.crudapi.Delete.DeleteActivity;
import com.example.crudapi.ListUsers.ListUsersActivity;
import com.example.crudapi.ListUsersResource.ListUserResourceActivity;
import com.example.crudapi.LoginSuccessful.LoginActivity;
import com.example.crudapi.LoginUnsuccessful.LoginUnsuccessfulActivity;
import com.example.crudapi.Post.PostActivity;
import com.example.crudapi.UpdatePatch.UpdatePatchActivity;
import com.example.crudapi.Post.CreateInsertActivity;
import com.example.crudapi.UpdatePut.UpdatePutActivity;
import com.example.crudapi.RegisterSuccessful.RegisterActivity;
import com.example.crudapi.RegisterUnsuccessful.RegisterUnsuccessfulActivity;
import com.example.crudapi.SingleResourceNotFound.SingleResourceNotFound;
import com.example.crudapi.SingleUserNotFound.NotFoundSingleUserActivity;
import com.example.crudapi.SingleUsers.SingleUsersActivity;
import com.example.crudapi.SingleUsersResource.SingleUsersResourceActivity;

public class MainActivity extends AppCompatActivity {
    Button listUsers, singleUsers, listUserResource,
            singleUserResource, post, updatePut, updatePatch, delete, singleUsersNotFound,
            singleResourceNotFound, loginSuccessful, loginUnsuccessful,
            delayedResponse, registerSuccessful, registerUnsuccessful;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listUsers = findViewById(R.id.listUsers);
        singleUsers = findViewById(R.id.singleUsers);
        listUserResource = findViewById(R.id.listResource);
        singleUserResource = findViewById(R.id.singleResource);
        post = findViewById(R.id.create);
        updatePut = findViewById(R.id.updatePut);
        updatePatch = findViewById(R.id.updatePatch);
        delete = findViewById(R.id.delete);
        singleUsersNotFound = findViewById(R.id.singleUsersNotFound);
        singleResourceNotFound = findViewById(R.id.singleResourceNotFound);
        loginSuccessful = findViewById(R.id.loginsuccessful);
        loginUnsuccessful = findViewById(R.id.loginUnsuccessful);
        delayedResponse = findViewById(R.id.delayedResponse);
        registerSuccessful = findViewById(R.id.registerSuccessful);
        registerUnsuccessful = findViewById(R.id.registerUnsuccessful);

        listUsers.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListUsersActivity.class));
        });

        singleUsers.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SingleUsersActivity.class));
        });

        listUserResource.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListUserResourceActivity.class));
        });

        singleUserResource.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SingleUsersResourceActivity.class));
        });

        post.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CreateInsertActivity.class));
        });

        updatePut.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, UpdatePutActivity.class));
        });

        updatePatch.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, UpdatePatchActivity.class));
        });

        delete.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DeleteActivity.class));
        });

        singleUsersNotFound.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NotFoundSingleUserActivity.class));
        });

        singleResourceNotFound.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SingleResourceNotFound.class));
        });

        loginSuccessful.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

        loginUnsuccessful.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginUnsuccessfulActivity.class));
        });

        delayedResponse.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DelayedResponseActivity.class));
        });

        registerSuccessful.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });

        registerUnsuccessful.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterUnsuccessfulActivity.class));
        });

    }
}