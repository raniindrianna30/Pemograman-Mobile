package com.example.mytasklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TextView NamaItemView;
    private final TextView Note;
    private final TextView Deadline;
    ConstraintLayout mainLayout;

    private TaskViewHolder(View itemView){
        super(itemView);
        NamaItemView = itemView.findViewById(R.id.title);
        Deadline = itemView.findViewById(R.id.tanggal);
        Note = itemView.findViewById(R.id.desc);
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }

    public void bind(String nama, String deadline,  String note){
        NamaItemView.setText(nama);
        Deadline.setText(deadline);
        //Note.setText(note);
    }

    static TaskViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tugas,parent,false);
        return new TaskViewHolder(view);
    }

}