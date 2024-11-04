package ru.mirea.kuzenkov.PlantBook.data.repository;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IAccountRepository;

public class MockAccountRepository implements IAccountRepository {
    private boolean HasAccount = false;

    @Override
    public void Authorize(String username, String password) {
        if(HasAccount) {
            throw new RuntimeException("Account already exists");
        }
        HasAccount = true;
    }
    @Override
    public void Register(String username, String password) {
        if(HasAccount) {
            throw new RuntimeException("Account already exists");
        }
        HasAccount = true;
    }
    @Override
    public void ContinueAsGuest() {
        if(HasAccount) {
            throw new RuntimeException("Account already exists");
        }
        HasAccount = true;
    }
    @Override
    public void LogOut() {
        if(!HasAccount) {
            throw new RuntimeException("Account not exists");
        }
        HasAccount = false;
    }
}
