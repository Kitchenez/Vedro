package ru.mirea.kuzenkov.PlantBook.domain.usecase.account;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IAccountRepository;

public class Authorize {
    private final IAccountRepository accountRepository;
    public Authorize(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String username, String password) {
        accountRepository.Authorize(username, password);
    }
}
