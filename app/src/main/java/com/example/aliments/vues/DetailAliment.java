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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;

import java.util.Objects;

public class DetailAliment extends AppCompatActivity {
    public static final String CHANNEL_1_ID = "channel LOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_aliment);

        createNotificationChannels();

        EditText editName = findViewById(R.id.aliment_name2);
        editName.setText(AlimentControler.aliment.getName());

        EditText editPrix = findViewById(R.id.aliment_price2);
        editPrix.setText(AlimentControler.aliment.getPrix() + "");

        ImageView img = findViewById(R.id.aliment_icon);
        img.setImageResource(AlimentControler.aliment.getRsc());

        Button btnModif = findViewById(R.id.valider);
        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailAliment.this, ListeAlimentVendeurActivity.class);
                String name = editName.getText().toString();
                AlimentControler.getListeAliment().get(AlimentControler.aliment.getName()).setName(name);
                AlimentControler.getListeAliment().get(name).setPrix(Double.valueOf(editPrix.getText().toString()).doubleValue());
                AlimentControler.aliment = null;

                // notifier l'utilisateur d'un changement dans le prix
                sendNotificationOnChannel( "title", "message", CHANNEL_1_ID, NotificationCompat.PRIORITY_HIGH);

                startActivity(intent);
            }
        });

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailAliment.this, ListeAlimentVendeurActivity.class);
                AlimentControler.aliment = null;
                startActivity(intent);
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
}