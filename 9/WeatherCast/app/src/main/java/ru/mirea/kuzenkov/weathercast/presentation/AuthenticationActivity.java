package ru.mirea.kuzenkov.weathercast.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kuzenkov.weathercast.MainActivity;
import ru.mirea.kuzenkov.weathercast.R;
import ru.mirea.kuzenkov.weathercast.domain.model.User;
import ru.mirea.kuzenkov.weathercast.domain.usecases.AuthenticateUserUseCase;
import ru.mirea.kuzenkov.weathercast.data.repository.UserRepository;
import ru.mirea.kuzenkov.weathercast.data.repository.mock.MockUserRepository;

public class AuthenticationActivity extends AppCompatActivity {

    private AuthenticateUserUseCase authenticateUserUseCase;
    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        // Инициализируем элементы UI
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Инициализируем use-case
        UserRepository userRepository = MockUserRepository.getInstance();
        authenticateUserUseCase = new AuthenticateUserUseCase(userRepository);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            User user = authenticateUserUseCase.execute(username, password);
            if (user != null) {
                // Аутентификация успешна
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Аутентификация не удалась
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}