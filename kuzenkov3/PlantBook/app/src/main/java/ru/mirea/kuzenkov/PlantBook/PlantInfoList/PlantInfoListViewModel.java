package ru.mirea.kuzenkov.PlantBook.PlantInfoList;

import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.mirea.kuzenkov.domain.dto.Bookmark;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IBookmarkRepository;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;
import ru.mirea.kuzenkov.domain.usecase.bookmark.ListBookmarks;
import ru.mirea.kuzenkov.domain.usecase.plant.GetPlantList;

public class PlantInfoListViewModel extends ViewModel {
    private final MutableLiveData<List<PlantInfo>> plantInfoList = new MutableLiveData<>();
    private final IBookmarkRepository bookmarkRepository;
    private final IPlantRepository plantRepository;


    private class GetFullPlantInfoTask extends AsyncTask<Void, Void, List<PlantInfo>> {
        @Override
        protected List<PlantInfo> doInBackground(Void... voids) {
            var allPlants = new ArrayList<>(new GetPlantList(plantRepository).execute());
            var bookmarks = new ArrayList<>(new ListBookmarks(bookmarkRepository, plantRepository).execute());

            allPlants.removeAll(bookmarks);
            bookmarks.addAll(allPlants);
            return bookmarks;
        }
        @Override
        protected void onPostExecute(List<PlantInfo> result) {
            plantInfoList.postValue(result);
        }
    }


    public PlantInfoListViewModel(IPlantRepository plantRepository, IBookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.plantRepository = plantRepository;

        new GetFullPlantInfoTask().execute();

    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<PlantInfo>> getPlantInfoList() {
        return plantInfoList;
    }
}
