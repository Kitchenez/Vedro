package ru.mirea.kuzenkov.Lesson9.domain.usecases;

import ru.mirea.kuzenkov.Lesson9.domain.models.Movie;
import ru.mirea.kuzenkov.Lesson9.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {
    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie) {
        if (movie.getName().isEmpty()) {
            return false;
        } else {
            return movieRepository.saveMovie(movie);
        }
    }
}
