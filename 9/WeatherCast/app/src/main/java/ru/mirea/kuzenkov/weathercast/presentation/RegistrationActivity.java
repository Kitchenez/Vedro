package ru.mirea.kuzenkov.weathercast.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.kuzenkov.weathercast.R;
import ru.mirea.kuzenkov.weathercast.domain.usecases.RegisterUserUseCase;
import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockUserRepository;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnRegister;
    private RegisterUserUseCase registerUserUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Инициализация UI элементов
        etUsername = findViewById(R.id.etRegUsername);
        etPassword = findViewById(R.id.etRegPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Инициализация use-case
        UserRepository userRepository = MockUserRepository.getInstance();
        registerUserUseCase = new RegisterUserUseCase(userRepository);

        // Обработчик нажатия на кнопку регистрации
        btnRegister.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean success = registerUserUseCase.execute(username, password);
            if (success) {
                // Сохраняем userId в SharedPreferences
                SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("userId", username);
                editor.apply();

                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
                finish(); // Закрываем активность после успешной регистрации
            } else {
                Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
