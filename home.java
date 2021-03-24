package com.example.dallos.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Spharh.
 */

public class home extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnSet = (Button) findViewById(R.id.btnSet);
        Button btnProfile = (Button) findViewById(R.id.btnProfile);
        Button btnCapture = (Button) findViewById(R.id.btnCapture);
        Button btnSetting = (Button) findViewById(R.id.btnSetting);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        Button btnLog = (Button) findViewById(R.id.btnLog);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prof = new Intent(home.this,myprofile.class);
                startActivity(prof);

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent prof = new Intent(home.this,Login.class);
                startActivity(prof);
            }
        });
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prof = new Intent(home.this,goals.class);
                startActivity(prof);

            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prof = new Intent(home.this,Counter.class);
                startActivity(prof);
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prof = new Intent(home.this,log.class);
                startActivity(prof);

            }
        });
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prof = new Intent(home.this,Camera.class);
                startActivity(prof);


            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prof = new Intent(home.this,Setting.class);
                startActivity(prof);
            }
        });
    }
}
