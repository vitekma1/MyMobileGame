package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Temperature extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor temperature;

    TextView temp, press, tempInfo, pressInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        temp=findViewById(R.id.temp);

        //    Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        temperature= sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(temperature!=null){
            sensorManager.registerListener(Temperature.this, temperature, SensorManager.SENSOR_DELAY_NORMAL);
            //   Log.d(TAG, "onCreate: Registered temperature listener");
        }else{
            temp.setText("Temperature Sensor Not Supported");
        }

        Button btn_storage = (Button)findViewById(R.id.btn_storage);

        btn_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Temperature.this, Storage.class));
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
            temp.setText("Teplota: "+event.values[0]+" °C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
