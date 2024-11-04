package ru.mirea.kuzenkov.PlantBook.domain.usecase.plant;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IPlantRecognizer;

public class RecognizePlant {
    private final IPlantRecognizer plantRecognizer;
    public RecognizePlant(IPlantRecognizer plantRecognizer) {
        this.plantRecognizer = plantRecognizer;
    }
    Integer execute(byte[] photo) {
        return plantRecognizer.RecognizePlant(photo);
    }
}
