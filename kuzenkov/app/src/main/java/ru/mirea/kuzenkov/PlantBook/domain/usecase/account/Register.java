package ru.mirea.kuzenkov.PlantBook.domain.usecase.account;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IAccountRepository;

public class Register {
    private final IAccountRepository accountRepository;
    public Register(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String username, String password) {
        accountRepository.Register(username, password);
    }
}
