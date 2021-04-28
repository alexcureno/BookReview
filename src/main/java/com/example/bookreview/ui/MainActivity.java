package com.example.bookreview.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bookreview.data.Api;
import com.example.bookreview.data.BooksCallback;
import com.example.bookreview.data.BooksRepository;
import com.example.bookreview.data.RetrofitInstance;
import com.example.bookreview.databinding.ActivityMainBinding;
import com.example.bookreview.domain.Books;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    BooksRepository booksRepository = new BooksRepository (RetrofitInstance.getRetrofitInstance().create(Api.class));
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BooksAdapter booksAdapter= new BooksAdapter();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setAdapter(booksAdapter);

        booksRepository.getBooks(new BooksCallback() {
            @Override
            public void onSuccess(List<Books> list) {
                booksAdapter.setItems(list);

            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}