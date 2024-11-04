package ru.mirea.kuzenkov.PlantBook.domain.repository;

public interface IPlantRecognizer {
    Integer RecognizePlant(byte[] photo);
}
