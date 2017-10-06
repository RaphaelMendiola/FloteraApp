package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Sbr20_ActivityOtherFgid extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    ImageView btn_home,btn_reg,btn_fc,btn_big;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr20_activity_other_fgid);

        detector = new SimpleGestureFilter(this,this);

        casting();
        function();

    }

    public void casting(){

        btn_home = (ImageView) findViewById(R.id.btn_home);
        btn_reg = (ImageView) findViewById(R.id.btn_reg);
        btn_fc = (ImageView) findViewById(R.id.btn_fc);
        btn_big = (ImageView) findViewById(R.id.btn_big);
    }

    public void function(){

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr20_ActivityOtherFgid.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr20_ActivityOtherFgid.this, Sbr21_ActivityRegurgitation.class);
                startActivity(a);
                finish();
            }
        });
        btn_fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr20_ActivityOtherFgid.this, Sbr27_ActivityClicallyProven.class);
                startActivity(a);
                finish();
            }
        });
        btn_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent a = new Intent(Sbr20_ActivityOtherFgid.this, MainActivity.class);
//                startActivity(a);
//                finish();
            }
        });
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
