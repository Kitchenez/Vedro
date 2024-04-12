    package ru.mirea.kuzenkov.mireaproject;

    import android.os.Bundle;

    import androidx.fragment.app.Fragment;
    import androidx.work.OneTimeWorkRequest;
    import androidx.work.WorkManager;


    public class BackgroundTaskFragment extends Fragment {

        public BackgroundTaskFragment() {

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Создание и запуск рабочей задачи
            OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
            WorkManager.getInstance(requireContext()).enqueue(workRequest);
        }
    }
