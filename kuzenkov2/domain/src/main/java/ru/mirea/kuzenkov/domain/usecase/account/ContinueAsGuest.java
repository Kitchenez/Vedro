package ru.mirea.kuzenkov.domain.usecase.account;

import ru.mirea.kuzenkov.domain.repository.IAccountRepository;

public class ContinueAsGuest {
    private final IAccountRepository accountRepository;
    public ContinueAsGuest(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute() {
        accountRepository.ContinueAsGuest();
    }
}
