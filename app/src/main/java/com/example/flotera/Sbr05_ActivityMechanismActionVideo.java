package com.example.flotera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Sbr05_ActivityMechanismActionVideo extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;

    Context context;

    VideoView videoView;
    ImageView btn_close, btn_replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr05_mechanism_action_video);

        detector = new SimpleGestureFilter(this,this);
        context = this;
        casting();
        function();
        setContent();

    }

    public void casting(){

        videoView = (VideoView) findViewById(R.id.videoView);
        btn_close = (ImageView) findViewById(R.id.btn_close);
        btn_replay = (ImageView) findViewById(R.id.btn_replay);

    }

    public void function(){

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sbr05_ActivityMechanismActionVideo.this, Sbr05_ActivityMechanismAction.class);
                startActivity(i);
                finish();
            }
        });

        btn_replay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                videoView.start();
                btn_replay.setVisibility(View.GONE);

            }
        });
    }


    private void setContent1() {

        String uriPath = "android.resource://" + context.getPackageName()
                + "/raw/" + "bg_video";

        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.setLooping(true);
            }
        });
        videoView.start();


    }

    private void setContent() {

        MediaController controller = new MediaController(this);
        controller.setAnchorView(this.videoView);
        controller.setAnchorView(this.videoView);
        this.videoView.setMediaController(controller);

        String uriPath = "android.resource://" + context.getPackageName()
                + "/raw/" + "video";

        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.setLooping(false);
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        // Start a new activity or do whatever else you want
                        // here

                        btn_replay.setVisibility(View.VISIBLE);
                    }
                });

    }

    @Override
    public void onResume() {
        super.onResume();
        videoView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        videoView.pause();
    }

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            //swipe left to right
            case SimpleGestureFilter.SWIPE_RIGHT:

                break;


            //swipe right to left
            case SimpleGestureFilter.SWIPE_LEFT:



                break;
        }
    }

    @Override
    public void onDoubleTap() {

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // TODO Auto-generated method stub
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);

    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        super.onBackPressed();
        final Intent relaunch = new Intent(this, Exiter.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(relaunch);
    }

}
