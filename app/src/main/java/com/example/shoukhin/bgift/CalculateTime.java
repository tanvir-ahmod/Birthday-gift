package com.example.shoukhin.bgift;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CalculateTime extends Service {

    private boolean quit = false;
    public static final int birthDate = 5;
    public static final int birthMonth = 4; // 0 based index
    public static final String NAME = "Test";
    private Calendar birthDay;


    public CalculateTime() {
    }


    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        birthDay = MainActivity.setBirthdayTime();

        new Thread() {
            @Override
            public void run() {
                while (!quit) {
                    notification();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
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

        Intent intnt = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intnt, 0);

        Notification n = new Notification.Builder(this)
                .setContentTitle("Remaining Time").setContentText(diffDay + " Days " + diffHour + " Hours " + diffMinute + " Min " + diffSecond + " s")
                .setContentIntent(pIntent).setSmallIcon(R.drawable.notification_icon)
                .build();

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (mNotificationManager != null)
            mNotificationManager.notify(0, n);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        quit = true;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
