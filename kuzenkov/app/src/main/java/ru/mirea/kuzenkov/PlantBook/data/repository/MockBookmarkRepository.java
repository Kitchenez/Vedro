package ru.mirea.kuzenkov.PlantBook.data.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IBookmarkRepository;

public class MockBookmarkRepository implements IBookmarkRepository {
    private final Set<Integer> Bookmarks = new HashSet<>();

    @Override
    public Set<Integer> ListBookmarks() {
        return Bookmarks;
    }
    @Override
    public void AddBookmark(Integer plantId) {
        Bookmarks.add(plantId);
    }
    @Override
    public void RemoveBookmark(Integer plantId) {
        Bookmarks.remove(plantId);
    }
}
