package ru.mirea.kuzenkov.domain.usecase.auth;

import ru.mirea.kuzenkov.domain.repository.IAuthorizationService;

public class AuthorizeUser {
    private final IAuthorizationService authorizationService;
    public AuthorizeUser(IAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void execute(String username, String password) {
        authorizationService.AuthorizeUser(username, password);
    }
}
