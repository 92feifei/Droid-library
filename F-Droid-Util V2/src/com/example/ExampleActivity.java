package com.example;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.service.textservice.SpellCheckerService.Session;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import fdroid.util.ActivityMethod;
import fdroid.util.LogUtil;
import fdroid.util.SharedSetting;

@SuppressLint("ShowToast")
public class ExampleActivity extends Activity {

	LinearLayout mainlayout;
	OnClickListener header_click;
	Session session;
	boolean debug = true;
	static LogUtil L;
	static SharedSetting set;
	static ActivityMethod af;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exampleactivity);

		af = ActivityMethod.getInstance(this, debug);// you must add this before
														// using fdroid util
		L = LogUtil.getInstance();
		set = SharedSetting.getInstance();
		findViewById(R.id.loading_btn).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						activity_loading_example();
					}
				});

		findViewById(R.id.logcat_btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				log_util_example();
			}
		});
		findViewById(R.id.setting_btn).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						shared_setting_example();
					}
				});

	}

	public void activity_loading_example() {
		af.Loading_show(
				"This is title",
				"This is content \n activitymethod.Loading_show(String title,String content); \nLoading_hide()");
		new Thread() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				af.Loading_hide();
			}
		}.start();

	}

	public void shared_setting_example() {
		set.setCommitWhenEditorChanged(true);
		L.v("set.putString(hello, world)");
		set.putString("hello", "world");
		L.v("set.getString(hello, nothing)");
		L.v(set.getString("hello", "nothing"));
		Toast.makeText(this, "See logcat", 5000).show();
	}

	public void log_util_example() {

		try {
			@SuppressWarnings("unused")
			JSONObject json = new JSONObject("worng message");
		} catch (Throwable e) {
			L.e("here's a json error");
			L.e(e);
		}

		Toast.makeText(this, "See logcat", 5000).show();
	}

}
