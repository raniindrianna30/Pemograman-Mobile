package com.example.mytasklist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM tabel_tugas")
    void deleteAll();

    @Query("SELECT * FROM tabel_tugas ORDER BY deadline ASC")
    LiveData<List<Task>> getAlphabetizedWords();
}
