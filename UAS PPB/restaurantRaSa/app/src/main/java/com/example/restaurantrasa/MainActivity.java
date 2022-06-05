package com.example.restaurantrasa;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    private RequestQueue mQueue;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;


    private ArrayList<String> foto = new ArrayList<>();
    private ArrayList<String> nama = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");

            Log.e("TAG", "=====>" + loginResponse.getStatus());

        }
        setContentView(R.layout.activity_main);


        mQueue = Volley.newRequestQueue(this);
        jsonparse();
    }

    private void jsonparse() {
        String url = "https://foodbukka.herokuapp.com/api/v1/menu";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Result");
                            int k = 0;
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject Result = jsonArray.getJSONObject(i);

                                ArrayList<String> image = new ArrayList<String>();
                                JSONArray jsonArray1 = (JSONArray) Result.getJSONArray("images");
                                if (jsonArray1 != null) {
                                    for (int j = 0; j < jsonArray1.length(); j++) {
                                        image.add(jsonArray1.getString(j));
                                    }
                                }

                                String _id = Result.getString("_id");
                                String menuname = Result.getString("menuname");
                                String description = Result.getString("description");
                                int __v = Result.getInt("__v");

                                if (k <= 2) {
                                    foto.add(image.get(k));
                                    k = k + 1;
                                } else {
                                    k = 0;
                                    foto.add(image.get(k));
                                    k = k + 1;
                                }
                                nama.add(menuname);
                                desc.add(description);
                                prosesRecycleView();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    private void prosesRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.rvListMenu);
        WordListAdapter adapter = new WordListAdapter(foto, nama, desc, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
