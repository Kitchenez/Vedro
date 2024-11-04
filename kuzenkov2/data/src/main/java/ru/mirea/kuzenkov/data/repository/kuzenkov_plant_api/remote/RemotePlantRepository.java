package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.remote;

import java.util.Collections;
import java.util.List;

import kotlin.NotImplementedError;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class RemotePlantRepository implements IPlantRepository {
    @Override
    public PlantInfo GetPlantInfo(Integer plantId) {
        throw new NotImplementedError();
    }
    @Override
    public List<Integer> GetPlantList() {
        throw new NotImplementedError();
    }
}
