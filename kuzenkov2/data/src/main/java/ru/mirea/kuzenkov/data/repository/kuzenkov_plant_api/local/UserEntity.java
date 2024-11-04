package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey
    @NonNull
    public String email;

    public String name;
}
