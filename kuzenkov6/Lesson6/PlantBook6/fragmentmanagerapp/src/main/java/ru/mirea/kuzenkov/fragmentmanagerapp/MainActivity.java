package ru.mirea.kuzenkov.fragmentmanagerapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.mirea.kuzenkov.fragmentmanagerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ListFragment.ICountryListener {
    private Map<String, String> Countries = new HashMap<>();
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Countries.put("1", "some-description-1");
        Countries.put("2", "some-description-2");
        Countries.put("3", "some-description-3");
        Countries.put("4", "some-description-4");
        Countries.put("5", "some-description-5");

        Log.d("!!!!!", "savedInstanceState: " + savedInstanceState);
        if(savedInstanceState == null) {
            Bundle options = new Bundle();
            options.putStringArrayList("titles", new ArrayList<>(Countries.keySet()));
            ListFragment countries = new ListFragment();
            countries.SetCountryListener(this);
            countries.setArguments(options);

            getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, countries)
                .commit();
        }
    }
    @Override
    public void CountrySelected(String title) {
        if(!Countries.containsKey(title))
            return;

        Bundle options = new Bundle();
        options.putString("title", title);
        options.putString("description", Countries.get(title));
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, InfoFragment.class, options)
                .commit();
    }
}