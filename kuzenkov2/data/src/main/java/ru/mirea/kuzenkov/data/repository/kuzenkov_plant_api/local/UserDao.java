package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserEntity user);

    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    UserEntity getUser(String email);
}
