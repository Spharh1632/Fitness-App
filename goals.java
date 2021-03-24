package com.example.dallos.fitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Spharh.
 */

public class goals extends AppCompatActivity {
    private EditText etStepsy;
    private EditText etWeightloss;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals);

        preferences = getSharedPreferences("MY_DATA",MODE_PRIVATE);
        int steps = preferences.getInt("MY_STEPS",0);
        final int weight = preferences.getInt("MY_WEIGHT",0);

        etStepsy = (EditText)findViewById(R.id.etStepsy);
        etWeightloss = findViewById(R.id.etWeightloss);

        etStepsy.setText(steps+"");
        etWeightloss.setText(weight+"");




        Button btnSaveInf = (Button) findViewById(R.id.btnSaveInf);


        btnSaveInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int steps = Integer.parseInt(etStepsy.getText().toString());
                int weight = Integer.parseInt(etWeightloss.getText().toString());

                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("MY_STEPS",steps);
                editor.putInt("MY_WEIGHT",weight);
                editor.apply();

                startActivity(new Intent(getApplicationContext(),home.class));




                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();






            }
        });
    }
}
