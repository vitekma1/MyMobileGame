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
    TextView Tsteps,Tcalories;
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
        String totalMeters = String.valueOf(numStepsTotal*0.762);
        String totalCalories = String.valueOf((int)(numStepsTotal*0.04));
        Tsteps = (TextView) findViewById(R.id.total_steps);
        Tsteps.setText("Celkový počet kroků = "+numStepsTotalStr + "kroků");
        Tcalories = (TextView) findViewById(R.id.total_calories);
        Tcalories.setText("Celkový počet spálených kalorií = "+totalCalories + "kcal");
        //TODO prepocet kalorii dle vahy v nastaveni a tady


        Button btn_menu = (Button)findViewById(R.id.btn_menu);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Storage.this, Menu.class));
            }
        });
    }

}
