package com.example.shoukhin.bgift;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CalculateTime extends Service {

    private boolean quit = false;
    public static int bithdDate = 10;
    public static int  birthMonth = 2; // 0 based index
    public static String NAME = "Tamim";
    private Calendar birthDay;
    private static Context context;


    public CalculateTime() {
    }



    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        birthDay = MainActivity.setBirthdayTime();

        context = this;

       // MainActivity.show("service started");

        new Thread() {
            @Override
            public void run() {
                while (!quit) {

                    notification();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void notification() {

        Calendar calendar = Calendar.getInstance();

        long diff = Math.abs(calendar.getTimeInMillis() - birthDay.getTimeInMillis());

        long diffDay = TimeUnit.MILLISECONDS.toDays(diff);
        long diffHour = TimeUnit.MILLISECONDS.toHours(diff) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(diff));
        long diffMinute = TimeUnit.MILLISECONDS.toMinutes(diff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff));
        long diffSecond = TimeUnit.MILLISECONDS.toSeconds(diff) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff));

        //MainActivity.show("" + diffSecond);

        Intent intnt = new Intent(context, MainActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intnt, 0);

        Notification n = new Notification.Builder(context)
                .setContentTitle("Remaining Time").setContentText(diffDay + " Days " + diffHour + " Hours " + diffMinute + " Min " + diffSecond + " s")
                .setContentIntent(pIntent).setSmallIcon(R.drawable.notification_icon)
                .build();

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(0, n);
    }

    @Override
    public void onDestroy() {
        quit = true;
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
