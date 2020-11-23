package com.example.videostream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    VideoView vv;
    Button btn;
    ProgressBar pgbar;
    public int i=1;
    public String str="https://dashboard.blomp.com/dashboard/storage/download_object?path=va.mp4&filename=va.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv=findViewById(R.id.video);
        btn=findViewById(R.id.btn);
        pgbar=findViewById(R.id.pgbar);

        play("http://192.168.43.105/video/v2.mp4");
        play("rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");
        play(str);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             //  vv.stopPlayback();
            //  play("http://192.168.43.105/video/v"+String.valueOf(i)+".mp4");
              if(i%2==0)
                  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
              else
                  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
              i++;
            //  if(i>4)i=1;
           }
       });
    }
    public void play(String v3) {
        if (!vv.isPlaying()) {
            try {
                MediaController mediacontroller = new MediaController(this);
                mediacontroller.setAnchorView(vv);
                Uri video = Uri.parse(v3);
                vv.setMediaController(mediacontroller);
                vv.setVideoURI(video);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            vv.requestFocus();
            vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    vv.start();
                }
            });
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 1000);
                    //  Toast.makeText(MainActivity.this,String.valueOf(vv.getBufferPercentage()),Toast.LENGTH_SHORT).show();
                    if (!vv.isPlaying()) {
                        pgbar.setVisibility(View.VISIBLE);
                    }
                    if (vv.isPlaying()) {
                        pgbar.setVisibility(View.INVISIBLE);
                    }

                }
            };
            handler.postDelayed(runnable, 1000);


        }
    }
}