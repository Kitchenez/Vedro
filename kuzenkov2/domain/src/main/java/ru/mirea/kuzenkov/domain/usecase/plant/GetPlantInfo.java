package ru.mirea.kuzenkov.domain.usecase.plant;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class GetPlantInfo {
    private final IPlantRepository plantRepository;
    public GetPlantInfo(IPlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    public PlantInfo execute(int plantId) {
        return plantRepository.GetPlantInfo(plantId);
    }
}
