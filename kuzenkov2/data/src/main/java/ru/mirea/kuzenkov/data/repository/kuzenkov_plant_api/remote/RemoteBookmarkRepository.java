package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.remote;

import java.util.Collections;
import java.util.Set;

import kotlin.NotImplementedError;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class RemoteBookmarkRepository implements IBookmarkRepository {
    @Override
    public Set<Integer> ListBookmarks() {
        throw new NotImplementedError();
    }
    @Override
    public void AddBookmark(Integer plantId) {
        throw new NotImplementedError();
    }
    @Override
    public void RemoveBookmark(Integer plantId) {
        throw new NotImplementedError();
    }
}
