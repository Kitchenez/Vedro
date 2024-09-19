package ru.mirea.kuzenkov.weathercast.domain.usecases;

import ru.mirea.kuzenkov.weathercast.data.repository.WeatherRepository;
import ru.mirea.kuzenkov.weathercast.domain.model.WeatherForecast;

public class GetWeatherForecastUseCase {

    private final WeatherRepository weatherRepository;

    public GetWeatherForecastUseCase(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherForecast execute(String cityName) {
        return weatherRepository.getWeather(cityName);
    }
}
