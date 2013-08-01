package com.fb;

import java.security.MessageDigest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.tool.AF;

abstract public class Fb {
	public static Session session;
	public static GraphUser user;
	public static Runnable logined_cb;
	public static boolean is_logined = false;
	public static Response login_response;
	static boolean log_response = false;

	public static final String search_type_user = "user";
	public static final String search_type_post = "post";
	public static final String search_type_page = "page";
	public static final String search_type_event = "event";
	public static final String search_type_place = "place";

	public static void init(boolean login_loading, Runnable login_callback) {
		if (is_logined) {
			if (login_callback != null) {
				login_callback.run();
			}
		} else {
			Log.i("facebook", "key_hash=" + get_key_hash());
			login(login_loading, login_callback);
		}
	}

	static void set_log_response(boolean log_response) {
		Fb.log_response = log_response;
	}

	static void login(boolean loading, final Runnable login_callback) {
		AF.Loading(loading);
		// start Facebook Login
		Session.openActiveSession((Activity) AF.act_ctx, true,
				new Session.StatusCallback() {
					// callback when session changes state
					@Override
					public void call(Session session, SessionState state,
							Exception exception) {
						Fb.session = session;
						if (session.isOpened()) {
							// make request to the /me API
							Request.executeMeRequestAsync(session,
									new Request.GraphUserCallback() {
										@Override
										public void onCompleted(GraphUser user,
												Response login_response) {
											AF.Loading(false);
											Fb.login_response = login_response;
											if (user != null) {
												if (login_response.getError() == null) {
													if (user != null) {
														set_logined(true, user);
													}
												} else {
													Log.i("Fb login failed",
															login_response
																	.toString());
												}
											}
											login_callback.run();
										}
									});
						}
					}
				});
	}

	public static void set_logined(boolean is_logined, GraphUser user) {
		Fb.is_logined = is_logined;
		Fb.user = user;
	}

	/*
	 * public static void set_is_login(boolean is_logined, GraphUser user,
	 * Session session) { if (is_logined()) { f.p("Facebook logined");
	 * f.p("access_token=" + session.getAccessToken()); Fb.user = user;
	 * Fb.session = session; if (logined_cb != null) { logined_cb.run(); } }
	 * else { user = null; } }
	 */

	@SuppressLint("NewApi")
	static String get_key_hash() {
		try {
			PackageInfo info = AF.act_ctx.getPackageManager().getPackageInfo(
					AF.act_ctx.getPackageName(), PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				return Base64.encodeToString(md.digest(), Base64.DEFAULT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void search(String type, String keyword,
			com.facebook.Request.Callback cb) {

		Bundle params = new Bundle();
		params.putString("type", type);
		params.putString("q", keyword);
		api("search", params, HttpMethod.GET, cb);
	}

	static void api(String graphPath, Bundle params, HttpMethod get_post_del,
			final com.facebook.Request.Callback request_cb) {

		com.facebook.Request.Callback cb = new com.facebook.Request.Callback() {
			@Override
			public void onCompleted(Response response) {
				if (response.getError() != null) {
					// Log.INFO("Facebook",response);
				} else {
					request_cb.onCompleted(response);
				}
			}
		};

		params.putString("access_token", session.getAccessToken());
		Request request = new Request(session, graphPath, params, get_post_del,
				cb);
		RequestAsyncTask task = new RequestAsyncTask(request);
		task.execute();

	}

}