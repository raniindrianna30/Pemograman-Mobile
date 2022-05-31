package com.example.notifMyTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mytasklistnotif.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    FloatingActionButton addButton;
    List<Task> list;
    private TaskViewModel taskViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(view ->  {
            Intent intent = new Intent(MainActivity.this,addTask.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        recyclerView = findViewById(R.id.listTask);
        final TaskAdapter taskAdapter = new TaskAdapter(new TaskAdapter.TaskDiff(),this);
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getAllTask().observe(this,tasks -> {
           taskAdapter.submitList(tasks);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Task task = data.getParcelableExtra("task");

            taskViewModel.insert(task);

            Toast.makeText(this,  "Tugas Tersimpan", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Tugas belum Tersimpan!",Toast.LENGTH_SHORT).show();
        }
    }
}