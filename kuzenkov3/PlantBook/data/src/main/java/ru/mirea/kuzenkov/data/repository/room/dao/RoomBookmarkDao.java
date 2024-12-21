package ru.mirea.kuzenkov.data.repository.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.mirea.kuzenkov.data.repository.room.dto.RoomBookmarkDto;

@Dao
public interface RoomBookmarkDao {
    @Query("SELECT * FROM plant_bookmark")
    List<RoomBookmarkDto> list();
    @Insert
    void insert(RoomBookmarkDto roomBookmarkDto);
    @Delete
    void delete(RoomBookmarkDto roomBookmarkDto);
}
