package com.example.bookreview.data;

import com.example.bookreview.domain.Books;

import java.util.List;

public interface BooksCallback {
    void onSuccess(List<Books> list);

    void onError(String errorMessage);


}