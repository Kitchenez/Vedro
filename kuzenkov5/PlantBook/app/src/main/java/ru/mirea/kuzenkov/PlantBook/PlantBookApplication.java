package ru.mirea.kuzenkov.PlantBook;

import androidx.room.Room;

import ru.mirea.kuzenkov.data.repository.room.ApplicationDatabase;

public class PlantBookApplication extends android.app.Application {
    private static PlantBookApplication instance = null;
    private ApplicationDatabase applicationDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        applicationDatabase = Room.databaseBuilder(this, ApplicationDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static PlantBookApplication getInstance() {
        return instance;
    }
    public ApplicationDatabase getDatabase() {
        return applicationDatabase;
    }
}
