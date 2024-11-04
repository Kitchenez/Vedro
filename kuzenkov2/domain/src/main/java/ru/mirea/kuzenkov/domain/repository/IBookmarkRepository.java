package ru.mirea.kuzenkov.domain.repository;

import java.util.Set;

public interface IBookmarkRepository {
    Set<Integer> ListBookmarks();
    void AddBookmark(Integer plantId);
    void RemoveBookmark(Integer plantId);
}
