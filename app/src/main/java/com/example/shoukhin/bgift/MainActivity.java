package com.example.shoukhin.bgift;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.asp.fliptimerviewlibrary.CountDownClock;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Calendar currentTime;
    private Calendar birthDay;

    private CountDownClock timerProgramCountdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setAlarm();

        initCountDown();

        stopService(new Intent(this, CalculateTime.class));
        startNotifying();
    }

    private void initCountDown() {
        timerProgramCountdown.startCountDown(birthDay.getTimeInMillis() - currentTime.getTimeInMillis());
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

    private void startNotifying(){
         if (currentTime.get(Calendar.MONTH) == birthDay.get(Calendar.MONTH)
                && currentTime.get(Calendar.DAY_OF_MONTH) == birthDay.get(Calendar.DAY_OF_MONTH)) {

            Intent i = new Intent(this, Surprise.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // set the new task and clear flags
            startActivity(i); //surprise starts
        } else
            startService(new Intent(this, CalculateTime.class));
    }

    private void initialize() {

        currentTime = Calendar.getInstance();
        birthDay = setBirthdayTime();

        String text = "" + CalculateTime.NAME + ",\n\n" + getResources().getString(R.string.letter_text);
        TextView textView = findViewById(R.id.text);
        textView.setText(text);

        timerProgramCountdown = findViewById(R.id.timerProgramCountdown);
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
}
