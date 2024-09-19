package ru.mirea.kuzenkov.weathercast.data.repository.mock;

import ru.mirea.kuzenkov.weathercast.data.repository.SettingsRepository;
import ru.mirea.kuzenkov.weathercast.domain.model.Settings;

public class MockSettingsRepository implements SettingsRepository {

    @Override
    public Settings getSettings() {
        // Тестовые данные настроек
        return new Settings("English", "Light", "Moscow");
    }

    @Override
    public void saveSettings(Settings settings) {
        // Фиктивная логика сохранения
        System.out.println("Settings saved: Language = " + settings.getLanguage() + ", Theme = " + settings.getTheme());
    }
}
