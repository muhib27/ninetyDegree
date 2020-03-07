package com.muhib.ninetydegree;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class FCMBroadcastReciverService extends FirebaseMessagingService {
    private static final String TAG = "FCMBroadcastReciverService";
    public static final String LOCAL_BR_FCM_NOTIFICATION = "";
    String title = "", body = "";

    @SuppressLint("LongLogTag")
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        if (remoteMessage.getData() !=null) {

                Log.d(TAG, "Message data payload: " + remoteMessage.getData());
                // Map<String, String> data = remoteMessage.getData();
                String title = remoteMessage.getData().get("title");
                String img = remoteMessage.getData().get("image_url");
                String msg = remoteMessage.getData().get("message");
                String subtitle = remoteMessage.getData().get("subtitle");

                Log.v("msg", "");

//                if(remoteMessage.getData().get("activity_value")!=null && !remoteMessage.getData().get("activity_value").isEmpty())
//                    threeDays = remoteMessage.getData().get("activity_value");
                sendNotification( title, img, msg,  subtitle);


        }

    }

    @SuppressLint("LongLogTag")
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d(TAG, "Refreshed token: " + s);
        ///Toasty.success(this,"token"+ s, Toasty.LENGTH_SHORT).show();
        final Intent intent = new Intent("tokenReceiver");
        final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        intent.putExtra("token",s);
        broadcastManager.sendBroadcast(intent);
        sendRegistrationToServer(s);
    }

    private void sendRegistrationToServer(String token) {
        SharedPrefsHandler sharedPrefsHandler = new SharedPrefsHandler(this);
        sharedPrefsHandler.setFCMRegistrationID(token);
    }

    public int createID() {
        Date now = new Date();
        return Integer.parseInt(new SimpleDateFormat("ddHHmmss", Locale.ENGLISH).format(now));
    }


    private void sendNotification(String title, String img, String msg, String subtitle) {
    //    Intent intent = new Intent(this, DashboardActivity.class);
        Intent intent = null;
        String channelId = "fcm_default_channel";

//        Bitmap bmp = null;
//        String picture = "http://i.stack.imgur.com/CE5lz.png";
//        try {
//            bmp = Picasso.get().load(picture).get();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        NotificationCompat.BigPictureStyle bpStyle = new NotificationCompat.BigPictureStyle();
//        bpStyle.bigPicture(BitmapFactory.decodeResource(getResources(), bmp)).build();

            intent = new Intent(this, MainActivity.class);



        intent.putExtra("title", title);
        intent.putExtra("img", img);
        intent.putExtra("msg", msg);
        intent.putExtra("subtitle", subtitle);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        //.setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);
       // notificationBuilder.setStyle(bpStyle);
        notificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(msg));
//        Bitmap bmp = null;
//        String picture = "http://i.stack.imgur.com/CE5lz.png";
//        try {
//            bmp = Picasso.get().load(picture).get();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        if(bmp!=null)
//        notificationBuilder.setLargeIcon(bmp);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());





    }

}
