package com.example.bookreview.ui;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bookreview.R;
import com.example.bookreview.databinding.BooksBinding;
import com.example.bookreview.domain.Books;

import com.bumptech.glide.Glide;


class BooksViewHolder extends RecyclerView.ViewHolder {

    public BooksBinding booksBinding;

    public BooksViewHolder(BooksBinding binding) {
        super(binding.getRoot());
        booksBinding = binding;
    }

    @SuppressLint("StringFormatMatches")
    public void decorateWith(Books model) {
        Glide.with(itemView.getContext()).load(model.url).centerCrop().into(booksBinding.ivPortada);
        booksBinding.title.setText(model.name);
        booksBinding.BookEditorial.setText(itemView.getContext().getString(R.string.label_publishingHouse, model.publishingHouse));
        booksBinding.BookAuthor.setText(itemView.getContext().getString(R.string.label_BookAuthor, model.author));
        booksBinding.BookPages.setText(itemView.getContext().getString(R.string.label_pages, model.pages));

        if (model.bestSeller) {
            booksBinding.BestSeller.setVisibility(View.VISIBLE);
        } else {
            booksBinding.BestSeller.setVisibility(View.INVISIBLE);
        }
    }

}
