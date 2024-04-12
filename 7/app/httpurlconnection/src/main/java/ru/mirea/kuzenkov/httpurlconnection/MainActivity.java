package ru.mirea.kuzenkov.httpurlconnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView tvCity, tvRegion, tvWeather;
    private Button btnGetInfo;
    private ExecutorService executorService;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCity = findViewById(R.id.tvCity);
        tvRegion = findViewById(R.id.tvRegion);
        tvWeather = findViewById(R.id.tvWeather);
        btnGetInfo = findViewById(R.id.btnGetInfo);

        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        btnGetInfo.setOnClickListener(view -> fetchLocationAndWeather());
    }

    private void fetchLocationAndWeather() {
        executorService.execute(() -> {
            try {
                // First, fetch location data
                URL url = new URL("https://ipinfo.io/json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder jsonResult = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    jsonResult.append(line);
                }
                String locationResult = jsonResult.toString();
                JSONObject locationObject = new JSONObject(locationResult);
                String city = locationObject.getString("city");
                String region = locationObject.getString("region");

                // Extract latitude and longitude for weather API
                String loc = locationObject.getString("loc");
                String[] latLong = loc.split(",");
                String latitude = latLong[0];
                String longitude = latLong[1];

                // Then, fetch weather data using extracted coordinates
                URL weatherUrl = new URL(String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true", latitude, longitude));
                HttpURLConnection weatherConnection = (HttpURLConnection) weatherUrl.openConnection();
                BufferedReader weatherReader = new BufferedReader(new InputStreamReader(weatherConnection.getInputStream()));
                StringBuilder weatherJsonResult = new StringBuilder();
                while ((line = weatherReader.readLine()) != null) {
                    weatherJsonResult.append(line);
                }
                String weatherResult = weatherJsonResult.toString();
                JSONObject weatherObject = new JSONObject(weatherResult);
                JSONObject currentWeather = weatherObject.getJSONObject("current_weather");
                double temperature = currentWeather.getDouble("temperature");

                // Update UI with fetched data
                handler.post(() -> {
                    tvCity.setText(String.format("Город: %s", city));
                    tvRegion.setText(String.format("Регион: %s", region));
                    tvWeather.setText(String.format("Погода сейчас: %.1f°C", temperature));
                });
            } catch (Exception e) {
                e.printStackTrace();
                handler.post(() -> tvWeather.setText("Ошибка при получении данных"));
            }
        });
    }
}
