package ru.mirea.kuzenkov.data.repository.tensorflow;

import kotlin.NotImplementedError;
import ru.mirea.kuzenkov.domain.repository.IPlantRecognizer;

public class TensorflowPlantRecognizer implements IPlantRecognizer {
    @Override
    public Integer RecognizePlant(byte[] photo) {
        throw new NotImplementedError();
    }
}
