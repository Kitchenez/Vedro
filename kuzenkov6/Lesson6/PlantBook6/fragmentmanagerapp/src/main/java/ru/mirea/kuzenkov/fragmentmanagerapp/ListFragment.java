package ru.mirea.kuzenkov.fragmentmanagerapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

import ru.mirea.kuzenkov.fragmentmanagerapp.databinding.FragmentListBinding;

public class ListFragment extends Fragment {
    public interface ICountryListener {
        void CountrySelected(String title);
    }

    private FragmentListBinding binding = null;
    private ArrayList<String> countries = null;
    private ICountryListener listener = null;
    public ListFragment() {}

    public void SetCountryListener(ICountryListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("!!!!!", "Value: " + getArguments());

        countries = requireArguments().getStringArrayList("titles");
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_2, android.R.id.text1, countries) {
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
        binding.countryListView.setOnItemClickListener((parent, v, position, id) -> {
            Log.d("!!!!", "Item selected: " + position);
            if(listener != null) {
                listener.CountrySelected(countries.get(position));
            }
        });
        binding.countryListView.setAdapter(adapter);
    }
}