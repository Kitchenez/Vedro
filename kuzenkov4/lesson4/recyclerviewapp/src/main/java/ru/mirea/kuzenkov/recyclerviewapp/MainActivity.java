package ru.mirea.kuzenkov.recyclerviewapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.kuzenkov.recyclerviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    protected ActivityMainBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new CountryRecyclerViewAdapter(getCountriesInfo()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private static List<Country> getCountriesInfo() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("Brazil", R.drawable.flag_of_brazil, 210000000));
        list.add(new Country("China", R.drawable.flag_of_china, 1420000000));
        list.add(new Country("India", R.drawable.flag_of_india, 1430000000));
        list.add(new Country("Russia", R.drawable.flag_of_russia, 146000000));
        list.add(new Country("South Africa", R.drawable.flag_of_south_africa, 64000000 ));
        return list;
    }
}