package ru.mirea.kuzenkov.domain.usecase.account;

import ru.mirea.kuzenkov.domain.repository.IAccountRepository;

public class Register {
    private final IAccountRepository accountRepository;
    public Register(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String username, String password) {
        accountRepository.Register(username, password);
    }
}
