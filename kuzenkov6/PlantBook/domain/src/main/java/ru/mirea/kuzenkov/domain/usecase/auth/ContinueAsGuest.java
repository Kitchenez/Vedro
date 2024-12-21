package ru.mirea.kuzenkov.domain.usecase.auth;

import ru.mirea.kuzenkov.domain.repository.IAuthorizationService;

public class ContinueAsGuest {
    private final IAuthorizationService authorizationService;
    public ContinueAsGuest(IAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
    
    public void execute() {
        authorizationService.ContinueAsGuest();
    }
}
