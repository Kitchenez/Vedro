package ru.mirea.kuzenkov.weathercast.domain.usecases;

import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;
import ru.mirea.kuzenkov.weathercast.domain.model.User;

public class AuthenticateUserUseCase {

    private final UserRepository userRepository;

    public AuthenticateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String username, String password) {
        return userRepository.authenticate(username, password);
    }
}
