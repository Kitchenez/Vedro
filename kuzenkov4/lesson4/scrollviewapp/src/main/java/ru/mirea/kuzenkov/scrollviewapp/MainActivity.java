package ru.mirea.kuzenkov.scrollviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.kuzenkov.scrollviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for (int i = 0; i < 100; i++){
            View view = getLayoutInflater().inflate(R.layout.item, null, false);
            ((TextView)view.findViewById(R.id.textView)).setText(String.format("Element %d", i));
            binding.wrapper.addView(view);
        }
    }
}