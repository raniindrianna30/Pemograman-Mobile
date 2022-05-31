package com.example.notifMyTask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytasklistnotif.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    LinearLayout mainLayout;
    private final TextView textViewTitle;
    private final TextView textViewDate;
    private final TextView textViewTime;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.itemTitle);
        textViewDate = itemView.findViewById(R.id.itemDate);
        textViewTime = itemView.findViewById(R.id.itemTime);
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }

    public void bind(String title, String date, String time,String course) {
        textViewTitle.setText(title);
        textViewDate.setText(date);
        textViewTime.setText(time);
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_task,parent,false);
        return new TaskViewHolder(view);
    }
}
