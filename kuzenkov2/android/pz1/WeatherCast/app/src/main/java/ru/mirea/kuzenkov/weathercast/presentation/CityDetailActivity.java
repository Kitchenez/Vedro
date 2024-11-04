package ru.mirea.kuzenkov.weathercast.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kuzenkov.weathercast.R;
import ru.mirea.kuzenkov.weathercast.domain.model.WeatherForecast;
import ru.mirea.kuzenkov.weathercast.domain.usecases.GetWeatherForecastUseCase;
import ru.mirea.kuzenkov.weathercast.domain.repositories.WeatherRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockWeatherRepository;

public class CityDetailActivity extends AppCompatActivity {

    private GetWeatherForecastUseCase getWeatherForecastUseCase;
    private String cityName;
    private WeatherForecast forecast;
    private String userId; // Добавляем поле userId

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        // Инициализируем Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        // Получаем название города из интента
        cityName = getIntent().getStringExtra("cityName");

        // Получаем userId из SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        userId = prefs.getString("userId", null);

        // Инициализируем use-case
        WeatherRepository weatherRepository = new MockWeatherRepository();
        getWeatherForecastUseCase = new GetWeatherForecastUseCase(weatherRepository);

        // Получаем подробную информацию о погоде
        forecast = getWeatherForecastUseCase.execute(cityName);

        // Отображаем информацию в UI
        TextView tvCityName = findViewById(R.id.tvCityName);
        TextView tvCondition = findViewById(R.id.tvCondition);
        TextView tvTemperature = findViewById(R.id.tvTemperature);

        tvCityName.setText(forecast.getCityName());
        tvCondition.setText(forecast.getCondition());
        tvTemperature.setText(forecast.getTemperature() + "°C");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.city_options_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Если пользователь не авторизован, скрываем пункты меню
        if (userId == null) {
            menu.findItem(R.id.action_add_to_favorites).setVisible(false);
            menu.findItem(R.id.action_remove_from_favorites).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_to_favorites) {
            // Проверяем, авторизован ли пользователь
            if (userId != null) {
                // Логика добавления города в избранное
                Toast.makeText(this, cityName + " added to favorites", Toast.LENGTH_SHORT).show();
            } else {
                // Просим пользователя авторизоваться
                Toast.makeText(this, "Please log in to add favorites", Toast.LENGTH_SHORT).show();
                // Можно перенаправить пользователя на экран авторизации, если это необходимо
            }
            return true;
        } else if (id == R.id.action_remove_from_favorites) {
            if (userId != null) {
                // Логика удаления города из избранного
                Toast.makeText(this, cityName + " removed from favorites", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please log in to remove favorites", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
