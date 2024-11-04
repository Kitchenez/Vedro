package ru.mirea.kuzenkov.PlantBook;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Date;
import java.util.List;
import ru.mirea.kuzenkov.data.repository.firebase.FirebaseAccountRepository;
import ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local.LocalBookmarkRepository;
import ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local.LocalPlantRepository;
import ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.remote.GuestBookmarkRepository;
import ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.remote.RemotePlantRepository;
import ru.mirea.kuzenkov.data.repository.network.NetworkApi;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IAccountRepository;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class MainActivity extends AppCompatActivity {

    private TextView plantInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        plantInfoTextView = findViewById(R.id.plant_info_textview);


        IBookmarkRepository bookmarkRepository = new LocalBookmarkRepository(new GuestBookmarkRepository(), new Date());
        IPlantRepository plantRepository = new LocalPlantRepository(new RemotePlantRepository(), new Date());
        IAccountRepository accountRepository = new FirebaseAccountRepository();


        loadPlantInfo();
    }

    private void loadPlantInfo() {
        NetworkApi networkApi = new NetworkApi();
        List<PlantInfo> plantInfoList = networkApi.fetchMockedPlantData();


        StringBuilder plantInfoString = new StringBuilder();
        for (PlantInfo plantInfo : plantInfoList) {
            plantInfoString.append("Title: ").append(plantInfo.getTitle()).append("\n")
                    .append("Description: ").append(plantInfo.getDescription()).append("\n\n");
        }


        plantInfoTextView.setText(plantInfoString.toString());
    }
}
