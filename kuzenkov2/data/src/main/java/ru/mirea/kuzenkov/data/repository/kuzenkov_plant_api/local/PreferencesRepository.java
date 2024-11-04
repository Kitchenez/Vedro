package ru.mirea.kuzenkov.data.repository.kuzenkov_plant_api.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesRepository {

    private static final String PREFS_NAME = "user_prefs";
    private static final String KEY_USER_EMAIL = "user_email";

    private final SharedPreferences sharedPreferences;

    public PreferencesRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveUserEmail(String email) {
        sharedPreferences.edit().putString(KEY_USER_EMAIL, email).apply();
    }

    public String getUserEmail() {
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }
}

