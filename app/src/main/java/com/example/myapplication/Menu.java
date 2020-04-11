package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

import static com.example.myapplication.Storage.PREFS_NAME;

public class Menu extends AppCompatActivity {
    private int loginCount=0;
    private int lastLoginDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        lastLoginDate = settings.getInt("lastLoginDate",lastLoginDate);
        loginCount = settings.getInt("loginCount",loginCount);
        getCountOFEntrances();
        Button btn_storage = (Button)findViewById(R.id.btn_storage);

        btn_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Storage.class));
                finish();
            }
        });
        Button btn_temp = (Button)findViewById(R.id.btn_temp);

        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Temperature.class));
                finish();
            }
        });
        Button btn_settings = (Button)findViewById(R.id.btn_settings);

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Settings.class));
                finish();
            }
        });
        Button btn_quests = (Button)findViewById(R.id.btn_quests);

        btn_quests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Quests.class));
                finish();
            }
        });
        Button btn_map = (Button)findViewById(R.id.btn_map);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, MapsActivity.class));
                finish();
            }
        });
        Button btn_pedo = (Button)findViewById(R.id.btn_pedo);

        btn_pedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, PedometerActivity.class));
                finish();
            }
        });
        Button btn_buddy = (Button)findViewById(R.id.btn_buddy);

        btn_buddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Buddy.class));
                finish();
            }
        });
    }

    public void getCountOFEntrances(){
        Date day = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        lastLoginDate = settings.getInt("lastLoginDate",lastLoginDate);
        if(calendar.get(Calendar.DAY_OF_MONTH)==lastLoginDate) {

        }else{
            SharedPreferences.Editor editor = settings.edit();
            lastLoginDate = calendar.get(Calendar.DAY_OF_MONTH);
            loginCount++;
            editor.putInt("loginCount",loginCount);
            editor.putInt("lastLoginDate",lastLoginDate);

            editor.commit();
            System.out.println(lastLoginDate);
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        }
    }
}
