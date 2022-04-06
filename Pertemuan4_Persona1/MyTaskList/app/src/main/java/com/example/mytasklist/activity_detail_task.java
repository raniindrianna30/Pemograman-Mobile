package com.example.mytasklist;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_detail_task extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    String string1, string2, string3;
    ImageView imageView;
    private TaskViewModel mTaskViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        textView1 = findViewById(R.id.myTextTask);
        textView2 = findViewById(R.id.myTextDeadline);
        textView3 = findViewById(R.id.myTextDesc);

        getData();
        setData();
    }

    public void getData() {
        if(getIntent().hasExtra("tugas") && getIntent().hasExtra("catatan") ) {
            string1 = getIntent().getStringExtra("tugas");
            string2 = getIntent().getStringExtra("deadline");
            string3 = getIntent().getStringExtra("catatan");
        } else {
            Toast.makeText(this,"Nothing",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        textView1.setText(string1);
        textView2.setText(string2);
        textView3.setText(string3);
    }

}

