package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Storage extends AppCompatActivity {
public static final String PREFS_NAME = "MyPrefsFile";
private int numStepsTotal;
    TextView Tsteps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numStepsTotal",numStepsTotal);

        editor.commit();
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);
        String numStepsTotalStr = String.valueOf(numStepsTotal);
        Tsteps = (TextView) findViewById(R.id.total_steps);
        Tsteps.setText(numStepsTotalStr);
        Button btn_pedo = (Button)findViewById(R.id.btn_pedo);

        btn_pedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Storage.this, PedometerActivity.class));
            }
        });
        Button btn_temp = (Button)findViewById(R.id.btn_temp);

        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Storage.this, Temperature.class));
            }
        });

    }

}
