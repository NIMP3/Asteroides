package com.yovanydev.asteroides.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yovanydev.asteroides.view.fragment.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
