package ru.mirea.kuzenkov.domain.repository;

import java.util.List;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;

public interface IPlantRepository {
    PlantInfo GetPlantInfo(Integer plantId);
    List<Integer> GetPlantList();
}
