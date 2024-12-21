package ru.mirea.kuzenkov.data.repository.network;

import java.util.HashSet;
import java.util.Set;

import ru.mirea.kuzenkov.domain.dto.Bookmark;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class NetworkBookmarkRepository implements IBookmarkRepository {
    private final Set<Bookmark> Bookmarks = new HashSet<>();
    @Override
    public Set<Bookmark> ListBookmarks() {
        return Bookmarks;
    }
    @Override
    public void AddBookmark(Bookmark bookmark) {
        Bookmarks.add(bookmark);
    }
    @Override
    public void RemoveBookmark(Bookmark bookmark) {
        Bookmarks.remove(bookmark);
    }
}