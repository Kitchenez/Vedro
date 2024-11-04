package ru.mirea.kuzenkov.domain.usecase.plant;

import ru.mirea.kuzenkov.domain.repository.IPlantRecognizer;

public class RecognizePlant {
    private final IPlantRecognizer plantRecognizer;
    public RecognizePlant(IPlantRecognizer plantRecognizer) {
        this.plantRecognizer = plantRecognizer;
    }
    Integer execute(byte[] photo) {
        return plantRecognizer.RecognizePlant(photo);
    }
}
