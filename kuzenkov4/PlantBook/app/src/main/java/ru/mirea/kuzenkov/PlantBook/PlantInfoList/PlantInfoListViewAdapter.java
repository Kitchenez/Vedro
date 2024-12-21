package ru.mirea.kuzenkov.PlantBook.PlantInfoList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import ru.mirea.kuzenkov.PlantBook.R;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;

public class PlantInfoListViewAdapter extends RecyclerView.Adapter<PlantInfoListViewHolder> {
    private final List<PlantInfo> plantInfos;
    private final LayoutInflater layoutInflater;
    public PlantInfoListViewAdapter(Context context, List<PlantInfo> plantInfos) {
        layoutInflater = LayoutInflater.from(context);
        this.plantInfos = plantInfos;
    }


    @NonNull
    @Override
    public PlantInfoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.plant_list_item, parent, false);
        return new PlantInfoListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PlantInfoListViewHolder holder, int position) {
        var info = plantInfos.get(position);

        Picasso.get()
            .load(info.getImageUri())
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .fit().into(holder.iconView);
        holder.titleTextView.setText(info.getTitle());
    }
    @Override
    public int getItemCount() {
        return plantInfos.size();
    }
}
