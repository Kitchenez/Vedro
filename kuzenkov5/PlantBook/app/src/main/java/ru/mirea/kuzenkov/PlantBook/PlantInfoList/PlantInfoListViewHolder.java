package ru.mirea.kuzenkov.PlantBook.PlantInfoList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.kuzenkov.PlantBook.R;

public class PlantInfoListViewHolder extends RecyclerView.ViewHolder {
    ImageView iconView;
    TextView titleTextView;
    public PlantInfoListViewHolder(@NonNull View itemView) {
        super(itemView);
        iconView = itemView.findViewById(R.id.icon_view);
        titleTextView = itemView.findViewById(R.id.title_text);
    }
}