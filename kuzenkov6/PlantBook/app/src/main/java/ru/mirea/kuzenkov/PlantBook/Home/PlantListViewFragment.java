package ru.mirea.kuzenkov.PlantBook.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.kuzenkov.PlantBook.PlantInfoList.PlantInfoListViewAdapter;
import ru.mirea.kuzenkov.PlantBook.PlantInfoList.PlantInfoListViewModel;
import ru.mirea.kuzenkov.PlantBook.databinding.FragmentPlantListViewBinding;


public class PlantListViewFragment extends Fragment {
    private PlantInfoListViewAdapter.ItemClickedListener listener = null;
    public void SetItemClickedListener(PlantInfoListViewAdapter.ItemClickedListener listener) {
        this.listener = listener;
    }

    private FragmentPlantListViewBinding binding = null;
    private PlantInfoListViewModel vm = null;
    public PlantListViewFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlantListViewBinding.inflate(inflater, container, false);
        binding.itemsListView.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("!!!!", "Activity: " + requireActivity());
        var vm = new ViewModelProvider(requireActivity()).get(PlantInfoListViewModel.class);
        Log.d("!!!!", "VM: " + vm);
        vm.getPlantInfoList().observe(getViewLifecycleOwner(), plantInfos -> {
            var adapter = new PlantInfoListViewAdapter(getContext(), vm.getPlantInfoList().getValue());
            binding.itemsListView.setAdapter(adapter);
            adapter.SetItemClickedListener(info -> {
                if(listener != null) {
                    listener.onClick(info);
                }
            });
            Log.i("!!!!", "DATA MVVM CHANGED");
        });
    }
}