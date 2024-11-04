package ru.mirea.kuzenkov.PlantBook.domain.usecase.bookmark;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IBookmarkRepository;

public class RemoveBookmark {
    private final IBookmarkRepository bookmarkRepository;
    public RemoveBookmark(IBookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public void execute(Integer plantId) {
        bookmarkRepository.RemoveBookmark(plantId);
    }
}
