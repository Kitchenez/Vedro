package ru.mirea.kuzenkov.weathercast.domain.usecases;

import java.util.List;
import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;

public class SaveFavoriteCityUseCase {

    private final UserRepository userRepository;

    public SaveFavoriteCityUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String userId, List<String> favoriteCities) {
        // Здесь можно реализовать сохранение городов
        System.out.println("Saved favorite cities: " + favoriteCities);
    }
}
