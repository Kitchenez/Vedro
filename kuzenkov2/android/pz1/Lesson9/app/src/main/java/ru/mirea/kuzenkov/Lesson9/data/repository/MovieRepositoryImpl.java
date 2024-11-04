package ru.mirea.kuzenkov.Lesson9.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import ru.mirea.kuzenkov.Lesson9.domain.models.Movie;
import ru.mirea.kuzenkov.Lesson9.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private static final String PREFERENCES_NAME = "movie_preferences";
    private static final String KEY_MOVIE_NAME = "movie_name";
    private SharedPreferences sharedPreferences;

    public MovieRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_MOVIE_NAME, movie.getName());
        return editor.commit();
    }

    @Override
    public Movie getMovie() {
        String movieName = sharedPreferences.getString(KEY_MOVIE_NAME, "No movie found");
        return new Movie(1, movieName);
    }
}
