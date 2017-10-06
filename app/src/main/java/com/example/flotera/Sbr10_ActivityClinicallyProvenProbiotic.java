package com.example.flotera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Sbr10_ActivityClinicallyProvenProbiotic extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    MediaPlayer mp,swish;
    ImageView animate;
    Context context;

//    LinearLayout zoomin,zoomout;
//    ImageView btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr10_activity_clinically_proven_probiotic);
        context = this;
        detector = new SimpleGestureFilter(this,this);

        mp = MediaPlayer.create(this, R.raw.cry_baby);
        mp.start();
        mp.setLooping(false);

        swish = MediaPlayer.create(this, R.raw.swish);
        swish.setLooping(false);


        casting();
        function();
        animate.setBackgroundResource(R.drawable.animationlist);

        AnimationDrawable frameAnimation = (AnimationDrawable) animate
                .getBackground();
        frameAnimation.start();




    }

    public void casting(){
//        btn_home = (ImageView) findViewById(R.id.btn_home);
        animate = (ImageView)findViewById(R.id.animate);
    }

    public void function(){

//        btn_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mp.stop();
//                Intent a = new Intent(Sbr10_ActivityClinicallyProvenProbiotic.this, MainActivity.class);
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
//                Intent a = new Intent(Sbr10_ActivityClinicallyProvenProbiotic.this, Sbr09_ActivitFloteraIsSafe.class);
//                startActivity(a);
//                finish();

                break;


            //swipe right to left
            case SimpleGestureFilter.SWIPE_LEFT:
                mp.stop();

                swish.start();
                Intent b = new Intent(Sbr10_ActivityClinicallyProvenProbiotic.this, Sbr11_ActivityWhatIsInfantilleColic.class);
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
