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

import java.util.List;

public class EditProfile extends AppCompatActivity {

    EditText username,password,dob;
    Button search, delete, edit, list;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username = findViewById(R.id.etUserNameEP);
        password = findViewById(R.id.etPasswordEP);
        dob = findViewById(R.id.etdobEP);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        search = findViewById(R.id.btnSearchEP);
        edit = findViewById(R.id.btnEditEP);
        delete = findViewById(R.id.btnDeleteEP);
        list = findViewById(R.id.btnlist);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbHelper = new DBHelper(getApplicationContext());

                List user = dbHelper.readAllInfo(username.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(EditProfile.this, "No User", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else {

                    Toast.makeText(EditProfile.this, "User Found : User"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    dob.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());

                    if (user.get(3).toString().equals("Male")){
                        male.setChecked(true);
                    }
                    else {
                        female.setChecked(false);
                    }
                }

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (male.isChecked()){
                    gender = "Male";
                }
                else {
                    gender = "Female";
                }

                DBHelper dbHelper = new DBHelper(getApplicationContext());
                Boolean status = dbHelper.updateInfor(username.getText().toString(),password.getText().toString(),dob.getText().toString(),gender);

            if(status){
                Toast.makeText(EditProfile.this, "User Updated", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(EditProfile.this, "Update  Failed", Toast.LENGTH_SHORT).show();
            }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbHelper = new DBHelper(getApplicationContext());

                dbHelper.deleteInfo(username.getText().toString());

                Toast.makeText(EditProfile.this, "User Deleted", Toast.LENGTH_SHORT).show();

                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(false);
                female.setChecked(false);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EditProfile.this,UserList.class);
                startActivity(intent);
            }
        });
    }
}