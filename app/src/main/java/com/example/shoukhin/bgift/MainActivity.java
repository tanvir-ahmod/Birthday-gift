package com.example.shoukhin.bgift;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //TextView name, day, hour, minute, second;
    // TextView patiendHeader, dayHeader, hourHeader, minuteHeader, secondHeader;

    private static Calendar currentTime;
    private static Calendar birthDay;

    // private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        //calculateTime();
        setAlarm();

        //stopService(new Intent(getBaseContext(), CalculateTime.class));

        if (currentTime.get(Calendar.MONTH) == birthDay.get(Calendar.MONTH) && currentTime.get(Calendar.DAY_OF_MONTH) == birthDay.get(Calendar.DAY_OF_MONTH)) {
            //surprise starts
            Intent i = new Intent(this, Surprise.class);
            // set the new task and clear flags
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else
            startService(new Intent(this, CalculateTime.class));
    }

    public void setAlarm() {

        currentTime = Calendar.getInstance();
        birthDay = setBirthdayTime();

        //if alarm time is greater than current time
        if (birthDay.getTimeInMillis() > currentTime.getTimeInMillis()) {

            Intent intent = new Intent(this, Alarm.class);
            PendingIntent mAlarmSender = PendingIntent.getBroadcast(this, 0,
                    intent, 0);

            AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            if (alarmMgr != null) {
                alarmMgr.set(AlarmManager.RTC_WAKEUP, birthDay.getTimeInMillis(), mAlarmSender);
            }

        }

    }

    private void initialize() {
       /* name = (TextView) findViewById(R.id.name_tbx);
        day = (TextView) findViewById(R.id.day_tbx);
        hour = (TextView) findViewById(R.id.hour_tbx);
        minute = (TextView) findViewById(R.id.minute_tbx);
        second = (TextView) findViewById(R.id.second_tbx);

        patiendHeader = (TextView) findViewById(R.id.patient_tbx);
        dayHeader = (TextView) findViewById(R.id.day_header_tbx);
        hourHeader = (TextView) findViewById(R.id.hours_header_tbx);
        minuteHeader = (TextView) findViewById(R.id.minute_header_tbx);
        secondHeader = (TextView) findViewById(R.id.second_header_tbx);

        name.setText(CalculateTime.NAME);

        Typeface t = Typeface.createFromAsset(getAssets(), "fonts/BUXTONSKETCH.TTF");
        Typeface t3 = Typeface.createFromAsset(getAssets(), "fonts/SCRATCHMYBACK.TTF");

        name.setTypeface(t3);
        day.setTypeface(t);
        hour.setTypeface(t);
        minute.setTypeface(t);
        second.setTypeface(t);
        patiendHeader.setTypeface(t);
        dayHeader.setTypeface(t);
        hourHeader.setTypeface(t);
        minuteHeader.setTypeface(t);
        secondHeader.setTypeface(t);*/

        currentTime = Calendar.getInstance();
        birthDay = setBirthdayTime();
    }

    public static Calendar setBirthdayTime() {
        Calendar tempBirthDay = Calendar.getInstance();
        tempBirthDay.set(Calendar.DAY_OF_MONTH, CalculateTime.birthDate);
        tempBirthDay.set(Calendar.MONTH, CalculateTime.birthMonth);
        tempBirthDay.set(Calendar.HOUR_OF_DAY, 0);
        tempBirthDay.set(Calendar.MINUTE, 0);
        tempBirthDay.set(Calendar.SECOND, 0);

        return (Calendar) tempBirthDay.clone();
    }

    /*private void calculateTime() {
        new Thread() {
            public void run() {
                while (flag) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            currentTime = Calendar.getInstance();

                            long diff = Math.abs(currentTime.getTimeInMillis() - birthDay.getTimeInMillis());

                            long diffDay = TimeUnit.MILLISECONDS.toDays(diff);
                            long diffHour = TimeUnit.MILLISECONDS.toHours(diff) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(diff));
                            long diffMinute = TimeUnit.MILLISECONDS.toMinutes(diff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff));
                            long diffSecond = TimeUnit.MILLISECONDS.toSeconds(diff) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff));

                            if(diffDay == 0 && diffHour == 0 && diffMinute == 0 && diffSecond == 0)
                                stopService(new Intent(getBaseContext(), CalculateTime.class));

                            day.setText(String.valueOf(diffDay));
                            hour.setText(String.valueOf(diffHour));
                            minute.setText(String.valueOf(diffMinute));
                            second.setText(String.valueOf(diffSecond));
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }*/

   /* public static void show(String data) {
        Log.d("tag", data);
    }*/


}
