package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import kotlin.NotImplementedError;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;

public class LocalBookmarkRepository implements IBookmarkRepository {
    private Set<Integer> Bookmarks = new HashSet<>();
    private final IBookmarkRepository Origin;
    private Date LastSyncTime;

    public LocalBookmarkRepository(IBookmarkRepository origin, Date lastSyncTime) {
        LastSyncTime = lastSyncTime;
        Origin = origin;

        SyncWithOrigin();
    }
    private void SyncWithOrigin() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(LastSyncTime);
        cal.add(Calendar.HOUR_OF_DAY, 24);
        cal.getTime();
        if(cal.getTime().after(new Date())) {
            return;
        }

        Set<Integer> OriginBookmarks = Origin.ListBookmarks();
        if(OriginBookmarks.equals(Bookmarks)) {
            return;
        }

        Set<Integer> BookmarkUnion = new HashSet<>();
        BookmarkUnion.addAll(OriginBookmarks);
        BookmarkUnion.addAll(Bookmarks);

        Set<Integer> LocalOnlyBookmark = new HashSet<>(Bookmarks);
        LocalOnlyBookmark.removeAll(OriginBookmarks);

        Bookmarks = BookmarkUnion;
        for(Integer plantId: LocalOnlyBookmark) {
            Origin.AddBookmark(plantId);
        }
    }

    @Override
    public Set<Integer> ListBookmarks() {
        return Bookmarks;
    }
    @Override
    public void AddBookmark(Integer plantId) {
        Origin.AddBookmark(plantId);
        Bookmarks.add(plantId);
    }
    @Override
    public void RemoveBookmark(Integer plantId) {
        Origin.RemoveBookmark(plantId);
        Bookmarks.remove(plantId);
    }
}
