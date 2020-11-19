package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.modelpaper.Database.DBHelper;

public class Home extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = findViewById(R.id.etUsernameH);
        password = findViewById(R.id.etPasswordH);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProfileManagement.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbHelper = new DBHelper(getApplicationContext());
                if (dbHelper.loginUser(username.getText().toString(),password.getText().toString())){
                    Toast.makeText(Home.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),EditProfile.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Home.this, "Invalid User", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                    password.setText(null);
                }

            }
        });
    }
}