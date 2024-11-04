package ru.mirea.kuzenkov.weathercast.domain.model;

public class WeatherForecast {
    private String cityName;
    private String condition;
    private int temperature;

    public WeatherForecast(String cityName, String condition, int temperature) {
        this.cityName = cityName;
        this.condition = condition;
        this.temperature = temperature;
    }

    // Геттеры
    public String getCityName() {
        return cityName;
    }

    public String getCondition() {
        return condition;
    }

    public int getTemperature() {
        return temperature;
    }
}
