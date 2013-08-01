package com.tool;

import java.util.Date;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
//Activity Function
public class AF {

	public static SharedPreferences settings;
	public static SharedPreferences.Editor editor;
	public static boolean debug;
	public static Context act_ctx;
	public static String act_class_name;
	public static long starttime = new Date().getTime();
	public static ProgressDialog LoadingDialog;
	//super.onCreate(savedInstanceState);AF.init(this, debug);
	public static void init(Context act_ctx, boolean debug) {
		AF.debug = debug;
		AF.act_ctx = act_ctx;
		act_class_name = act_ctx.getClass().getSimpleName();
	}
	public static void init(Context act_ctx) {
		AF.act_ctx = act_ctx;
		act_class_name = act_ctx.getClass().getSimpleName();
	}

	// put setting string
	public static void PSS(int key, String value) {
		editor.putString(GAS(key), value);
		editor.commit();
	}

	// put setting string
	public static void PSS(String key, String value) {
		editor.putString(key, value);
		editor.commit();
	}

	// get setting string
	public static String GSS(int key, String defvalue) {
		return settings.getString(GAS(key), defvalue);
	}

	// get setting string
	public static String GSS(String key, String defvalue) {
		return settings.getString(key, defvalue);
	}

	// put setting int
	public static void PSI(int key, int value) {
		editor.putInt(GAS(key), value);
		editor.commit();
	}

	// put setting int
	public static void PSI(String key, int value) {
		editor.putInt(key, value);
		editor.commit();
	}

	// get setting boolean
	public static boolean GSB(int key, boolean defvalue) {
		return settings.getBoolean(GAS(key), defvalue);
	}

	// get setting boolean
	public static boolean GSB(String key, boolean defvalue) {
		return settings.getBoolean(key, defvalue);
	}

	// put setting boolean
	public static void PSB(int key, boolean value) {
		editor.putBoolean(GAS(key), value);
		editor.commit();
	}

	// put setting boolean
	public static void PSB(String key, boolean value) {
		editor.putBoolean(key, value);
		editor.commit();
	}

	// get setting int
	public static int GSI(int key, int defvalue) {
		return settings.getInt(GAS(key), defvalue);
	}

	// get setting int
	public static int GSI(String key, int defvalue) {
		return settings.getInt(key, defvalue);
	}

	// get Act int
	public static int GAI(int key) {
		return Integer.parseInt(GAS(key));
	}

	// get Act String
	public static String GAS(int key) {
		return act_ctx.getString(key);
	}

	// Make a toast
	public static void t(String s, int time) {
		Toast.makeText(act_ctx, s + "", time).show();
	}

	//get time diff between app launched and now
	public static long howlong() {
		return (new Date().getTime() - starttime);
	}

	public static void Loading(Boolean show_hide) {
		if (show_hide) {
			LoadingDialog = ProgressDialog.show(act_ctx, "In progress",
					"Loading...");
		} else {
			LoadingDialog.dismiss();
		}
	}// loading

}