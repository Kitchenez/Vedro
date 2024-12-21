package ru.mirea.kuzenkov.data.repository.room;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import ru.mirea.kuzenkov.data.repository.room.dao.RoomBookmarkDao;
import ru.mirea.kuzenkov.data.repository.room.dto.RoomBookmarkDto;
import ru.mirea.kuzenkov.domain.dto.Bookmark;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class RoomBookmarkRepository implements IBookmarkRepository {
    private final RoomBookmarkDao roomBookmarkDao;
    public RoomBookmarkRepository(RoomBookmarkDao roomBookmarkDao) {
        this.roomBookmarkDao = roomBookmarkDao;
    }


    @Override
    public Set<Bookmark> ListBookmarks() {
        return roomBookmarkDao.list().stream().
            map(roomBookmarkDto -> new Bookmark(roomBookmarkDto.Title)).
            collect(Collectors.toSet());
    }
    @Override
    public void AddBookmark(Bookmark bookmark) {
        var roomBookmark = new RoomBookmarkDto();
        roomBookmark.Title = bookmark.getTitle();
        roomBookmarkDao.insert(roomBookmark);
    }
    @Override
    public void RemoveBookmark(Bookmark bookmark) {
        var roomBookmark = new RoomBookmarkDto();
        roomBookmark.Title = bookmark.getTitle();
        roomBookmarkDao.delete(roomBookmark);
    }
}
