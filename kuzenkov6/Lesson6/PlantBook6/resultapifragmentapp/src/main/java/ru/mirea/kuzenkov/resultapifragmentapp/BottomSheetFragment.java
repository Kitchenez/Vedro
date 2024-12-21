package ru.mirea.kuzenkov.resultapifragmentapp;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetFragment extends BottomSheetDialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, (requestKey, bundle) -> {
            String text = bundle.getString("key");
            Log.d(BottomSheetFragment.class.getSimpleName(), "Get text" + text);
        });
    }
}