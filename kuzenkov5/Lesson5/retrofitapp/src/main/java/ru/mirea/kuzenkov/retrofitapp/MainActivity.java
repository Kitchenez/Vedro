package ru.mirea.kuzenkov.retrofitapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.kuzenkov.retrofitapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setContentView(binding.getRoot());

        binding.recyclerView.setAdapter(new TodoAdapter(this, new ArrayList<>(), new String[]{}, null));

        var retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        var todosApiService = retrofitBuilder.create(ApiService.class);

        todosApiService.getTodos().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    binding.recyclerView.setAdapter(new TodoAdapter(MainActivity.this, response.body(), new String[]{
                            "https://shop.vistamarltd.com/files/148543486566636.jpg",
                            "https://store.artlebedev.ru/products/images/7eq2jepf.jpg",
                            "https://flagof.ru/wp-content/uploads/2018/10/flag_belarusi.png"
                    }, todosApiService));
                } else {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    Log.i("????????", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("????????", throwable.getMessage());
            }
        });
    }
}