package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;


    private final LinkedList<String> mWordList = new LinkedList <>();

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0;i<20; i++){
            mWordList.addLast(" Word" + i);
        }

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);
        // Create an adapter and supply the data to be displayed.
                mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView.
                mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClick(View view) {
        int wordListSize = mWordList.size();
        // Add a new word to the wordList.
        mWordList.addLast("+ Word " + wordListSize);
        // Notify the adapter that the data has changed.
        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
        // Scroll to the bottom.
        mRecyclerView.smoothScrollToPosition(wordListSize);
    }


}