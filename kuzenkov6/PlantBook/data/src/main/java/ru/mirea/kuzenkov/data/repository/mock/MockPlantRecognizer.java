package ru.mirea.kuzenkov.data.repository.mock;

import ru.mirea.kuzenkov.domain.repository.IPlantRecognizer;

public class MockPlantRecognizer implements IPlantRecognizer {
    @Override
    public String RecognizePlant(byte[] photo) {
        return null;
    }
}
