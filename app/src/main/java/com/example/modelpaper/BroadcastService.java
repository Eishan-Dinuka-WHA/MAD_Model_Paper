package com.example.modelpaper;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

public class BroadcastService  extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BroadcastService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){
            for(int i = 0 ; i < 5; i++ ){
                Intent localBroadcastIntent = new Intent(Broadcast_Receivers_Activity.BROADCAST_ACTION);
                localBroadcastIntent.putExtra("Vlaue","Broadcast " + (i+1));
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendBroadcast(localBroadcastIntent);
            }
        }
    }

    public static void  startAction(Context context){
        Intent intent = new Intent(context,BroadcastService.class);
        context.startService(intent);
    }
}
