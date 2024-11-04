package ru.mirea.kuzenkov.Lesson9.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kuzenkov.Lesson9.R;
import ru.mirea.kuzenkov.Lesson9.data.repository.MovieRepositoryImpl;
import ru.mirea.kuzenkov.Lesson9.domain.models.Movie;
import ru.mirea.kuzenkov.Lesson9.domain.repository.MovieRepository;
import ru.mirea.kuzenkov.Lesson9.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.kuzenkov.Lesson9.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMovie;
    private TextView textViewMovie;
    private MovieRepository movieRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        editTextMovie = findViewById(R.id.editTextMovie);
        textViewMovie = findViewById(R.id.textViewMovie);
        Button buttonSaveMovie = findViewById(R.id.buttonSaveMovie);
        Button buttonGetMovie = findViewById(R.id.buttonGetMovie);

        // Инициализация репозитория с передачей context
        movieRepository = new MovieRepositoryImpl(this);

        // Сохранение фильма
        buttonSaveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieName = editTextMovie.getText().toString();
                boolean result = new SaveMovieToFavoriteUseCase(movieRepository)
                        .execute(new Movie(2, movieName));
                textViewMovie.setText(String.format("Save result: %s", result ? "Success" : "Failed"));
            }
        });

        // Получение фильма
        buttonGetMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
                textViewMovie.setText(String.format("Favorite movie: %s", movie.getName()));
            }
        });
    }
}
