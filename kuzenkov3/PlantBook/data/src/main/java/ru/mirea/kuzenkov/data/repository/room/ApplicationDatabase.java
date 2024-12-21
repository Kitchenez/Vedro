package ru.mirea.kuzenkov.data.repository.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.kuzenkov.data.repository.room.dao.RoomBookmarkDao;
import ru.mirea.kuzenkov.data.repository.room.dao.RoomPlantInfoDao;
import ru.mirea.kuzenkov.data.repository.room.dto.RoomBookmarkDto;
import ru.mirea.kuzenkov.data.repository.room.dto.RoomPlantInfoDto;

@Database(entities = { RoomBookmarkDto.class, RoomPlantInfoDto.class }, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    public abstract RoomPlantInfoDao roomPlantInfoDao();
    public abstract RoomBookmarkDao roomBookmarkDao();
}
