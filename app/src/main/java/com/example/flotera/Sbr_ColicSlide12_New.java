package com.example.flotera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Sbr_ColicSlide12_New extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    ImageView zoom1,zoom2,zoom3,zoom4,big1,big2,big3,big4,btn_home;
    Animation zoom;
    MediaPlayer mp,swish;
    LinearLayout zoomout,circlegroup2;
    Context context;

    boolean swipable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbrcolicslide12_new);
        context = this;
        detector = new SimpleGestureFilter(this,this);

        mp = MediaPlayer.create(this, R.raw.laughing_baby);
        mp.start();
        mp.setLooping(false);
        swish = MediaPlayer.create(this, R.raw.swish);
        swish.setLooping(false);

        casting();
        function();


    }

    public void casting() {
        zoom1 = (ImageView) findViewById(R.id.zoom1);
        zoom2 = (ImageView) findViewById(R.id.zoom2);
        zoom3 = (ImageView) findViewById(R.id.zoom3);
        zoom4 = (ImageView) findViewById(R.id.zoom4);
        big1 = (ImageView) findViewById(R.id.big1);
        big2 = (ImageView) findViewById(R.id.big2);
        big3 = (ImageView) findViewById(R.id.big3);
        big4 = (ImageView) findViewById(R.id.big4);
        zoomout = (LinearLayout) findViewById(R.id.zoomout);
        btn_home = (ImageView) findViewById(R.id.btn_home);


    }

    public void function(){
        zoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp.stop();
                zoom1.setClickable(false);
                zoom2.setClickable(false);
                zoom3.setClickable(false);
                zoom4.setClickable(false);
                zoomout.setVisibility(View.VISIBLE);
                big1.setVisibility(View.VISIBLE);
                big2.setVisibility(View.INVISIBLE);
                big3.setVisibility(View.INVISIBLE);
                big4.setVisibility(View.INVISIBLE);

                swipable = false;

//                Intent intent = new Intent(context, Sbr17_ActivityPositiveEffectOnBreastPop.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivityForResult(intent, 0);
//                finish();

            }
        });
        zoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp.stop();
                zoom1.setClickable(false);
                zoom2.setClickable(false);
                zoom3.setClickable(false);
                zoom4.setClickable(false);
                zoomout.setVisibility(View.VISIBLE);
                big2.setVisibility(View.VISIBLE);
                big1.setVisibility(View.INVISIBLE);
                big3.setVisibility(View.INVISIBLE);
                big4.setVisibility(View.INVISIBLE);

                swipable = false;

//                Intent intent = new Intent(context, Sbr15_ActivityImproveFamilyQualityPop.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivityForResult(intent, 0);
//                finish();

            }
        });

        zoom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp.stop();
                zoom1.setClickable(false);
                zoom2.setClickable(false);
                zoom3.setClickable(false);
                zoom4.setClickable(false);
                zoomout.setVisibility(View.VISIBLE);
                big3.setVisibility(View.VISIBLE);
                big1.setVisibility(View.INVISIBLE);
                big2.setVisibility(View.INVISIBLE);
                big4.setVisibility(View.INVISIBLE);

                swipable = false;

//                Intent intent = new Intent(context, Sbr14_ActivityMoreThan45LessPop.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivityForResult(intent, 0);
//                finish();

            }
        });

        zoom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp.stop();
                zoom1.setClickable(false);
                zoom2.setClickable(false);
                zoom3.setClickable(false);
                zoom4.setClickable(false);
                zoomout.setVisibility(View.VISIBLE);
                big4.setVisibility(View.VISIBLE);
                big1.setVisibility(View.INVISIBLE);
                big2.setVisibility(View.INVISIBLE);
                big3.setVisibility(View.INVISIBLE);

                swipable = false;

//                Intent intent = new Intent(context, Sbr16_ActivityMorethan80percentPop.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivityForResult(intent, 0);
//                finish();

            }
        });

        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoom1.setClickable(true);
                zoom2.setClickable(true);
                zoom3.setClickable(true);
                zoom4.setClickable(true);
                zoomout.setVisibility(View.INVISIBLE);
                big1.setVisibility(View.INVISIBLE);
                big2.setVisibility(View.INVISIBLE);
                big3.setVisibility(View.INVISIBLE);
                big4.setVisibility(View.INVISIBLE);

                swipable = true;



            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr_ColicSlide12_New.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });

    }



    @Override
    public void onSwipe(int direction) {
        if(swipable) {
            switch (direction) {
                //swipe left to right
                case SimpleGestureFilter.SWIPE_RIGHT:
                    mp.stop();
                    swish.start();
                    Intent a = new Intent(Sbr_ColicSlide12_New.this, Sbr13_ActivityConsequencesOfInfantille.class);
                    startActivity(a);
                    finish();

                    break;


                //swipe right to left
                case SimpleGestureFilter.SWIPE_LEFT:
                    mp.stop();
                    swish.start();
                    Intent b = new Intent(Sbr_ColicSlide12_New.this, Sbr19_ActivityHowToUse.class);
                    startActivity(b);
                    finish();



                    break;
            }
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
