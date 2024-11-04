package ru.mirea.kuzenkov.domain.usecase.bookmark;

import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class CheckIsBookmark {
    private final IBookmarkRepository bookmarkRepository;
    public CheckIsBookmark(IBookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public Boolean execute(Integer plantId) {
        return bookmarkRepository.ListBookmarks().contains(plantId);
    }
}
