package ru.mirea.kuzenkov.PlantBook.domain.usecase.plant;

import ru.mirea.kuzenkov.PlantBook.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.PlantBook.domain.repository.IPlantRepository;

public class GetPlantInfo {
    private final IPlantRepository plantRepository;
    public GetPlantInfo(IPlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    public PlantInfo execute(int plantId) {
        return plantRepository.GetPlantInfo(plantId);
    }
}
