package ru.mirea.kuzenkov.data.repository.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.mirea.kuzenkov.data.repository.room.dto.RoomPlantInfoDto;

@Dao
public interface RoomPlantInfoDao {
    @Query("SELECT * FROM plant_info")
    List<RoomPlantInfoDto> list();
    @Query("SELECT * FROM plant_info WHERE Title = :Title")
    RoomPlantInfoDto getByTitle(String Title);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RoomPlantInfoDto trackedLocationDto);
    @Update
    void update(RoomPlantInfoDto trackedLocationDto);
    @Delete
    void delete(RoomPlantInfoDto trackedLocationDto);
}
