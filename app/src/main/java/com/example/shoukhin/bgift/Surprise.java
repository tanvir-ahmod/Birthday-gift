package com.example.shoukhin.bgift;

import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Surprise extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_surprice);


        videoView = (VideoView) findViewById(R.id.videoView1);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+ "/" + R.raw.video));
        videoView.start();
       new CountDownTimer(100000,1000){ //video length is 1 min 38 sec

           @Override
           public void onTick(long millisUntilFinished) {
           }

           @Override
           public void onFinish() {

               Surprise.this.finish();
           }
       }.start();
    }
}
