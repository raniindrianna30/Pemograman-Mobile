package com.example.mytasklist;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskListAdapter extends ListAdapter<Task,TaskViewHolder> {
    Context context;
    public TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback, Context ct){
        super(diffCallback);
        context = ct;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task current = getItem(position);
        holder.bind(current.getNamaTugas(), current.getDeadline(), current.getNote());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activity_detail_task.class);
                intent.putExtra("tugas",current.getNamaTugas());
                intent.putExtra("deadline",current.getDeadline());
                intent.putExtra("catatan",current.getNote());
                context.startActivity(intent);
            }
        });
    }

    static public class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            boolean same;
            same = oldItem.getNamaTugas().equals(newItem.getNamaTugas()) && oldItem.getNote().equals(newItem.getNote()) ;
            return same;
        }
    }
}