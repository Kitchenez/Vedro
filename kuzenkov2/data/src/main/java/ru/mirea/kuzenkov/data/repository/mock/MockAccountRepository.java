package ru.mirea.kuzenkov.data.repository.mock;

import java.util.HashMap;
import java.util.Map;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IAccountRepository;

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
