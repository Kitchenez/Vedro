package ru.mirea.kuzenkov.data.repository.network;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;

public class NetworkApi {

    public List<PlantInfo> fetchMockedPlantData() {
        List<PlantInfo> plants = new ArrayList<>();
        plants.add(new PlantInfo("Rose", "A beautiful flower"));
        plants.add(new PlantInfo("Sunflower", "A tall yellow flower"));
        return plants;
    }
}
