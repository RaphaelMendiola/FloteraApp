package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Sbr27_ActivityClicallyProven extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    ImageView btn_home,animate;
//    MediaPlayer mp;
MediaPlayer swish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr27_activity_clically_proven_probiotic);

        detector = new SimpleGestureFilter(this,this);
//        mp = MediaPlayer.create(this, R.raw.cry_baby);
//        mp.start();
//        mp.setLooping(true);
        swish = MediaPlayer.create(this, R.raw.swish);
        swish.setLooping(false);
        casting();
        function();


        animate.setBackgroundResource(R.drawable.animationlist_bula2);


        AnimationDrawable frameAnimation = (AnimationDrawable) animate
                .getBackground();
        frameAnimation.start();

    }

    public void casting(){

        btn_home = (ImageView) findViewById(R.id.btn_home);
        animate = (ImageView)findViewById(R.id.animate);

    }

    public void function(){

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp.stop();
                Intent a = new Intent(Sbr27_ActivityClicallyProven.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent a = new Intent(Sbr27_ActivityClicallyProven.this, Sbr20_ActivityOtherFgid.class);
//                startActivity(a);
//                finish();
//            }
//        });

    }

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            //swipe left to right
            case SimpleGestureFilter.SWIPE_RIGHT:
//                mp.stop();
                swish.start();
                Intent a = new Intent(Sbr27_ActivityClicallyProven.this, Sbr20_ActivityOtherFgid.class);
                startActivity(a);
                finish();
                break;


            //swipe right to left
            case SimpleGestureFilter.SWIPE_LEFT:
//                mp.stop();
                swish.start();
                Intent b = new Intent(Sbr27_ActivityClicallyProven.this, OtherFgidNewSlide.class);
                startActivity(b);
                finish();

                break;
        }
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
//        mp.pause();
    }

    @Override
    protected void onResume() {
//        if(mp != null && !mp.isPlaying())
//            mp.start();
        super.onResume();
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
