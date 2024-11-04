package ru.mirea.kuzenkov.domain.usecase.bookmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class ListBookmarks {
    private final IBookmarkRepository bookmarkRepository;
    private final IPlantRepository plantRepository;

    public ListBookmarks(IBookmarkRepository bookmarkRepository, IPlantRepository plantRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.plantRepository = plantRepository;
    }

    public List<PlantInfo> execute() {
        List<PlantInfo> result = new ArrayList<PlantInfo>();
        Set<Integer> bookmarks = bookmarkRepository.ListBookmarks();
        for(Integer plantId: plantRepository.GetPlantList()) {
            if(bookmarks.contains(plantId)) {
                result.add(plantRepository.GetPlantInfo(plantId));
            }
        }
        return result;
    }
}
