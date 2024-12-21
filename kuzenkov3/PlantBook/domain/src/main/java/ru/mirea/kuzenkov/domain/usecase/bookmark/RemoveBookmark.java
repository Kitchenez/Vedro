package ru.mirea.kuzenkov.domain.usecase.bookmark;

import ru.mirea.kuzenkov.domain.dto.Bookmark;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class RemoveBookmark {
    private final IBookmarkRepository bookmarkRepository;
    public RemoveBookmark(IBookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public void execute(Bookmark bookmark) {
        bookmarkRepository.RemoveBookmark(bookmark);
    }
}

