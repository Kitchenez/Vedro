package ru.mirea.kuzenkov.weathercast.data.repository.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;
import ru.mirea.kuzenkov.weathercast.domain.model.User;

public class MockUserRepository implements UserRepository {

    private static MockUserRepository instance;

    private Map<String, String> users = new HashMap<>();

    private MockUserRepository() {
        // Изначально добавляем тестового пользователя
        users.put("testuser", "password");
    }

    public static MockUserRepository getInstance() {
        if (instance == null) {
            instance = new MockUserRepository();
        }
        return instance;
    }

    @Override
    public User authenticate(String username, String password) {
        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return new User(username, "DisplayName");
        }
        return null;
    }

    @Override
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            // Пользователь с таким именем уже существует
            return false;
        } else {
            users.put(username, password);
            return true;
        }
    }

    @Override
    public List<String> getFavoriteCities(String userId) {
        // Возвращаем тестовый список избранных городов
        return Arrays.asList("Moscow", "London", "New York");
    }
}
