package ru.mirea.kuzenkov.domain.dto;

public class Bookmark {
    private final String Title;
    public Bookmark(String title) {
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
}
