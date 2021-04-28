package com.example.aliments.modeles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;

import com.example.aliments.vues.ConsulterAlimentActivity;
import com.example.aliments.vues.ListeCoursesPrefereesActivity;
import com.example.aliments.vues.SearchAlimentActivity;

public class NotificationReceiver extends BroadcastReceiver {
    public static String msg = "message";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        NotificationManagerCompat notifManager = NotificationManagerCompat.from(context);

        notifManager.cancel(Notification.notif_Id - 1);

        Intent intent1 = new Intent(context, SearchAlimentActivity.class);
        context.startActivity(intent1);
    }
}
