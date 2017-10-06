package com.example.flotera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {


    ImageView baby,btn_our_strain, btn_colic, btn_other_fgid, btn_mechanism, btn_product_spec, btn_clinical_trial, btn_references, btn_biogiai;
//github
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbr01_activity_main);

        casting();
        function();
        babycrawling();
    }

    public void casting(){
        baby = (ImageView)findViewById(R.id.baby) ;
        btn_our_strain = (ImageView)findViewById(R.id.btn_our_strain) ;
        btn_colic = (ImageView)findViewById(R.id.btn_colic) ;
        btn_other_fgid = (ImageView)findViewById(R.id.btn_other_fgid) ;
        btn_mechanism = (ImageView)findViewById(R.id.btn_mechanism) ;
        btn_product_spec = (ImageView)findViewById(R.id.btn_product_spec) ;
        btn_clinical_trial = (ImageView)findViewById(R.id.btn_clinical_trial) ;
        btn_references = (ImageView)findViewById(R.id.btn_references) ;
        btn_biogiai = (ImageView)findViewById(R.id.btn_biogiai) ;

    }

    public void function(){
        btn_our_strain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr02_ActivityOurStrain.class);
                startActivity(a);
                finish();
            }
        });
        btn_colic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr10_ActivityClinicallyProvenProbiotic.class);
                startActivity(a);
                finish();
            }
        });
        btn_other_fgid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr20_ActivityOtherFgid.class);
                startActivity(a);
                finish();
            }
        });
        btn_mechanism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr05_ActivityMechanismAction.class);
                startActivity(a);
                finish();
            }
        });
        btn_product_spec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr03_ActivityProductSpecification1.class);
                startActivity(a);
                finish();
            }
        });
        btn_clinical_trial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr04_ActivityClinicalTrial1.class);
                startActivity(a);
                finish();
            }
        });
        btn_references.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr32_ActivityReferences.class);
                startActivity(a);
                finish();
            }
        });
        btn_biogiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Sbr33_ActivityBiogiai.class);
                startActivity(a);
                finish();
            }
        });


    }
    public void babycrawling() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                baby.setBackgroundResource(R.drawable.baby_animationlist);
                AnimationDrawable frameAnimation = (AnimationDrawable) baby
                        .getBackground();
                frameAnimation.start();
                baby.setVisibility(View.VISIBLE);

            }
        }, 200);
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub3


        super.onBackPressed();
        final Intent relaunch = new Intent(this, Exiter.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(relaunch);
    }

}