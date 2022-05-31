package com.example.notifMyTask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.mytasklistnotif.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class addTask extends AppCompatActivity {
    private EditText addTitle;
    private EditText addCourse;
    private EditText addDate;
    private EditText addTime;
    private EditText addDesc;
    Button addButton;

    final Calendar myCalendar = Calendar.getInstance();
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        addTitle = findViewById(R.id.theTitle);
        addCourse = findViewById(R.id.theCourse);
        addDate = findViewById(R.id.theDate);
        addTime = findViewById(R.id.theTime);
        addDesc = findViewById(R.id.theDesc);
        addButton = findViewById(R.id.addButton);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateDate();
            }
        };
        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog();
            }
        });

        addDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(addTask.this,date,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).
                        show();
            }
        });

        addButton.setOnClickListener(view -> {
                    Intent replyIntent = new Intent();
                    if(TextUtils.isEmpty(addTitle.getText())) {
                        setResult(RESULT_CANCELED, replyIntent);
                    }else {
                        String titleTask = addTitle.getText().toString();
                        String courseTask = addCourse.getText().toString();
                        String dateTask = addDate.getText().toString();
                        String timeTask = addTime.getText().toString();
                        String descTask = addDesc.getText().toString();
                        Task tugas = new Task(titleTask,courseTask,dateTask,timeTask,descTask);
                        replyIntent.putExtra("task",tugas);
                        setResult(RESULT_OK,replyIntent);
                    }
                    finish();
                });
    }

    private void updateDate() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        addDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void showTimeDialog() {
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                addTime.setText(hour+":"+minute);
            }
        },
                myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
}