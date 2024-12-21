package ru.mirea.kuzenkov.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private final List<Country> countries;
    private Context context;

    public CountryRecyclerViewAdapter(List<Country> countries) {
        this.countries = countries;
    }
    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new CountryViewHolder(LayoutInflater.from(context).inflate(R.layout.country_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = this.countries.get(position);
        String pkgName = context.getPackageName();

//        var resID = context.getResources().getIdentifier(country.getFlagName() , "drawable", pkgName);
        holder.getFlagView().setImageResource(country.getFlagResource());
        holder.getCountryNameView().setText(country.getCountryName());
        holder.getPopulationView().setText("Population: " + country.getPopulation());
    }
    @Override
    public int getItemCount() {
        return this.countries.size();
    }
}
