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
    private int numStepsTotal,totalMetersInt,food;
    TextView quest1,quest1text,quest2,quest2text,quest3,quest3text,souls;
    private int trasa = 0;
    private int vyska_btn = 2;
    private int loginCount=0;
    private String totalMeters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);
        loginCount = settings.getInt("loginCount",loginCount);
        vyska_btn = settings.getInt("vyska_btn",vyska_btn);
        trasa = settings.getInt("trasa",trasa);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numStepsTotal",numStepsTotal);
        editor.commit();

        System.out.println("--------------------------------"+trasa);
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);

        if(vyska_btn==1){
            totalMetersInt=(int)(numStepsTotal*0.862);
            totalMeters = String.valueOf(totalMetersInt);
        }
        if(vyska_btn==2){
            totalMetersInt=(int)(numStepsTotal*0.762);
            totalMeters = String.valueOf(totalMetersInt);
        }
        if(vyska_btn==3){
            totalMetersInt=(int)(numStepsTotal*0.662);
            totalMeters = String.valueOf(totalMetersInt);
        }
        food=0;
        if(totalMetersInt>150){
            food=food+10;}
        if(totalMetersInt>500){
            food=food+10;}
        if(totalMetersInt>1000){
            food=food+10;}
        if(totalMetersInt>10000){
            food=food+10;}
        if(totalMetersInt>100000){
            food=food+10;}
        if(totalMetersInt>1000000){
            food=food+10;}

        quest1text = (TextView) findViewById(R.id.quest1text);
        quest1 = (TextView) findViewById(R.id.quest1);
        quest2text = (TextView) findViewById(R.id.quest2text);
        quest2 = (TextView) findViewById(R.id.quest2);
        quest3text = (TextView) findViewById(R.id.quest3text);
        quest3 = (TextView) findViewById(R.id.quest3);
        souls = (TextView) findViewById(R.id.souls);

        quest1text.setText("Úkol vzdálenost - železná úroveň");
        quest1.setText(totalMeters+"m/150m");
        if(totalMetersInt>150){
        quest1text.setText("Úkol vzdálenost - bronzová úroveň");
        quest1.setText(totalMeters+"m/500m");}
        if(totalMetersInt>500){
            quest1text.setText("Úkol vzdálenost - stříbrná úroveň");
            quest1.setText(totalMeters+"m/1000m");}
        if(totalMetersInt>1000){
            quest1text.setText("Úkol vzdálenost - zlatá úroveň");
            quest1.setText(totalMeters+"m/10000m");}
        if(totalMetersInt>10000){
            quest1text.setText("Úkol vzdálenost - platinová úroveň");
            quest1.setText(totalMeters+"m/100000m");}
        if(totalMetersInt>100000){
            quest1text.setText("Úkol vzdálenost - diamantová úroveň");
            quest1.setText(totalMeters+"m/1000000m");}
        if(totalMetersInt>1000000){
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
        String trasaText = String.valueOf(trasa);
        quest2text.setText("Úkol trasa");
        quest2.setText(trasaText);
        quest3text.setText("Úkol denní spuštění");
        quest3.setText(loginCount+" spuštění");
        food=food+loginCount+trasa;
        souls.setText("Počet získaných duší "+food);
        Button btn_menu = (Button)findViewById(R.id.btn_menu);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quests.this, Menu.class));
                finish();
            }
        });


    }

}
