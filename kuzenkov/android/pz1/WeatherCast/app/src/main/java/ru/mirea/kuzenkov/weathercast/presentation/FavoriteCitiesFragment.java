package ru.mirea.kuzenkov.weathercast.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.mirea.kuzenkov.weathercast.R;
import ru.mirea.kuzenkov.weathercast.domain.usecases.LoadFavoriteCitiesUseCase;
import ru.mirea.kuzenkov.weathercast.domain.repositories.UserRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockUserRepository;

import java.util.List;

public class FavoriteCitiesFragment extends Fragment {

    private LoadFavoriteCitiesUseCase loadFavoriteCitiesUseCase;
    private String userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_cities, container, false);

        // Получаем ID пользователя из аргументов
        if (getArguments() != null) {
            userId = getArguments().getString("userId");
        }

        // Инициализируем use-case
        UserRepository userRepository = MockUserRepository.getInstance();
        loadFavoriteCitiesUseCase = new LoadFavoriteCitiesUseCase(userRepository);

        // Получаем список избранных городов
        List<String> favoriteCities = loadFavoriteCitiesUseCase.execute(userId);

        // Настраиваем ListView
        ListView listView = view.findViewById(R.id.listViewFavoriteCities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, favoriteCities);
        listView.setAdapter(adapter);

        return view;
    }
}
