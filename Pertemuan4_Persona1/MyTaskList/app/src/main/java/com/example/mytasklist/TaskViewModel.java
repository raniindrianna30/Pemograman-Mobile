package com.example.mytasklist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;

    private final LiveData<List<Task>> mAllTask;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTask = mRepository.getAllTask();
    }

    LiveData<List<Task>> getAllTask() { return mAllTask; }

    public void insert(Task task) { mRepository.insert(task); }
}
