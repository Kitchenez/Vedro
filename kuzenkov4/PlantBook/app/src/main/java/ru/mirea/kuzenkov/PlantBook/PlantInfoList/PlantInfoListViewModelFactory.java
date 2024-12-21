package ru.mirea.kuzenkov.PlantBook.PlantInfoList;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class PlantInfoListViewModelFactory implements ViewModelProvider.Factory {
    private final IBookmarkRepository bookmarkRepository;
    private final IPlantRepository plantRepository;

    public PlantInfoListViewModelFactory(IBookmarkRepository bookmarkRepository, IPlantRepository plantRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.plantRepository = plantRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantInfoListViewModel(plantRepository, bookmarkRepository);
    }
}
