package com.example.modelpaper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Broadcast_Receivers_Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String BROADCAST_ACTION = "com.example.modelpaper.BROADCAST_MESSAGE";
    Button btnStart;
    public TextView txtViewMsg;
    private Receiver localListerner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast__receivers_);
        txtViewMsg = (TextView) findViewById(R.id.textView14);
        btnStart = (Button) findViewById(R.id.btn_broadcast);
        btnStart.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        this.registerReceiver(localListerner, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(localListerner);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_broadcast) {
            BroadcastService.startAction(this.getApplicationContext());
        }

    }

    public class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String currentText = txtViewMsg.getText().toString();
            String message = intent.getStringExtra("value");
            currentText += "\nReceived" + message;
            txtViewMsg.setText(currentText);

        }
    }
}