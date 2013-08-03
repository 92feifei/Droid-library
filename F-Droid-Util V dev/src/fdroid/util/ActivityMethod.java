package fdroid.util;

import java.util.Date;

import android.app.ProgressDialog;
import android.content.Context;
//Activity Function
//super.onCreate(savedInstanceState);AF.init(this, debug);

public class ActivityMethod {

	public static boolean debug;
	public static Context act_ctx;
	public static String act_class_name;
	public static long app_started_time = new Date().getTime();
	public static ProgressDialog LoadingDialog;
	private static final ActivityMethod af = new ActivityMethod();

	// avoid perfix AF are used and init
	// AF af = AF.getInstance(this, debug);
	// LogUtil L = LogUtil.getInstance();
	public static ActivityMethod getInstance(Context act_ctx, boolean debug) {
		ActivityMethod.debug = debug;
		ActivityMethod.act_ctx = act_ctx;
		act_class_name = act_ctx.getClass().getSimpleName();
		return af;
	}

	// get time diff between app launched and now
	public static long howlong() {
		return (new Date().getTime() - app_started_time);
	}

	public void Loading_show(String title, String content) {
		LoadingDialog = ProgressDialog.show(act_ctx, title, content);
	}// loading

	public void Loading_hide() {
		LoadingDialog.dismiss();
	}// loading
	
	
	

}