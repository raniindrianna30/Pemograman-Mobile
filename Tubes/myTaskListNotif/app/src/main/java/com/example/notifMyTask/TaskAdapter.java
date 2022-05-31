package com.example.notifMyTask;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskAdapter extends ListAdapter<Task, TaskViewHolder> {
    Context context;


    protected TaskAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback, Context context) {
       super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = getItem(position);
      holder.bind(currentTask.getTitle(),currentTask.getDate(),currentTask.getTime(), currentTask.getCourse());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task(currentTask.getTitle(),currentTask.getCourse(),currentTask.getDate(),currentTask.getTime(),currentTask.getDesc());
                Intent item = new Intent(context, detail_task.class);
                item.putExtra("task",task);
                context.startActivity(item);
            }
        });
    }
    static class TaskDiff extends DiffUtil.ItemCallback<Task> {
        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}
