package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.aliments.R;

import java.util.Objects;

public class NotificationsActivity extends AppCompatActivity {
    public static final String CHANNEL_1_ID = "channel LOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        createNotificationChannels();
        findViewById( R.id.buttonNotify1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ((EditText)findViewById( R.id.edit_text_title)).getText().toString();
                String message = ((EditText)findViewById( R.id.edit_text_message)).getText().toString();
                sendNotificationOnChannel( title, message, CHANNEL_1_ID, NotificationCompat.PRIORITY_HIGH);
            }
        });
    }

    private void sendNotificationOnChannel(String title, String message, String channelId, int priority) {
        NotificationCompat.Builder notification =
                new NotificationCompat.Builder( getApplicationContext(), channelId)
                        .setSmallIcon( R.drawable.shopping_cart )
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(priority)
                        .setAutoCancel(true);
        NotificationManagerCompat.from(this).notify( 0 , notification.build() );
    }

    private NotificationChannel createNotificationChannel (String channelID, CharSequence name, int importance, String channelDescription){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelID, name, importance);
            channel.setDescription(channelDescription);
            return channel;
        }

        return null;
    }

    private void createNotificationChannels (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = createNotificationChannel(CHANNEL_1_ID, "Channel 1",
                    NotificationManager.IMPORTANCE_LOW, "low");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel1);
        }
    }

        /*Intent intent = new Intent(NotificationsActivity.this, ReponseNotifActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("message", message);

        PendingIntent pendingIntent = PendingIntent.getActivities(NotificationsActivity.this, 0, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);*/
}