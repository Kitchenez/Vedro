package ru.mirea.kuzenkov.data.repository.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class MockPlantRepository implements IPlantRepository {
    private final Map<Integer, PlantInfo> Plants = new HashMap<>();
    public MockPlantRepository() {
        Plants.put(1, new PlantInfo("t-1", "d-1"));
        Plants.put(2, new PlantInfo("t-2", "d-2"));
        Plants.put(3, new PlantInfo("t-3", "d-3"));
        Plants.put(4, new PlantInfo("t-4", "d-4"));
    }

    @Override
    public PlantInfo GetPlantInfo(Integer plantId) {
        return Plants.get(plantId);
    }
    @Override
    public List<Integer> GetPlantList() {
        return new ArrayList<>(Plants.keySet());
    }
}
