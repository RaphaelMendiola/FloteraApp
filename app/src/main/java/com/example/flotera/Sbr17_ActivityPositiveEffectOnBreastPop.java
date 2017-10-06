package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Sbr17_ActivityPositiveEffectOnBreastPop extends Activity{



    ImageView btn_home;
    RelativeLayout popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr17_activity_positive_effect_on_breast_pop);


        casting();
        function();

    }

    public void casting(){
        btn_home = (ImageView) findViewById(R.id.btn_home);
        popup = (RelativeLayout) findViewById(R.id.popup);

    }

    public void function(){

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr17_ActivityPositiveEffectOnBreastPop.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sbr17_ActivityPositiveEffectOnBreastPop.this, Sbr_ColicSlide12_New.class);
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
