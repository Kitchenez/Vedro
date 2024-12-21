package ru.mirea.kuzenkov.data.repository.room;

import android.util.Log;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import ru.mirea.kuzenkov.data.repository.room.dao.RoomPlantInfoDao;
import ru.mirea.kuzenkov.data.repository.room.dto.RoomPlantInfoDto;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class RoomPlantRepository implements IPlantRepository {
    private final IPlantRepository plantRepositoryOrigin;
    private final RoomPlantInfoDao roomPlantInfoDao;
    public RoomPlantRepository(IPlantRepository plantRepositoryOrigin, RoomPlantInfoDao roomPlantInfoDao) {
        this.plantRepositoryOrigin = plantRepositoryOrigin;
        this.roomPlantInfoDao = roomPlantInfoDao;
    }

    @Override
    public PlantInfo GetPlantInfo(String title) {
        return getCurrentInfo(title);
    }
    @Override
    public Set<String> GetPlantList() {
        var remotePlants = plantRepositoryOrigin.GetPlantList();
        if(remotePlants != null && !remotePlants.isEmpty()) {
            return remotePlants;
        }
        return roomPlantInfoDao.list().stream().map(info -> info.Title).collect(Collectors.toSet());
    }
    private PlantInfo setLocalInfo(PlantInfo info) {
        var newInfo = new RoomPlantInfoDto();
        newInfo.Title = info.getTitle();
        newInfo.ImageUri = info.getImageUri();
        newInfo.Description = info.getDescription();
        roomPlantInfoDao.insert(newInfo);
        return getCurrentInfo(info.getTitle());
    }
    private PlantInfo getCurrentInfo(String title) {
        var localInfo = roomPlantInfoDao.getByTitle(title);
        if(localInfo != null) {
            return new PlantInfo(localInfo.Title, localInfo.ImageUri, localInfo.Description);
        }

        var remoteInfo = plantRepositoryOrigin.GetPlantInfo(title);
        Log.i("!!!!", String.valueOf(remoteInfo != null));
        Log.i("!!!!", remoteInfo.toString());
        Log.i("!!!!", String.valueOf(remoteInfo.getTitle() != null));
        Log.i("!!!!", String.valueOf(remoteInfo.getDescription() != null));
        if(remoteInfo != null) {
            return setLocalInfo(remoteInfo);
        }

        return null;
    }
}
