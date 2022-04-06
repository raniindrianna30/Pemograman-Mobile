package com.example.mytasklist;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class fragment_list extends Fragment {
    private TaskViewModel mTaskViewModel;

    public fragment_list() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        final TaskListAdapter adapter = new TaskListAdapter(new TaskListAdapter.TaskDiff(),view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mTaskViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TaskViewModel.class);
        mTaskViewModel.getAllTask().observe(getViewLifecycleOwner(),taskes -> {
            adapter.submitList(taskes);
        });

        FloatingActionButton fab = view.findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), activity_add_task.class);
                startActivityForResult(intent,1);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == -1){
            Task task = new Task(data.getStringExtra("tugas"),data.getStringExtra("deadline"),data.getStringExtra("catatan"));
            mTaskViewModel.insert(task);
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    "MASUK",
                    Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}

