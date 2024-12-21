package ru.mirea.kuzenkov.domain.repository;

import java.util.List;
import java.util.Set;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;

public interface IPlantRepository {
    PlantInfo GetPlantInfo(String title);
    Set<String> GetPlantList();
}
