package ru.mirea.kuzenkov.domain.usecase.account;

import ru.mirea.kuzenkov.domain.repository.IAccountRepository;

public class LogOut {
    private final IAccountRepository accountRepository;
    public LogOut(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute() {
        accountRepository.LogOut();
    }
}
