package ru.mirea.kuzenkov.weathercast.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kuzenkov.weathercast.R;

public class FavoriteCitiesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Получаем userId из SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String userId = prefs.getString("userId", null);

        if (userId == null) {
            // Пользователь не авторизован, показываем сообщение и завершаем активность
            Toast.makeText(this, "Please log in to view favorites", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_favorite_cities);

        if (savedInstanceState == null) {
            FavoriteCitiesFragment fragment = new FavoriteCitiesFragment();
            Bundle args = new Bundle();
            args.putString("userId", userId); // Используем userId из SharedPreferences
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow();
        }
    }
}
