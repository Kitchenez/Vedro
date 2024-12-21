package ru.mirea.kuzenkov.data.repository.room.dto;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "plant_bookmark", primaryKeys = { "Title" })
public class RoomBookmarkDto {
    @NonNull public String Title;
}
