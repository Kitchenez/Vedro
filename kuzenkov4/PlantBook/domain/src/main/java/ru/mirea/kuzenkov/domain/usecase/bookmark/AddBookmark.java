package ru.mirea.kuzenkov.domain.usecase.bookmark;

import ru.mirea.kuzenkov.domain.dto.Bookmark;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class AddBookmark {
    private final IBookmarkRepository bookmarkRepository;
    public AddBookmark(IBookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public void execute(Bookmark bookmark) {
        bookmarkRepository.AddBookmark(bookmark);
    }
}