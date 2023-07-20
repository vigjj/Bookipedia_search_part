package com.ucdenver_vigil.bookipediasearchpart;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ListItemHolder> {
    private MainActivity mainActivity;
    private Search_Fragment search_fragment;
    private ArrayList<Book> foundBooks;
    private int id;
    public SearchAdapter (Search_Fragment search_fragment, ArrayList<Book> list) {
        this.search_fragment = search_fragment;
        this.foundBooks = list;

    }


    @NonNull
    @Override
    public SearchAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from (parent.getContext())
                .inflate(R.layout.list_layout, parent, false);
        return new ListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ListItemHolder holder, int id) {
        Book book = foundBooks.get(id);
        holder.bookName.setText(book.getName());


    }

    @Override
    public int getItemCount() {
        return foundBooks.size();
    }


    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView bookName;


        public ListItemHolder (View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.bookName);
            bookName.setClickable(true);
            bookName.setOnClickListener(this);


        }
        // public void bookPosition(int position,ArrayList<Book>found){
        //    mainActivity.saveRead(position,found);
        // }
        public void onClick (View view) {
            mainActivity.saveRead(getAdapterPosition(),foundBooks);

        }

    }
}
