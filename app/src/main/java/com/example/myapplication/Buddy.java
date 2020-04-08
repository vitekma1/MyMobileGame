package com.example.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Buddy extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private int numStepsTotal,food,totalMetersInt;
    TextView buddyTxt,buddy,buddyPoints;
    private int vyska_btn = 2;
    private String totalMeters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);
        vyska_btn = settings.getInt("vyska_btn",vyska_btn);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numStepsTotal",numStepsTotal);
        editor.commit();
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);
        String numStepsTotalStr = String.valueOf(numStepsTotal);

        if(vyska_btn==1){
            totalMetersInt=(int)(numStepsTotal*0.862);
        }
        if(vyska_btn==2){
            totalMetersInt=(int)(numStepsTotal*0.762);
        }
        if(vyska_btn==3){
            totalMetersInt=(int)(numStepsTotal*0.662);
        }

        editor.commit();
        numStepsTotal = settings.getInt("numStepsTotal",numStepsTotal);
        buddyTxt = (TextView) findViewById(R.id.buddyTxt);
        buddyPoints = (TextView) findViewById(R.id.buddyPoints);
        buddy = (TextView) findViewById(R.id.buddy);

        if(totalMetersInt>150){
            food++;}
        if(totalMetersInt>500){
            food++;}
        if(totalMetersInt>1000){
            food++;}
        if(totalMetersInt>10000){
            food++;}
        if(totalMetersInt>100000){
            food++;}
        if(totalMetersInt>1000000){
            food++;
        }

        if(food==0){
            buddyTxt.setText("Démon level 0");
            buddy.setBackgroundResource(R.drawable.demon0);
            buddyPoints.setText("Počet nasbíraných duší - "+food*10+"/10");
        }
        if(food==1){
            buddyTxt.setText("Démon level 1");
            buddy.setBackgroundResource(R.drawable.demon1);
            buddyPoints.setText("Počet nasbíraných duší - "+food*10+"/20");
        }
        if(food==2){
            buddyTxt.setText("Démon level 2");
            buddy.setBackgroundResource(R.drawable.demon2);
            buddyPoints.setText("Počet nasbíraných duší - "+food*10+"/30");
        }
        if(food==3){
            buddyTxt.setText("Démon level 3");
            buddy.setBackgroundResource(R.drawable.demon3);
            buddyPoints.setText("Počet nasbíraných duší - "+food*10+"/40");
        }
        if(food==4){
            buddyTxt.setText("Démon level 4");
            buddy.setBackgroundResource(R.drawable.demon4);
            buddyPoints.setText("Počet nasbíraných duší - "+food*10+"/50");
        }
        if(food==5){
            buddyTxt.setText("Démon level 5");
            buddy.setBackgroundResource(R.drawable.demon5);
            buddyPoints.setText("Počet nasbíraných duší - "+food*10+"/60");
        }



        Button btn_menu = (Button)findViewById(R.id.btn_menu);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Buddy.this, Menu.class));
            }
        });
    }

}
