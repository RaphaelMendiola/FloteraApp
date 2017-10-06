package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Sbr23_ActivityImproveGastricPop extends Activity{


//    LinearLayout zoomin,zoomout;
    ImageView btn_home;
    RelativeLayout popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr23_activity_improve_gastric_pop);



        casting();
        function();

    }

    public void casting(){
//        zoomin = (LinearLayout) findViewById(R.id.zoomin);
//        zoomout = (LinearLayout) findViewById(R.id.zoomout);
        btn_home = (ImageView) findViewById(R.id.btn_home);
        popup = (RelativeLayout) findViewById(R.id.popup);
    }

    public void function(){
//        zoomin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              zoomin.setClickable(false);
//              zoomout.setVisibility(View.VISIBLE);
//            }
//        });
//        zoomout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                zoomin.setClickable(true);
//                zoomout.setVisibility(View.INVISIBLE);
//            }
//        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr23_ActivityImproveGastricPop.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr23_ActivityImproveGastricPop.this, NewRegulatory.class);
                startActivity(a);
                finish();
            }
        });
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
