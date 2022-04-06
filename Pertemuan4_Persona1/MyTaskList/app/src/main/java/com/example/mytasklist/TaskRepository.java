package com.example.mytasklist;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTask;


    TaskRepository(Application application){
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTask = mTaskDao.getAlphabetizedWords();
    }

    LiveData<List<Task>> getAllTask(){
        return mAllTask;
    }

    void insert(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTaskDao.insert(task);
        });
    }

}