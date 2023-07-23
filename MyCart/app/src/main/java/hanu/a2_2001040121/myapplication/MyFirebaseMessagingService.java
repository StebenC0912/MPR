package hanu.a2_2001040121.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Locale;


public class MyFirebaseMessagingService extends FirebaseMessagingService implements TextToSpeech.OnInitListener{
    // generate the notification
    // attach the notification created with custom layout
    // show the notification
    private final String channel_id = "channel_id";
    private final String channel_name = "channel_name";
    private final String channel_description = "channel_description";
    private TextToSpeech textToSpeech;
    private String title;
    private String description;
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        if (message.getNotification() != null) {
            title = message.getNotification().getTitle();
            description = message.getNotification().getBody();
            generateNotification(title, description);
            textToSpeech = new TextToSpeech(this, this);
            Toast.makeText(this, "Notification received", Toast.LENGTH_SHORT).show();
        }
    }

    public void generateNotification(String title, String description) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE);

        // channel id, channel name, channel description
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channel_id)
                .setSmallIcon(R.drawable.shopping_cart)
                .setAutoCancel(true)
                .setVibrate(new long[]{1000, 1000, 1000, 1000})
                .setContentTitle(title)
                .setOnlyAlertOnce(false)
                .setContentIntent(pendingIntent);
        builder = builder.setContent(getRemoteView(title, description));
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // channel id, channel name, channel description
            NotificationChannel channel = new NotificationChannel(channel_id, channel_name, NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0, builder.build());
        textToSpeech.speak(title + " " + description, TextToSpeech.QUEUE_FLUSH, null);
    }

    private RemoteViews getRemoteView(String title, String description) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.app_name, title);
        remoteViews.setTextViewText(R.id.description, description);
        remoteViews.setImageViewResource(R.id.app_logo, R.drawable.shopping_cart);
        return remoteViews;
    }


    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.US);
        } else {
            textToSpeech = null;
        }
    }
}
