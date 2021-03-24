package com.example.dallos.fitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class log extends AppCompatActivity {
    TextView tv;

    TextView tvSteps;
    TextView tvLoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);




        tvSteps = (TextView) findViewById(R.id.tvSteps);
        tvLoss = (TextView) findViewById(R.id.tvLoss);

        tv = (TextView)findViewById(R.id.tvSteps);

        tv.setText(getIntent().getStringExtra("Steps"));

        SharedPreferences preferences = getSharedPreferences("MY_DATA",MODE_PRIVATE);
        int steps = preferences.getInt("MY_STEPS",0);
        int weight = preferences.getInt("MY_WEIGHT",0);

        ((TextView)findViewById(R.id.tvStepsTargeted)).setText(steps+"");
        ((TextView)findViewById(R.id.tvTargeted)).setText(weight+"");





        Button btnSavelog = (Button) findViewById(R.id.btnSavelog);

        btnSavelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences shared = getSharedPreferences("INFO",MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("MY_STEPS",tvSteps.getText().toString());
                editor.putString("MY_WEIGHT",tvLoss.getText().toString());
                editor.apply();
                Intent prof = new Intent(log.this,home.class);
                startActivity(prof);

            }
        });
    }
}
