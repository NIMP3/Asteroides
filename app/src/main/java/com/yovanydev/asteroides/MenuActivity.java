package com.yovanydev.asteroides;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yovanydev.asteroides.model.RaitingStore;
import com.yovanydev.asteroides.model.RaitingStoreArray;
import com.yovanydev.asteroides.view.GeneralOptionsActivity;
import com.yovanydev.asteroides.view.ScoresActivity;
import com.yovanydev.asteroides.view.SettingsActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    public static RaitingStore store = new RaitingStoreArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonAbout = findViewById(R.id.btn_about);
        Button buttonExit = findViewById(R.id.btn_exit);
        Button buttonSetup = findViewById(R.id.btn_setup);
        Button buttonPlay = findViewById(R.id.btn_play);

        buttonAbout.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
        buttonSetup.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);
    }
    /*----------------------------------------------------------------------------------------------
    * Lanzamos el Activity con un fragmento determinado*/
    private void launchOptions(String option) {
        Intent intent = new Intent(this, GeneralOptionsActivity.class);
        intent.putExtra("option",option);
        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
    Lanzamos las Opciones del juego
     */
    private void launchSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
    Lanzamos el Activity para la lista de Puntuaciones
     */
    public void launchScores() {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
    Muestra las preferencias del usuario
    */
    public void showUserSettings() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String allSettings =
                "Música: " + preferences.getBoolean("music",true) +
                "Gráficos: " + preferences.getString("graphics","bitmap") +
                "Numero de Fragmentos: " + preferences.getString("fragments","3");

        Toast.makeText(this,allSettings,Toast.LENGTH_LONG).show();
    }

    /*----------------------------------------------------------------------------------------------
    * Evento OnClick sobre los botones del menu*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_about:
                launchOptions("ABOUT");
                break;
            case R.id.btn_exit:
                launchScores();
                break;
            case R.id.btn_setup:
                launchSettings();
                break;
            case R.id.btn_play:
                showUserSettings();
                break;
        }
    }
}
