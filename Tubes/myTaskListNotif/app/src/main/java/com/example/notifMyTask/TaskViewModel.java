package com.example.notifMyTask;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;
    private final LiveData<List<Task>>mAllTask;
    private WorkManager workManager;
    private static final String TAG =  TaskViewModel.class.getSimpleName();

    public TaskViewModel (@NonNull Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTask = mRepository.getAllTask();
        workManager = WorkManager.getInstance(application);
    }

    LiveData<List<Task>> getAllTask() {
        return mAllTask;
    }

    @SuppressLint("RestrictedApi")
    public void insert(Task task) {
        mRepository.insert(task);
        String myFormat = "dd/MM/yyyy - HH:mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        String combineDateTime = task.date+ " - " + task.time;
        Date date;
        try {
            date = dateFormat.parse(combineDateTime);
            Long diffTime = date.getTime() - System.currentTimeMillis();
            System.out.println("diffTime:" + diffTime);
            Data myData = new Data.Builder()
                    .putString("title",task.getTitle())
                    .build();
            WorkRequest workRequest = new OneTimeWorkRequest.Builder(NotificationWorker.class)
                    .setInitialDelay(diffTime, TimeUnit.MILLISECONDS)
                    .setInputData(myData)
                    .build();
            workManager.enqueue(workRequest);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
