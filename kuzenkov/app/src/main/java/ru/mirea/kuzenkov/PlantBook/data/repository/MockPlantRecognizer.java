package ru.mirea.kuzenkov.PlantBook.data.repository;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IPlantRecognizer;

public class MockPlantRecognizer implements IPlantRecognizer {
    @Override
    public Integer RecognizePlant(byte[] photo) {
        return -1;
    }
}
