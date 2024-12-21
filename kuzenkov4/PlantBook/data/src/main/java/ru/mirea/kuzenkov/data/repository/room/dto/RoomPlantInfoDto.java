package ru.mirea.kuzenkov.data.repository.room.dto;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "plant_info", primaryKeys = { "Title" })
public class RoomPlantInfoDto {
    @NonNull public String Title;
    public String ImageUri;
    public String Description;
}
