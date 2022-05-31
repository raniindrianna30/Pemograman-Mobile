package com.example.notifMyTask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mytasklistnotif.R;

import java.util.List;

public class detail_task extends AppCompatActivity {
    TaskAdapter taskAdapter;
    List<Task> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        TextView theTitle = findViewById(R.id.editTitle);
        TextView theCourse = findViewById(R.id.editCourse);
        TextView theDate = findViewById(R.id.editDate);
        TextView theTime = findViewById(R.id.editTime);
        TextView theDesc = findViewById(R.id.editDesc);

//        getData();
//        setData();

        Intent intent = getIntent();

        Task taskSuccess = intent.getParcelableExtra("task");
        theTitle.setText(taskSuccess.getTitle());
        theCourse.setText(taskSuccess.getCourse());
        theDate.setText(taskSuccess.getDate());
        theTime.setText(taskSuccess.getTime());
        theDesc.setText(taskSuccess.getDesc());
    }

//    public void getData() {
//        if(getIntent().hasExtra("title")&& getIntent().hasExtra("course")&& getIntent().hasExtra("due date")&& getIntent().hasExtra("time") && getIntent().hasExtra("desc")) {
//            string1 = getIntent().getStringExtra("title");
//            string2 = getIntent().getStringExtra("course");
//            string3 = getIntent().getStringExtra("date");
//            string4 = getIntent().getStringExtra("time");
//            string5 = getIntent().getStringExtra("desc");
//        }else {
//            Toast.makeText(this,"Nothing",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void setData() {
//        theTitle.setText(string1);
//        theCourse.setText(string2);
//        theDate.setText(string3);
//        theTime.setText(string4);
//        theDesc.setText(string5);
    }