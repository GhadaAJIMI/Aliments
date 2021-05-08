package com.example.aliments.modeles;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.RemoteViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.aliments.App;
import com.example.aliments.R;
import com.example.aliments.vues.CreerUneListeCoursePreferee;
import com.example.aliments.vues.ListeCoursesPrefereesActivity;

import java.util.Objects;

public class Notification {
    public static int notif_Id = 0;
    public static final String SIMPLE = "simple";
    private String title;
    private Aliment aliment;
    private String message;
    private int srcImg;
    private AppCompatActivity context;
    Intent intent;
    PendingIntent pendingIntent;
    int id = 0;

    // constructeur
    public Notification(String title, String message, Aliment aliment, AppCompatActivity context, String type) {
        this.title = title;
        this.message = message;
        this.aliment = aliment;
        this.srcImg = aliment.getRsc();
        this.context = context;
        if(type.equals(SIMPLE))
            sendNotificationOnChannel();
        else
            showNotification();
    }

    // constructeur
    public Notification(String title, String message, int src, AppCompatActivity context, String type) {
        this.title = title;
        this.message = message;
        this.srcImg = src;
        this.context = context;
        if(type.equals(SIMPLE))
            sendNotificationOnChannel();
        else
            showNotification();
    }

    // méthodes
    public void sendNotificationOnChannel() {
        NotificationCompat.Builder notification =
                new NotificationCompat.Builder( this.context.getApplicationContext(), App.CHANNEL_2_ID)
                        .setSmallIcon(this.srcImg)
                        .setContentTitle(this.title)
                        .setContentText(this.message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setAutoCancel(true);
        NotificationManagerCompat.from(this.context).notify(notif_Id++ , notification.build());
    }

    public void showNotification() {
        RemoteViews collapsedView = new RemoteViews(this.context.getPackageName(), R.layout.notification_collapsed);
        RemoteViews expendedView = new RemoteViews(this.context.getPackageName(), R.layout.notification_expended);

        collapsedView.setTextViewText(R.id.text_titre_collapsed, this.title);
        collapsedView.setTextViewText(R.id.text_msg, this.message);

        expendedView.setImageViewResource(R.id.image_notif, this.srcImg);
        expendedView.setTextViewText(R.id.text_titre_expended, this.title);

        intent = new Intent(this.context, NotificationReceiver.class);
        intent.putExtra("aliment", this.aliment);
        pendingIntent = PendingIntent.getBroadcast(this.context, notif_Id, intent, PendingIntent.FLAG_ONE_SHOT);
        id = notif_Id;
        expendedView.setOnClickPendingIntent(R.id.image_notif, pendingIntent);

        NotificationCompat.Builder notification =
                new NotificationCompat.Builder( this.context.getApplicationContext(), App.CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.shopping_cart)
                        .setCustomContentView(collapsedView)
                        .setCustomBigContentView(expendedView)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                        .setAutoCancel(true);
        NotificationManagerCompat.from(this.context).notify(notif_Id++ , notification.build());
        App.listNotif.add(this);
    }
}
