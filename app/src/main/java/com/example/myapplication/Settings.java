package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private int vyska_btn = 2;
    TextView vyska;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        vyska_btn = settings.getInt("vyska",vyska_btn);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("vyska",vyska_btn);
        editor.commit();
        vyska_btn = settings.getInt("vyska",vyska_btn);
        vyska = (TextView) findViewById(R.id.vyska);
        if(vyska_btn==1){
            vyska.setText("Výška je nastavena na více než 185cm");
        }
        if(vyska_btn==2){
            vyska.setText("Výška je nastavena na 165 až 185cm");
        }
        if(vyska_btn==3){
            vyska.setText("Výška je nastavena na méně než 165cm");
        }


        Button btn_menu = (Button)findViewById(R.id.btn_menu);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Menu.class));
                finish();
            }
        });

        Button btn_step_size_big = (Button)findViewById(R.id.btn_step_size_big);

        btn_step_size_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vyska_btn = 1;
                SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("vyska_btn",vyska_btn);
                editor.commit();
                vyska_btn = settings.getInt("vyska",vyska_btn);
                vyska = (TextView) findViewById(R.id.vyska);
                vyska.setText("Výška je nastavena na více než 185cm");

            }
        });

        Button btn_step_size_normal = (Button)findViewById(R.id.btn_step_size_normal);

        btn_step_size_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vyska_btn = 2;
                SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("vyska_btn",vyska_btn);
                editor.commit();
                vyska_btn = settings.getInt("vyska",vyska_btn);
                vyska = (TextView) findViewById(R.id.vyska);
                vyska.setText("Výška je nastavena na 165 až 185cm");

            }
        });

        Button btn_step_size_small = (Button)findViewById(R.id.btn_step_size_small);

        btn_step_size_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vyska_btn = 3;
                SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("vyska_btn",vyska_btn);
                editor.commit();
                vyska_btn = settings.getInt("vyska",vyska_btn);
                vyska = (TextView) findViewById(R.id.vyska);
                vyska.setText("Výška je nastavena na méně než 165cm");

            }
        });

    }

}

