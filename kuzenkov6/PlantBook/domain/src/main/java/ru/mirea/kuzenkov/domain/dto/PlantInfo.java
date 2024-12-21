package ru.mirea.kuzenkov.domain.dto;

public class PlantInfo {
    private final String Title;
    private final String ImageUri;
    private final String Description;

    public PlantInfo(String title, String imageUri, String description) {
        Title = title;
        ImageUri = imageUri;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }
    public String getImageUri() {
        return ImageUri;
    }
    public String getDescription() {
        return Description;
    }
}

