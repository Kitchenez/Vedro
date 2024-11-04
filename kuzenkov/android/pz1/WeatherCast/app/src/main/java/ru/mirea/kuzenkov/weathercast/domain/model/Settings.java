package ru.mirea.kuzenkov.weathercast.domain.model;

public class Settings {
    private String language;
    private String theme;
    private String defaultCity;

    public Settings(String language, String theme, String defaultCity) {
        this.language = language;
        this.theme = theme;
        this.defaultCity = defaultCity;
    }

    // Геттеры
    public String getLanguage() {
        return language;
    }

    public String getTheme() {
        return theme;
    }

    public String getDefaultCity() {
        return defaultCity;
    }
}
