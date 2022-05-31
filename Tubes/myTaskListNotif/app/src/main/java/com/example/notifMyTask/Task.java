package com.example.notifMyTask;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_task")
public class Task  implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    int id;

    @NonNull
    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "course")
    @NonNull
    String course;

    @ColumnInfo(name = "date")
    @NonNull
    String date;

    @ColumnInfo(name = "time")
    @NonNull
    String time;

    @ColumnInfo(name = "desc")
    @NonNull
    String desc;

    public Task(String title, String course, String date, String time, String desc) {
        this.title = title;
        this.course = course;
        this.date = date;
        this.time = time;
        this.desc = desc;
    }

    public String getTitle() {return this.title;}
    public String getCourse() {return this.course;}
    public String getDate() {return this.date;}
    public String getTime() {return this.time;}
    public String getDesc() {return this.desc;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.course);
        parcel.writeString(this.date);
        parcel.writeString(this.time);
        parcel.writeString(this.desc);
    }

    protected Task(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.course = in.readString();
        this.date = in.readString();
        this.time = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>(){

        @Override
        public Task createFromParcel(Parcel source) {
        return new Task(source);
        }

        @Override
            public Task[] newArray(int size) {
            return new Task[size];
            }
    };
}
