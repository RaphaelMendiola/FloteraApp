package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Sbr22_ActivityWhatIsInfantiel extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;

    MediaPlayer mp,swish;
    ImageView btn_home,animate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr22_activity_what_is_infantiel);

        detector = new SimpleGestureFilter(this,this);
        swish = MediaPlayer.create(this, R.raw.swish);
        swish.setLooping(false);
        mp = MediaPlayer.create(this, R.raw.vomit);
        mp.start();
        mp.setLooping(false);

        casting();
        function();


        animate.setBackgroundResource(R.drawable.animationlist_lungad);


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
                mp.stop();
                Intent a = new Intent(Sbr22_ActivityWhatIsInfantiel.this, MainActivity.class);
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
                mp.stop();
                swish.start();
                Intent a = new Intent(Sbr22_ActivityWhatIsInfantiel.this, Sbr21_ActivityRegurgitation.class);
                startActivity(a);
                finish();
                break;


            //swipe right to left
            case SimpleGestureFilter.SWIPE_LEFT:
                mp.stop();
                swish.start();
                Intent b = new Intent(Sbr22_ActivityWhatIsInfantiel.this, NewRegulatory.class);
                startActivity(b);
                finish();

                break;
        }
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        if(mp != null && !mp.isPlaying())
            mp.start();
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
