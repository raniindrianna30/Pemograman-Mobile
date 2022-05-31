package com.example.notifMyTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Query("DELETE FROM table_task")
    void deleteAll();

    @Query("SELECT * FROM table_task ORDER BY date ASC")
    LiveData<List<Task>>getAll();




}
