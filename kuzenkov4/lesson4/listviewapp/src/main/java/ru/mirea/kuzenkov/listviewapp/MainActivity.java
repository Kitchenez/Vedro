package ru.mirea.kuzenkov.listviewapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import ru.mirea.kuzenkov.listviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String[] countries = { "Россия", "Бразилия", "Китай", "Индия", "ЮАР", "Иран", "Египет", "ОАЭ"};
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        var adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, countries) {
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                text2.setText(Objects.requireNonNull(getItem(position)).toString());
                text1.setText(String.valueOf(position + 1));
                return view;
            }
        };
        binding.countryListView.setAdapter(adapter);
    }
}