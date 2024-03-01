package com.mirea.kuzenkovme.control_lesson2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создание объекта TextView
        TextView myTextView = findViewById(R.id.textViewStudent);

        // Теперь вы можете использовать myTextView для доступа к TextView программным путем
        // Например, установка текста:
        myTextView.setText("New text in MIREA");

        // Создание объекта Button и присваивание слушателя событий для него
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действия при нажатии на кнопку
                myTextView.setText("Текст изменен при нажатии на кнопку");
            }
        });

        // Создание объекта CheckBox
        CheckBox checkBox = findViewById(R.id.checkBox);

        // Установка метки для CheckBox
        checkBox.setText("Моя галочка");

        // Установка состояния чекбокса
        checkBox.setChecked(true);
    }
}
