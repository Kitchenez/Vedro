package ru.mirea.kuzenkov.weathercast.domain.model;

public class User {
    private String username;
    private String displayName;

    public User(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
    }

    // Геттеры
    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }
}
