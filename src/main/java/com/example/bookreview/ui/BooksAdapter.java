package com.example.bookreview.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookreview.databinding.BooksBinding;
import com.example.bookreview.domain.Books;

import java.util.ArrayList;
import java.util.List;


public class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {

    private List<Books> items = new ArrayList<>();

    public void setItems(List<Books> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksViewHolder(BooksBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.decorateWith(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
