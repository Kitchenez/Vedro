package ru.mirea.kuzenkov.weathercast.domain.usecases;

import ru.mirea.kuzenkov.weathercast.domain.repositories.SettingsRepository;
import ru.mirea.kuzenkov.weathercast.domain.model.Settings;

public class SaveSettingsUseCase {

    private final SettingsRepository settingsRepository;

    public SaveSettingsUseCase(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public void execute(Settings settings) {
        settingsRepository.saveSettings(settings);
    }
}