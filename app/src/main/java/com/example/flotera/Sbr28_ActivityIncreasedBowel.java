package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Sbr28_ActivityIncreasedBowel extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    LinearLayout zoomin,zoomout;
    ImageView btn_home;
    MediaPlayer swish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr28_activity_increased_bowel_movement);

        detector = new SimpleGestureFilter(this,this);

        swish = MediaPlayer.create(this, R.raw.swish);
        swish.setLooping(false);
        casting();
        function();

    }

    public void casting(){
        zoomin = (LinearLayout) findViewById(R.id.zoomin);
        zoomout = (LinearLayout) findViewById(R.id.zoomout);
        btn_home = (ImageView) findViewById(R.id.btn_home);
    }

    public void function(){
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              zoomin.setClickable(false);
              zoomout.setVisibility(View.VISIBLE);
            }
        });
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomin.setClickable(true);
                zoomout.setVisibility(View.INVISIBLE);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr28_ActivityIncreasedBowel.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });
    }

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            //swipe left to right
            case SimpleGestureFilter.SWIPE_RIGHT:
                swish.start();
                Intent a = new Intent(Sbr28_ActivityIncreasedBowel.this, Sbr27_ActivityClicallyProven.class);
                startActivity(a);
                finish();

                break;


            //swipe right to left
            case SimpleGestureFilter.SWIPE_LEFT:
                swish.start();
                Intent b = new Intent(Sbr28_ActivityIncreasedBowel.this, Sbr29_Activity100percent.class);
                startActivity(b);
                finish();


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
