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

public class profile_info extends AppCompatActivity
{
    private EditText etName;
    private EditText etSurname;
    private EditText etGender;
    private EditText etEmail;
    private EditText etWeight;
    private EditText etHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_info);

        final SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String name = preferences.getString("MY_NAME","");
        String surname = preferences.getString("MY_SURNAME","");
        String gender = preferences.getString("MY_GENDER","");
        String email = preferences.getString("MY_EMAIL","");
        int weight = preferences.getInt("MY_WEIGHT",0);
        int height = preferences.getInt("MY_HEIGHT",0);

        etName = (EditText)findViewById(R.id.etName);
        etSurname = (EditText)findViewById(R.id.etSurname);
        etGender = (EditText)findViewById(R.id.etGender);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etWeight = (EditText)findViewById(R.id.etWeight);
        etHeight = (EditText)findViewById(R.id.etHeight);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //set default value
        etName.setText(name);
        etSurname.setText(surname);
        etGender.setText(gender);
        etEmail.setText(email);
        etWeight.setText(weight+"");
        etHeight.setText(height+"");


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //get input
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String gender = etGender.getText().toString();
                String email = etEmail.getText().toString();
                int weight = Integer.parseInt(etWeight.getText().toString());
                int height = Integer.parseInt(etHeight.getText().toString());

                //save data
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("MY_NAME",name);
                editor.putString("MY_SURNAME",surname);
                editor.putString("MY_GENDER",gender);
                editor.putString("MY_EMAIL",email);
                editor.putInt("MY_WEIGHT",weight);
                editor.putInt("MY_HEIGHT",height);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();

                Intent registerScreen = new Intent(profile_info.this,home.class);
                startActivity(registerScreen);
            }
        });






    }



}