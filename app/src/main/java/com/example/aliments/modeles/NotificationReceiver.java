package com.example.aliments.modeles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;

import com.example.aliments.App;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.vues.ConsulterAlimentActivity;
import com.example.aliments.vues.DetailAliment;
import com.example.aliments.vues.ListeCoursesPrefereesActivity;
import com.example.aliments.vues.SearchAlimentActivity;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Aliment aliment = intent.getParcelableExtra("aliment");
        AlimentControler.aliment = aliment;
        int id = intent.getIntExtra("id", Notification.notif_Id);

        NotificationManagerCompat nM = NotificationManagerCompat.from(context);
        nM.cancel(id);

        Intent intent1 = new Intent(context, ConsulterAlimentActivity.class);
        context.startActivity(intent1);
    }
}
