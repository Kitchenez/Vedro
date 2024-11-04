package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local;

import android.content.Context;
import androidx.room.Room;

public class UserRepository {
    private final UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "app_database").build();
        userDao = db.userDao();
    }

    public void insertUser(UserEntity user) {
        new Thread(() -> userDao.insertUser(user)).start();
    }

    public UserEntity getUser(String email) {
        return userDao.getUser(email);
    }
}
