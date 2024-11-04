package ru.mirea.kuzenkov.data.repository.mock;

import java.util.HashSet;
import java.util.Set;

import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

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
