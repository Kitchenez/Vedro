package ru.mirea.kuzenkov.data.repository.firebase;

import kotlin.NotImplementedError;
import ru.mirea.kuzenkov.domain.repository.IAccountRepository;

public class FirebaseAccountRepository implements IAccountRepository {
    @Override
    public void Authorize(String username, String password) {
        throw new NotImplementedError();
    }
    @Override
    public void Register(String username, String password) {
        throw new NotImplementedError();
    }
    @Override
    public void ContinueAsGuest() {
        throw new NotImplementedError();
    }
    @Override
    public void LogOut() {
        throw new NotImplementedError();
    }
}
