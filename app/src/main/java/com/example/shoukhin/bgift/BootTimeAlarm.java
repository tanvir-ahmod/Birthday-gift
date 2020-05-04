package com.example.shoukhin.bgift;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class BootTimeAlarm extends BroadcastReceiver {
    public BootTimeAlarm() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //setting boot time alarm,
            Calendar currentTime = Calendar.getInstance();
            Calendar birthDay = Constants.getTargetCalendar();

            //if alarm time is greater than current time
            if (birthDay.getTimeInMillis() > currentTime.getTimeInMillis()) {

                Intent intnt = new Intent(context, Alarm.class);
                // Schedule the alarm!
                PendingIntent mAlarmSender = PendingIntent.getBroadcast(context, 0,
                        intnt, 0);

                AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                if (alarmMgr != null) {
                    alarmMgr.set(AlarmManager.RTC_WAKEUP, birthDay.getTimeInMillis(), mAlarmSender);
                }
            }
        }
    }
}
