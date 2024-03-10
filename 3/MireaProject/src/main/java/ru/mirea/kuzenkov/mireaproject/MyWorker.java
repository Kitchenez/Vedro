package ru.mirea.kuzenkov.mireaproject;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    public MyWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Здесь вы можете добавить код для выполнения фоновой задачи
        // Например, загрузка данных из сети
        try {
            // Эмуляция загрузки данных из сети
            Thread.sleep(5000); // Подождать 5 секунд
            return Result.success();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}

