package com.yovanydev.asteroides.view;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yovanydev.asteroides.R;
import com.yovanydev.asteroides.view.fragment.AboutFragment;

public class GeneralOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_options);

        Bundle extras = getIntent().getExtras();
        String option = extras.getString("option");

        if (option!=null) {
            switch (option) {
                default:
                    launchFragment(new AboutFragment());
                    break;
            }

        }
    }

    /*----------------------------------------------------------------------------------------------
    * Lanzar un fragmento determinado*/
    private void launchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutContainer, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
