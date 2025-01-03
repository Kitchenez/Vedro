package ru.mirea.kuzenkov.PlantBook.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import ru.mirea.kuzenkov.PlantBook.R;
import ru.mirea.kuzenkov.PlantBook.databinding.FragmentPlantInfoViewBinding;


public class PlantInfoViewFragment extends Fragment {
    private FragmentPlantInfoViewBinding binding = null;
    public PlantInfoViewFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlantInfoViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null) {

            Picasso.get()
                    .load(requireArguments().getString("icon_uri"))
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .fit().into(binding.iconView);
            binding.titleText.setText(requireArguments().getString("title"));
            binding.descriptionText.setText(requireArguments().getString("description"));
        }
    }
}
