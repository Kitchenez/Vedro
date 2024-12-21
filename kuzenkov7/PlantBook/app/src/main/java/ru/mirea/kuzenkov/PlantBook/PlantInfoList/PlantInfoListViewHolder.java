package ru.mirea.kuzenkov.PlantBook.PlantInfoList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.kuzenkov.PlantBook.R;

public class PlantInfoListViewHolder extends RecyclerView.ViewHolder {
    public interface ItemClickListener {
        void onClick(View view, int position);
    }
    private ItemClickListener listener = null;
    public void SetItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    ImageView iconView;
    TextView titleTextView;
    public PlantInfoListViewHolder(@NonNull View itemView) {
        super(itemView);
        iconView = itemView.findViewById(R.id.icon_view);
        titleTextView = itemView.findViewById(R.id.title_text);
        itemView.setOnClickListener(v -> {
            if(listener != null) {
                listener.onClick(itemView, getAdapterPosition());
            }
        });
    }
}