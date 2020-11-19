package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.modelpaper.Database.DBHelper;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    ListView userlist;
    ArrayList datalist;
    ArrayAdapter adapter;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userlist = findViewById(R.id.users_list);

        dbHelper = new DBHelper(getApplicationContext());
        datalist = dbHelper.readAllInfo();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datalist);

        userlist.setAdapter(adapter);

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userlist.getItemAtPosition(position).toString();

                Toast.makeText(UserList.this, "User : "+text, Toast.LENGTH_SHORT).show();
            }
        });


    }
}