package ru.mirea.kuzenkov.PlantBook.domain.repository;

public interface IAccountRepository {
    void Authorize(String username, String password);
    void Register(String username, String password);
    void ContinueAsGuest();
    void LogOut();
}
