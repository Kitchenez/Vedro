package ru.mirea.kuzenkov.weathercast.domain.repositories;

import java.util.List;
import ru.mirea.kuzenkov.weathercast.domain.model.User;

public interface UserRepository {
    User authenticate(String username, String password);
    boolean register(String username, String password);
    List<String> getFavoriteCities(String userId);
}
