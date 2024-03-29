package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.modelpaper.Database.DBHelper;

public class ProfileManagement extends AppCompatActivity {

    EditText username,password,dob;
    Button add, update;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = findViewById(R.id.etUsernamePM);
        password = findViewById(R.id.etpasswordPM);
        dob = findViewById(R.id.etdobPM);
        male = findViewById(R.id.ramale);
        female = findViewById(R.id.rafemale);
        add = findViewById(R.id.btnAddPM);
        update = findViewById(R.id.btnupdatePM);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileManagement.this,EditProfile.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (male.isChecked()){
                    gender = "Male";
                }
                else {
                    gender = "Female";
                }

                DBHelper dbHelper = new DBHelper(getApplicationContext());
                long newID = dbHelper.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "User Added. User ID " + newID, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ProfileManagement.this,EditProfile.class);
                startActivity(intent);

                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(true);
                female.setChecked(false);

            }
        });
    }
}