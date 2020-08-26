package com.example.shoukhin.bgift;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class BootTimeAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Calendar currentTime = Calendar.getInstance();
            Calendar birthDay = Constants.getTargetCalendar();

            if (birthDay.getTimeInMillis() > currentTime.getTimeInMillis()) {
                Intent alarmIntent = new Intent(context, Alarm.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
                        alarmIntent, 0);

                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                if (alarmManager != null) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, birthDay.getTimeInMillis(), pendingIntent);
                }
            }
        }
    }
}
