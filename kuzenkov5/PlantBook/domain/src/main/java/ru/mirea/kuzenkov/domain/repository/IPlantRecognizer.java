package ru.mirea.kuzenkov.domain.repository;

public interface IPlantRecognizer {
    String RecognizePlant(byte[] photo);
}
