package ru.mirea.kuzenkov.weathercast.data.repository;

import ru.mirea.kuzenkov.weathercast.domain.model.Settings;

public interface SettingsRepository {
    Settings getSettings();
    void saveSettings(Settings settings);
}
