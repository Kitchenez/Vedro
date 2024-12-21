package ru.mirea.kuzenkov.PlantBook.Profile;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.kuzenkov.domain.repository.IAuthorizationService;


public class ProfileViewModelFactory  implements ViewModelProvider.Factory {
    private final IAuthorizationService authorizationService;
    public ProfileViewModelFactory(IAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProfileViewModel(authorizationService);
    }
}
