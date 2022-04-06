package com.example.mytasklist;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_tugas")
public class Task {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "namatugas")
    private String namaTugas;

    @ColumnInfo(name = "deadline")
    private String deadline;

    @ColumnInfo(name = "note")
    private String note;

    public Task(@NonNull String namaTugas, String deadline, String note) {
        this.namaTugas = namaTugas;
        this.deadline = deadline;
        this.note = note;
    }

    public String getNamaTugas(){return this.namaTugas;}
    public String getDeadline() {return deadline;}
    public String getNote() {return note;}
}