package ru.mirea.kuzenkov.domain.repository;

import java.util.Set;

import ru.mirea.kuzenkov.domain.dto.Bookmark;

public interface IBookmarkRepository {
    Set<Bookmark> ListBookmarks();
    void AddBookmark(Bookmark bookmark);
    void RemoveBookmark(Bookmark bookmark);
}
