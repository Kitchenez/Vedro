package ru.mirea.kuzenkov.weathercast.domain.usecases;

import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;

public class RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(String username, String password) {
        return userRepository.register(username, password);
    }
}
