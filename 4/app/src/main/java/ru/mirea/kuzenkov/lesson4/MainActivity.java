package ru.mirea.kuzenkov.lesson4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.mirea.kuzenkov.lesson4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Объявление переменной для привязки макета

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Создание объекта ActivityMainBinding и привязка макета activity_main.xml к коду активности
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Установка корневого элемента макета как содержимого активности
        setContentView(binding.getRoot());

        // Пример использования binding для доступа к элементам макета
        binding.editTextMirea.setText("Мой номер по списку №11");
        binding.buttonMirea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.class.getSimpleName(),"onClickListener");
            }
        });
    }

}
