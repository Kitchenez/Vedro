package ru.mirea.kuzenkov.weathercast.domain.repositories;

import ru.mirea.kuzenkov.weathercast.domain.model.WeatherForecast;

public interface WeatherRepository {
    WeatherForecast getWeather(String cityName);
}