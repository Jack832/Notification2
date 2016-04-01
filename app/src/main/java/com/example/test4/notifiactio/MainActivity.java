package com.example.test4.notifiactio;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void show(View v)
    {
        NotificationCompat.Builder builder= new  NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("AA re Ho kya");
        builder.setContentText("aa jaoo");
        NotificationCompat.InboxStyle inboxStyle= new NotificationCompat.InboxStyle();
        String nam[]= new String[4];
        nam[0]="hii";
        nam[1]="added";
        nam[2]="removed from group";
        nam[3]="hello";
       inboxStyle.setBigContentTitle("ToDA");
        for(String m:nam)
        {
            inboxStyle.addLine(m);
        }
        builder.setStyle(inboxStyle);
        Intent intent= new Intent(this,Second.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Second.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_CANCEL_CURRENT );
        builder.setContentIntent(pendingIntent);
        NotificationManager Nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Nm.notify(0,builder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
