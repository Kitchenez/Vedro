package ru.mirea.kuzenkov.domain.usecase.auth;

import ru.mirea.kuzenkov.domain.repository.IAuthorizationService;

public class LogOut {
    private final IAuthorizationService authorizationService;
    public LogOut(IAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
    
    public void execute() {
        authorizationService.LogOut();
    }
}
