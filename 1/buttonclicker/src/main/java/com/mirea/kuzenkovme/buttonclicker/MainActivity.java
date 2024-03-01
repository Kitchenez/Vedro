package com.mirea.kuzenkovme.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private TextView tvOut;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = findViewById(R.id.tvOut);
        Button btnWhoAmI = findViewById(R.id.btnWhoAmI);
        Button btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        checkBox = findViewById(R.id.checkBox);

        // Обработчик для кнопки "WhoAmI"
        btnWhoAmI.setOnClickListener(v -> {
            tvOut.setText("Мой номер по списку № Х");
            checkBox.setChecked(!checkBox.isChecked()); // Изменение состояния CheckBox
        });

        // Обработчик для кнопки "ItIsNotMe" (Это не я сделал)
        btnItIsNotMe.setOnClickListener(v -> {
            tvOut.setText("Это не я сделал");
            checkBox.setChecked(!checkBox.isChecked()); // Изменение состояния CheckBox
        });
    }

    // Метод для обработки нажатия кнопки btnItIsNotMe через атрибут onClick
    public void onMyButtonClick(View view) {
        Log.d("MainActivity", "onMyButtonClick called");
        // выводим сообщение
        Toast.makeText(this, "Ещё один способ!", Toast.LENGTH_SHORT).show();
    }

}

