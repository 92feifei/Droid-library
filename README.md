Why f-Droid-Util ?

	1.Humanization Some java method like 
		"system.out.println"|"Log.v"(replace by l.v(String only_one_param))
	2.Simplify some common functions like
		Loading_show(String title, String content)
		Loading_hide()

How to use ?

1.Right click project "f-Droid-Util" -> properties -> android -> check "is library"
2.Right click your project 			 -> properties -> android -> add "f-Droid-Util"

Example:
	super.onCreate(savedInstanceState);
	setContentView(R.layout.exampleactivity);
	ActivityMethod af = ActivityMethod.getInstance(this, debug);// you must add this before using this util
	LogUtil L = LogUtil.getInstance();
	SharedSetting set = SharedSetting.getInstance();



Method : 
	ActivityMethod : 
		Loading_show(String title, String content); //show loading dialog
		Loading_hide(); //hide loading dialog
	LogUtil : 
		v(String s);
		v(Throwable tr);
		v()
		method v/d/e/i/w  do the same thing but different log level
	SharedSetting : 
		use it like 
		SharedPreferences settings 
		and
		SharedPreferences.Editor editor
		
		
Future : 
