package ru.mirea.kuzenkov.PlantBook.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.kuzenkov.PlantBook.R;
import ru.mirea.kuzenkov.PlantBook.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding = null;
    public HomeFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        var trackedLocationsListFragment = new PlantListViewFragment();
        trackedLocationsListFragment.SetItemClickedListener(info -> {
            var bundle = new Bundle();
            bundle.putString("icon_uri", info.getImageUri());
            bundle.putString("title", info.getTitle());
            bundle.putString("description", info.getDescription());
            Navigation.findNavController(requireView()).navigate(R.id.navigation_short_info, bundle);
        });
        getParentFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, trackedLocationsListFragment)
                .commit();
    }
}