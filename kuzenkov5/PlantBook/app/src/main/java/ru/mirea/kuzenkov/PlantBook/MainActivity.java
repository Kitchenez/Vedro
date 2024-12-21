package ru.mirea.kuzenkov.PlantBook;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import ru.mirea.kuzenkov.PlantBook.PlantInfoList.PlantInfoListViewAdapter;
import ru.mirea.kuzenkov.PlantBook.PlantInfoList.PlantInfoListViewModel;
import ru.mirea.kuzenkov.PlantBook.PlantInfoList.PlantInfoListViewModelFactory;
import ru.mirea.kuzenkov.PlantBook.databinding.ActivityMainBinding;
import ru.mirea.kuzenkov.PlantBook.login.LoginActivity;
import ru.mirea.kuzenkov.data.repository.firebase.FirebaseAuthorizationService;
import ru.mirea.kuzenkov.data.repository.network.TreflePlantRepository;
import ru.mirea.kuzenkov.data.repository.room.RoomBookmarkRepository;
import ru.mirea.kuzenkov.data.repository.room.RoomPlantRepository;
import ru.mirea.kuzenkov.domain.repository.IAuthorizationService;

public class MainActivity extends AppCompatActivity {
    private static final String TREFLE_API_KEY = "rX0vAfgiy2rg8x7rNzciShfIpZZWc5E5vPBHwh22VKw";
    private PlantInfoListViewModel vm = null;
    private IAuthorizationService auth = null;
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.logOutButton.setOnClickListener(v -> OnLogOutButtonClicked());
        setContentView(binding.getRoot());

        auth = new FirebaseAuthorizationService(FirebaseAuth.getInstance());
        var database = PlantBookApplication.getInstance().getDatabase();

        var plantRepository = new RoomPlantRepository(new TreflePlantRepository(TREFLE_API_KEY), database.roomPlantInfoDao());
        var bookmarkRepository = new RoomBookmarkRepository(database.roomBookmarkDao());

        vm = new ViewModelProvider(this, new PlantInfoListViewModelFactory(bookmarkRepository, plantRepository)).get(PlantInfoListViewModel.class);
        vm.getPlantInfoList().observe(this, PlantInfos -> {
            binding.recyclerView.setAdapter(new PlantInfoListViewAdapter(MainActivity.this, PlantInfos));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        CheckIsUserAuthorized();
    }

    private void CheckIsUserAuthorized() {
        if(auth.GetUserStatus() == IAuthorizationService.UserStatus.None) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void OnLogOutButtonClicked() {
        auth.LogOut();
        CheckIsUserAuthorized();
    }
}