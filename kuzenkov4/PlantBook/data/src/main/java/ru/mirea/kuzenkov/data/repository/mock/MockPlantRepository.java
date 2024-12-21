package ru.mirea.kuzenkov.data.repository.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class MockPlantRepository implements IPlantRepository {
    private final Map<String, PlantInfo> Plants = new HashMap<>();
    public MockPlantRepository() {
        Plants.put("111", new PlantInfo("111", "", "qqq"));
        Plants.put("222", new PlantInfo("222", "", "www"));
        Plants.put("333", new PlantInfo("333", "", "eee"));
    }

    @Override
    public PlantInfo GetPlantInfo(String title) {
        return Plants.get(title);
    }

    @Override
    public Set<String> GetPlantList() {
        return Plants.keySet();
    }
}
