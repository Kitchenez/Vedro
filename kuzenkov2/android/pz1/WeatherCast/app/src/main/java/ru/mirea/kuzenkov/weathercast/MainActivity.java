package ru.mirea.kuzenkov.weathercast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kuzenkov.weathercast.databinding.ActivityHomeBinding;
import ru.mirea.kuzenkov.weathercast.domain.model.WeatherForecast;
import ru.mirea.kuzenkov.weathercast.domain.usecases.GetWeatherForecastUseCase;
import ru.mirea.kuzenkov.weathercast.domain.repositories.WeatherRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockWeatherRepository;
import ru.mirea.kuzenkov.weathercast.presentation.CityDetailActivity;
import ru.mirea.kuzenkov.weathercast.presentation.FavoriteCitiesActivity;
import ru.mirea.kuzenkov.weathercast.presentation.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private GetWeatherForecastUseCase getWeatherForecastUseCase;
    private String userId = null; // Изначально пользователь не авторизован

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Инициализируем Toolbar
        setSupportActionBar(binding.toolbar);

        // Получаем userId из SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        userId = prefs.getString("userId", null);

        // Инициализируем use-case
        WeatherRepository weatherRepository = new MockWeatherRepository();
        getWeatherForecastUseCase = new GetWeatherForecastUseCase(weatherRepository);

        // Получаем данные о погоде
        WeatherForecast forecast = getWeatherForecastUseCase.execute("Moscow");

        // Отображаем данные в UI
        binding.tvCityName.setText(forecast.getCityName());
        binding.includeWeatherSummary.tvWeatherCondition.setText(forecast.getCondition());
        binding.includeWeatherSummary.tvTemperature.setText(forecast.getTemperature() + "°C");

        // Обработчик кнопки "View Details"
        binding.btnViewDetails.setOnClickListener(v -> {
            Intent intent = new Intent(this, CityDetailActivity.class);
            intent.putExtra("cityName", forecast.getCityName());
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Обновляем userId при возврате в активность
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        userId = prefs.getString("userId", null);

        // Обновляем меню
        invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Если пользователь не авторизован, скрываем пункт меню "Favorites"
        menu.findItem(R.id.action_favorites).setVisible(userId != null);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // Переход в SettingsActivity
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivityForResult(intent, 1);
            return true;
        } else if (id == R.id.action_favorites) {
            if (userId != null) {
                // Если пользователь авторизован, открываем избранные города
                Intent intent = new Intent(this, FavoriteCitiesActivity.class);
                startActivity(intent);
            } else {
                // Если нет, показываем сообщение
                Toast.makeText(this, "Please log in to view favorites", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Получаем результат из SettingsActivity (например, после авторизации)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            userId = data.getStringExtra("userId");
            // Обновляем меню
            invalidateOptionsMenu();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
