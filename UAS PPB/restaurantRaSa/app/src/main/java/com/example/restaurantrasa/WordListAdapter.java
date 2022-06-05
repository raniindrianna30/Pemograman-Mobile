package com.example.restaurantrasa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>implements Filterable {


    private ArrayList<String> imageMenu = new ArrayList<>();
    private ArrayList<String> nameMenu = new ArrayList<>();
    private ArrayList<String> descMenu = new ArrayList<>();
   List<String>allListMenu;
    private Context context;
    ;



    public WordListAdapter(ArrayList<String> image, ArrayList<String> name, ArrayList<String> desc, Context context) {
        this.imageMenu = image;
        this.nameMenu = name;
        this.descMenu = desc;
        this.context = context;
        this.allListMenu = new ArrayList<>();
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_item, parent, false);
//        WordViewHolder holder = new WordViewHolder(view);
        return new WordViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).asBitmap().load(imageMenu.get(position)).into(holder.Image);
        holder.title.setText(nameMenu.get(position));


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detailActivity.class);

                intent.putExtra("image_detail", imageMenu.get(position));
                intent.putExtra("menu_detail", nameMenu.get(position));
                intent.putExtra("desc_detail", descMenu.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameMenu.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<String>filteredList = new ArrayList<>();

            if(charSequence.toString().isEmpty()) {
                filteredList.addAll(allListMenu);
            } else {
                for(String menu : allListMenu) {
                    if(menu.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(menu);
                    }

                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        //run on a ui thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            nameMenu.clear();
            nameMenu.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();

        }
    };



    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView Image;
        ConstraintLayout constraintLayout;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleMenu);
            Image = itemView.findViewById(R.id.imageMenu);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);


        }
    }
}
