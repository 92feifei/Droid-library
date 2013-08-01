package com.tool;

import android.util.Log;

//Activity Function
public class LogUtil {

	private static final LogUtil l = new LogUtil();
	private static String thisclassname;

	// avoid perfix L are used and init
	// AF.init(this, debug);LogUtil L = LogUtil.getInstance();
	public static LogUtil getInstance() {
		thisclassname = LogUtil.class.getName();
		return l;
	}

	// print current method and timestamp, example :
	// AF.v("inited") ->
	// LogCat:tag->[activity class name],Text->onCreate inited
	public void v(String s) {
		if (AF.debug) {
			Log.v(get_tag(), getMethodName() + " " + s);
		}
	}

	public void v(Throwable tr) {
		if (AF.debug) {
			Log.v(get_tag(), getMethodName(), tr);
		}
	}

	public void v() {
		if (AF.debug) {
			Log.v(get_tag(), getMethodName());
		}
	}

	public void d(String s) {
		if (AF.debug) {
			Log.d(get_tag(), getMethodName() + " " + s);
		}
	}

	public void d(Throwable tr) {
		if (AF.debug) {
			Log.d(get_tag(), getMethodName(), tr);
		}
	}

	public void d() {
		if (AF.debug) {
			Log.d(get_tag(), getMethodName());
		}
	}

	public void i(String s) {
		if (AF.debug) {
			Log.i(get_tag(), getMethodName() + " " + s);
		}
	}

	public void i(Throwable tr) {
		if (AF.debug) {
			Log.i(get_tag(), getMethodName(), tr);
		}
	}

	public void i() {
		if (AF.debug) {
			Log.i(get_tag(), getMethodName());
		}
	}

	public void w(String s) {
		if (AF.debug) {
			Log.w(get_tag(), getMethodName() + " " + s);
		}
	}

	public void w(Throwable tr) {
		if (AF.debug) {
			Log.w(get_tag(), getMethodName(), tr);
		}
	}

	public void w() {
		if (AF.debug) {
			Log.w(get_tag(), getMethodName());
		}
	}

	private static String get_tag() {
		return AF.act_class_name + " " + addspace(AF.howlong() + " ", 8);
	}

	private static String getMethodName() {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		int i;
		for (i = 2; i < trace.length; i++) {
			StackTraceElement t = trace[i];
			if (!t.getClassName().equals(thisclassname)) {
				break;
			}
		}
		return addspace(trace[i].getMethodName(), 15);
	}

	// add space in string
	// addspace("hello",6) = "hello "
	private static String addspace(String s, int len) {
		String j = "";
		for (int j2 = 0; j2 < len - s.length(); j2++) {
			j = j + ' ';
		}
		return s + j;
	}// addspace

}