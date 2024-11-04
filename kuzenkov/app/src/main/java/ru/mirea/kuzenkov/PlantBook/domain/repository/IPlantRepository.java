package ru.mirea.kuzenkov.PlantBook.domain.repository;

import java.util.List;

import ru.mirea.kuzenkov.PlantBook.domain.dto.PlantInfo;

public interface IPlantRepository {
    PlantInfo GetPlantInfo(Integer plantId);
    List<Integer> GetPlantList();
}
