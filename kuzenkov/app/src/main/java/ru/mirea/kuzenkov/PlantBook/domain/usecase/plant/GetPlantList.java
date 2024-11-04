package ru.mirea.kuzenkov.PlantBook.domain.usecase.plant;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.kuzenkov.PlantBook.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.PlantBook.domain.repository.IPlantRepository;

public class GetPlantList {
    private final IPlantRepository plantRepository;
    public GetPlantList(IPlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    public List<PlantInfo> execute() {
        List<PlantInfo> result = new ArrayList<PlantInfo>();
        for(Integer plantId: plantRepository.GetPlantList()) {
            result.add(plantRepository.GetPlantInfo(plantId));
        }
        return result;
    }
}
