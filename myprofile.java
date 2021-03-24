package com.example.dallos.fitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Spharh.
 */

public class myprofile extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile);

        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);

        String name = preferences.getString("MY_NAME","no name");
        String surname = preferences.getString("MY_SURNAME","no surname");
        String gender = preferences.getString("MY_GENDER","no gender");
        String email = preferences.getString("MY_EMAIL","no email");
        int weight = preferences.getInt("MY_WEIGHT",0);
        int height = preferences.getInt("MY_HEIGHT",0);

        //setting values
        ((TextView)findViewById(R.id.txtName)).setText(name);
        ((TextView)findViewById(R.id.txtSurname)).setText(surname);
        ((TextView)findViewById(R.id.txtGender)).setText(gender);
        ((TextView)findViewById(R.id.txtEmail)).setText(email);
        ((TextView)findViewById(R.id.txtWeight)).setText(weight+"");
        ((TextView)findViewById(R.id.txtHeight)).setText(height+"");

        Button btnEdit = (Button) findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent registerScreen = new Intent(myprofile.this,profile_info.class);
                startActivity(registerScreen);
            }
        });



    }


}
