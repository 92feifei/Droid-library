package fdroid.util;

import java.util.Map;
import java.util.Set;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedSetting implements SharedPreferences,
		SharedPreferences.Editor {

	// this combine SharedPreferences AND SharedPreferences.Editor
	public static SharedPreferences settings;
	public static SharedPreferences.Editor editor;
	private static final SharedSetting sharedsetting = new SharedSetting();

	public static SharedSetting getInstance() {
		settings = PreferenceManager
				.getDefaultSharedPreferences(ActivityMethod.act_ctx);
		editor = settings.edit();
		return sharedsetting;
	}

	@Override
	public boolean contains(String key) {
		return settings.contains(key);
	}

	// @deprecated use {getInstance()} instead.
	@Deprecated
	@Override
	public Editor edit() {
		return null;
	}

	@Override
	public Map<String, ?> getAll() {
		return settings.getAll();
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		return settings.getBoolean(key, defValue);
	}

	@Override
	public float getFloat(String key, float defValue) {
		return settings.getFloat(key, defValue);
	}

	@Override
	public int getInt(String key, int defValue) {
		return settings.getInt(key, defValue);
	}

	@Override
	public long getLong(String key, long defValue) {
		return settings.getLong(key, defValue);
	}

	@Override
	public String getString(String key, String defValue) {
		return settings.getString(key, defValue);
	}

	@Override
	public Set<String> getStringSet(String arg0, Set<String> arg1) {
		return settings.getStringSet(arg0, arg1);
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		settings.registerOnSharedPreferenceChangeListener(listener);
	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		settings.unregisterOnSharedPreferenceChangeListener(listener);
	}

	@Override
	public void apply() {
		editor.apply();
	}

	@Override
	public Editor clear() {
		return editor.clear();
	}

	@Override
	public boolean commit() {
		return editor.commit();
	}

	@Override
	public Editor putBoolean(String key, boolean value) {
		return editor.putBoolean(key, value);
	}

	@Override
	public Editor putFloat(String key, float value) {
		return editor.putFloat(key, value);
	}

	@Override
	public Editor putInt(String key, int value) {
		return editor.putInt(key, value);
	}

	@Override
	public Editor putLong(String key, long value) {
		return editor.putLong(key, value);
	}

	@Override
	public Editor putString(String key, String value) {
		return editor.putString(key, value);
	}

	@Override
	public Editor putStringSet(String arg0, Set<String> arg1) {
		return editor.putStringSet(arg0, arg1);
	}

	@Override
	public Editor remove(String key) {
		return editor.remove(key);
	}

}