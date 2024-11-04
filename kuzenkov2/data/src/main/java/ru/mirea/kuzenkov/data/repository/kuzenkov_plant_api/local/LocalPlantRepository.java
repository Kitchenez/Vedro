package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kotlin.NotImplementedError;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class LocalPlantRepository implements IPlantRepository {
    private final Map<Integer, PlantInfo> Plants = new HashMap<>();
    private final IPlantRepository Origin;
    private Date LastSyncTime;

    public LocalPlantRepository(IPlantRepository origin, Date lastSyncTime) {
        LastSyncTime = lastSyncTime;
        Origin = origin;

        SyncWithOrigin();
    }
    private void SyncWithOrigin() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(LastSyncTime);
        cal.add(Calendar.HOUR_OF_DAY, 24);
        cal.getTime();
        if(cal.getTime().after(new Date())) {
            return;
        }

        for(Integer plantId: Origin.GetPlantList()) {
            Plants.put(plantId, Origin.GetPlantInfo(plantId));
        }
        Plants.clear();
        LastSyncTime = new Date();
    }

    @Override
    public PlantInfo GetPlantInfo(Integer plantId) {
        throw new NotImplementedError();
    }
    @Override
    public List<Integer> GetPlantList() {
        throw new NotImplementedError();
    }
}
