package ru.mirea.kuzenkov.fragmentmanagerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mirea.kuzenkov.fragmentmanagerapp.databinding.FragmentInfoBinding;


public class InfoFragment extends Fragment {
    private FragmentInfoBinding binding = null;
    public InfoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null) {
            binding.descriptionView.setText(requireArguments().getString("description"));
            binding.titleView.setText(requireArguments().getString("title"));
        }
    }
}