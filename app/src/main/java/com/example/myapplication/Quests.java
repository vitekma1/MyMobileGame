package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quests extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private int numStepsTotal;
    TextView quest1,quest1text,quest2,quest2text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numStepsTotal",numStepsTotal);

        editor.commit();
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);
        String numStepsTotalStr = String.valueOf(numStepsTotal);
        String totalMeters = String.valueOf(numStepsTotal*0.762);
        quest1text = (TextView) findViewById(R.id.quest1text);
        quest1 = (TextView) findViewById(R.id.quest1);
        quest2text = (TextView) findViewById(R.id.quest2text);
        quest2 = (TextView) findViewById(R.id.quest2);
        quest1text.setText("Úkol vzdálenost - železná úroveň");
        quest1.setText(totalMeters+"m/150m");
        if((numStepsTotal*0.762)>150){
        quest1text.setText("Úkol vzdálenost - bronzová úroveň");
        quest1.setText(totalMeters+"m/500m");}
        if((numStepsTotal*0.762)>500){
            quest1text.setText("Úkol vzdálenost - stříbrná úroveň");
            quest1.setText(totalMeters+"m/1000m");}
        if((numStepsTotal*0.762)>1000){
            quest1text.setText("Úkol vzdálenost - zlatá úroveň");
            quest1.setText(totalMeters+"m/10000m");}
        if((numStepsTotal*0.762)>10000){
            quest1text.setText("Úkol vzdálenost - platinová úroveň");
            quest1.setText(totalMeters+"m/100000m");}
        if((numStepsTotal*0.762)>100000){
            quest1text.setText("Úkol vzdálenost - diamantová úroveň");
            quest1.setText(totalMeters+"m/1000000m");}
        if((numStepsTotal*0.762)>1000000){
            quest1text.setText("Úkoly na vzdálenost dokončeny");
            quest1.setText(totalMeters+"m");
        }
        /*
        if((numStepsTotal*0.762)>150){
            quest2text.setText("Úkol trasa - bronzová úroveň");
            quest2.setText(totalMeters+"/5");}
        if((numStepsTotal*0.762)>500){
            quest2text.setText("Úkol trasa - stříbrná úroveň");
            quest1.setText(totalMeters+"/10");}
        if((numStepsTotal*0.762)>1000){
            quest2text.setText("Úkol trasa - zlatá úroveň");
            quest2.setText(totalMeters+"/100");}
        if((numStepsTotal*0.762)>10000){
            quest2text.setText("Úkol trasa - platinová úroveň");
            quest2.setText(totalMeters+"/1000");}
        if((numStepsTotal*0.762)>100000){
            quest2text.setText("Úkol trasa - diamantová úroveň");
            quest2.setText(totalMeters+"/10000");}
        if((numStepsTotal*0.762)>1000000){
            quest2text.setText("Úkoly na trasa dokončeny");
            quest2.setText(totalMeters+"m");
        }
*/
        quest2text.setText("Úkol trasa - zlatá úroveň");
        quest2.setText("78/100");

        Button btn_temp = (Button)findViewById(R.id.btn_temp);

        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quests.this, Temperature.class));
            }
        });

    }

}
