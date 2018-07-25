package com.yovanydev.asteroides;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yovanydev.asteroides.view.GeneralOptionsActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonAbout = findViewById(R.id.btn_about);
        Button buttonExit = findViewById(R.id.btn_exit);

        buttonAbout.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
    }
    /*----------------------------------------------------------------------------------------------
    * Lanzamos el Activity con un fragmento determinado*/
    private void launchOptions(String option) {
        Intent intent = new Intent(this, GeneralOptionsActivity.class);
        intent.putExtra("option",option);
        startActivity(intent);
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
                finish();
                break;
        }
    }
}
