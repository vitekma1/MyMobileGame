package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn_storage = (Button)findViewById(R.id.btn_storage);

        btn_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Storage.class));
            }
        });
        Button btn_temp = (Button)findViewById(R.id.btn_temp);

        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Temperature.class));
            }
        });
        Button btn_settings = (Button)findViewById(R.id.btn_settings);

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Settings.class));
            }
        });
        Button btn_quests = (Button)findViewById(R.id.btn_quests);

        btn_quests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Quests.class));
            }
        });
        Button btn_map = (Button)findViewById(R.id.btn_map);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, MainActivity.class));
            }
        });
        Button btn_pedo = (Button)findViewById(R.id.btn_pedo);

        btn_pedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, PedometerActivity.class));
            }
        });
    }

}
