package ru.mirea.kuzenkov.weathercast.data.repository.mock;

import ru.mirea.kuzenkov.weathercast.domain.repositories.WeatherRepository;
import ru.mirea.kuzenkov.weathercast.domain.model.WeatherForecast;

public class MockWeatherRepository implements WeatherRepository {

    @Override
    public WeatherForecast getWeather(String cityName) {
        // Пример тестовых данных
        switch (cityName.toLowerCase()) {
            case "moscow":
                return new WeatherForecast(cityName, "Cloudy", 12);
            case "new york":
                return new WeatherForecast(cityName, "Sunny", 25);
            default:
                return new WeatherForecast(cityName, "Unknown", 0);
        }
    }
}
