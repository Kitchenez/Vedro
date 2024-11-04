package ru.mirea.kuzenkov.domain.repository;

public interface IPlantRecognizer {
    Integer RecognizePlant(byte[] photo);
}
