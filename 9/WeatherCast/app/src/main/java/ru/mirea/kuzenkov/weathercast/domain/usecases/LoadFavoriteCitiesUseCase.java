package ru.mirea.kuzenkov.weathercast.domain.usecases;

import java.util.List;
import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;

public class LoadFavoriteCitiesUseCase {

    private final UserRepository userRepository;

    public LoadFavoriteCitiesUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> execute(String userId) {
        return userRepository.getFavoriteCities(userId);
    }
}
