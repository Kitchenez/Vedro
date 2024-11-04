package ru.mirea.kuzenkov.PlantBook.domain.usecase.bookmark;

import ru.mirea.kuzenkov.PlantBook.domain.repository.IBookmarkRepository;

public class AddBookmark {
    private final IBookmarkRepository bookmarkRepository;
    public AddBookmark(IBookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public void execute(Integer plantId) {
        bookmarkRepository.AddBookmark(plantId);
    }
}
