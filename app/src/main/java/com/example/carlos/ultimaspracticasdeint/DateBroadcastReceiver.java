package com.example.carlos.ultimaspracticasdeint;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Created by carlos on 21/02/18.
 */

public class DateBroadcastReceiver extends BroadcastReceiver {

    public static final int MI_NOTIFICACION_FECHA = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        String fecha = "No se ha seleccionado ninguna fecha";

        if (intent.getExtras() != null) {
            bundle = intent.getExtras();
            fecha = bundle.getString(PrincipalActivity.BUNDLE_BROADCAST_FECHA);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "UltimasPracticasDEINT");

        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_notification_fecha));
        builder.setSmallIcon(R.drawable.ic_notification_fecha);
        builder.setContentTitle("Se ha seleccionado una fecha");
        builder.setContentText("Pulse para más información...");

        Intent newIntent = new Intent(context, DateInformationActivity.class);
        newIntent.putExtra(PrincipalActivity.BUNDLE_BROADCAST_FECHA, fecha);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, MI_NOTIFICACION_FECHA, newIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);

        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notification.flags = Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(MI_NOTIFICACION_FECHA, notification);

    }
}
