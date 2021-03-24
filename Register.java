package com.example.dallos.fitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Spharh.
 */

public class Register extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText password= (EditText) findViewById(R.id.etNewPassword);

        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();


                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUser + newPassword + "data","");
                editor.commit();

                Intent profile = new Intent(Register.this, profile_info.class);
                startActivity(profile);
            }
        });




    }
}
