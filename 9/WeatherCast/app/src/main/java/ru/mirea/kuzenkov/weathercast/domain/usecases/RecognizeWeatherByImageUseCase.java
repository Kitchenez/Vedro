package ru.mirea.kuzenkov.weathercast.domain.usecases;

public class RecognizeWeatherByImageUseCase {

    public String execute(byte[] imageBytes) {
        // Здесь должна быть логика для TensorFlow Lite, но пока возвращаем тестовые данные
        return "Sunny";
    }
}
