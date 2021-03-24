package com.example.dallos.fitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        double po = 0.45;
        double fee = 3.28;

        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);

        int weight = preferences.getInt("MY_WEIGHT",0);
        int height = preferences.getInt("MY_HEIGHT",0);


        ((TextView)findViewById(R.id.kg)).setText(weight+"");
        ((TextView)findViewById(R.id.meters)).setText(height+"");



        Button btnS = (Button)findViewById(R.id.btnS);
        //weight
        TextView t1 = (TextView)findViewById(R.id.kg);
        TextView t2 = (TextView)findViewById(R.id.pounds);
        double num = Integer.parseInt(t1.getText().toString());
        double sum = num * po;
        t2.setText(Double.toString(sum));

        //height
        TextView t4 = (TextView)findViewById(R.id.meters);
        TextView t5 = (TextView)findViewById(R.id.feet);
        int num1 = Integer.parseInt(t4.getText().toString());
        double sum1 = num1 * fee;
        t5.setText(Double.toString(sum1));



        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(Setting.this,home.class);
                startActivity(in);

            }
        });
    }
}
