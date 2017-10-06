package com.example.flotera;

//import com.unilab.ul_alendra.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class S_1st_SplashActivity extends Activity {

	Context context;
	Handler handler;
	Animation l_animate_flare,l_animate_tail;
	ImageView l_img_flare,l_img_tail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_0);
		
		context = this;
		l_img_flare=(ImageView)findViewById(R.id.img_flare);
		l_img_tail=(ImageView)findViewById(R.id.img_tail_cover);
		
		//set animation
		l_animate_flare = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.translate_to_right);
		l_animate_tail = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.translate_to_right2);
		//flare animation
		l_img_flare.startAnimation(l_animate_flare);
		l_img_tail.startAnimation(l_animate_tail);
		handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent in = new Intent(context, MainActivity.class);
				startActivity(in);
				finish();
			}
		}, 2550);

	}
	private void finishAndHide() {
		// We don't call finish() explicitly. FLAG_ACTIVITY_CLEAR_TASK should
		// take care of it.

		// Replace the current task with one that is excluded from the recent
		// apps and that will finish itself immediately. It's critical that this
		// activity get launched in the task that you want to hide.
		final Intent relaunch = new Intent(this, Exiter.class)
				.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK // CLEAR_TASK requires this
						| Intent.FLAG_ACTIVITY_CLEAR_TASK // finish everything else in the task
						| Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); // hide (remove, in this case) task from recents
		startActivity(relaunch);
	}
	

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

		finishAndHide();
		}
}
