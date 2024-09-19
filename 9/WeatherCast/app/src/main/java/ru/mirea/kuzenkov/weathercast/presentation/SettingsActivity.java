package ru.mirea.kuzenkov.weathercast.presentation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kuzenkov.weathercast.R;
import ru.mirea.kuzenkov.weathercast.domain.model.Settings;
import ru.mirea.kuzenkov.weathercast.domain.model.User;
import ru.mirea.kuzenkov.weathercast.domain.usecases.AuthenticateUserUseCase;
import ru.mirea.kuzenkov.weathercast.domain.usecases.SaveSettingsUseCase;
import ru.mirea.kuzenkov.weathercast.data.repository.SettingsRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockSettingsRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockUserRepository;

public class SettingsActivity extends AppCompatActivity {

    private SaveSettingsUseCase saveSettingsUseCase;
    private AuthenticateUserUseCase authenticateUserUseCase;
    private EditText etLanguage, etTheme, etDefaultCity, etUsername, etPassword;
    private Button btnSaveSettings, btnLogin, btnLogout; // Добавили btnLogout
    private String userId = null;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Инициализируем элементы UI
        etLanguage = findViewById(R.id.etLanguage);
        etTheme = findViewById(R.id.etTheme);
        etDefaultCity = findViewById(R.id.etDefaultCity);
        btnSaveSettings = findViewById(R.id.btnSaveSettings);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogout = findViewById(R.id.btnLogout); // Инициализация btnLogout

        // Инициализируем use-case
        SettingsRepository settingsRepository = new MockSettingsRepository();
        saveSettingsUseCase = new SaveSettingsUseCase(settingsRepository);

        UserRepository userRepository = MockUserRepository.getInstance();
        authenticateUserUseCase = new AuthenticateUserUseCase(userRepository);

        // Обработчик сохранения настроек
        btnSaveSettings.setOnClickListener(v -> {
            String language = etLanguage.getText().toString();
            String theme = etTheme.getText().toString();
            String defaultCity = etDefaultCity.getText().toString();

            Settings settings = new Settings(language, theme, defaultCity);
            saveSettingsUseCase.execute(settings);
            Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        });

        // Обработчик кнопки входа
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            User user = authenticateUserUseCase.execute(username, password);
            if (user != null) {
                userId = user.getUsername();

                // Сохраняем userId в SharedPreferences
                SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("userId", userId);
                editor.apply();

                Toast.makeText(this, "Logged in as " + userId, Toast.LENGTH_SHORT).show();

                // Возвращаем результат в MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("userId", userId);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                // Неправильные учетные данные
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработчик кнопки выхода
        btnLogout.setOnClickListener(v -> {
            // Удаляем userId из SharedPreferences
            SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove("userId");
            editor.apply();

            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();

            // Можно обновить UI или выполнить другие действия после выхода
        });
        btnRegister.setOnClickListener(v -> {
            // Здесь мы откроем новое окно регистрации или реализуем регистрацию прямо в этом активити
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Проверяем, авторизован ли пользователь после возврата из RegistrationActivity
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        userId = prefs.getString("userId", null);
        if (userId != null) {
            Toast.makeText(this, "Logged in as " + userId, Toast.LENGTH_SHORT).show();
        }
    }
}

