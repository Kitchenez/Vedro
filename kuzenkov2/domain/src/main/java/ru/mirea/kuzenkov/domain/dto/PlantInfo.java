package ru.mirea.kuzenkov.domain.dto;

public class PlantInfo {
    private final String Title;
    private final String Description;

    public PlantInfo(String title, String description) {
        Title = title;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }
    public String getDescription() {
        return Description;
    }
}
