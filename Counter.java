package com.example.dallos.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Counter extends AppCompatActivity implements SensorEventListener {

    TextView tv_steps;
    SensorManager sensorManager;
    boolean running = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        SharedPreferences preferences = getSharedPreferences("MY_DATA",MODE_PRIVATE);
        int steps = preferences.getInt("MY_STEPS",0);
        int weight = preferences.getInt("MY_WEIGHT",0);

        ((TextView)findViewById(R.id.etSteps)).setText(steps+"");
        ((TextView)findViewById(R.id.wei)).setText(weight+"");

        tv_steps =(TextView)findViewById(R.id.tv_steps);






        Button btnSavee = (Button)findViewById(R.id.btnSavee);

        btnSavee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                String step = tv_steps.getText().toString();


                Intent prof = new Intent(Counter.this,log.class);
                prof.putExtra("Steps",step);
                startActivity(prof);

            }
        });



        tv_steps = (TextView) findViewById(R.id.tv_steps);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor counterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(counterSensor != null)
        {
            sensorManager.registerListener(this,counterSensor,sensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(this,"Sensor not found",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        running =false;
        //sensorManager.unregisterListener();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if(running){
            tv_steps.setText(String.valueOf(sensorEvent.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }





}
