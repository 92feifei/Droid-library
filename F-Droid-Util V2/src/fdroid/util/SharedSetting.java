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
	public static boolean commit_when_editor_changed = false;
	public static boolean apply_when_editor_changed = false;
	private static final SharedSetting sharedsetting = new SharedSetting();

	public static SharedSetting getInstance() {
		settings = PreferenceManager
				.getDefaultSharedPreferences(ActivityMethod.act_ctx);
		editor = settings.edit();
		return sharedsetting;
	}

	public  void setCommitWhenEditorChanged(boolean commit_when_editor_changed) {
		SharedSetting.commit_when_editor_changed = commit_when_editor_changed;
	}

	public  void setApplyWhenEditorChanged(boolean apply_when_editor_changed) {
		SharedSetting.apply_when_editor_changed = apply_when_editor_changed;
	}

	private static void after_editor_changed() {
		if (commit_when_editor_changed) {
			editor.commit();
		}
		if (apply_when_editor_changed) {
			editor.apply();
		}
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
		Editor new_editor = editor.putBoolean(key, value);
		after_editor_changed();
		return new_editor;
	}

	@Override
	public Editor putFloat(String key, float value) {
		Editor new_editor = editor.putFloat(key, value);
		after_editor_changed();
		return new_editor;
	}

	@Override
	public Editor putInt(String key, int value) {
		Editor new_editor = editor.putInt(key, value);
		after_editor_changed();
		return new_editor;
	}

	@Override
	public Editor putLong(String key, long value) {
		Editor new_editor = editor.putLong(key, value);
		after_editor_changed();
		return new_editor;
	}

	@Override
	public Editor putString(String key, String value) {
		Editor new_editor = editor.putString(key, value);
		after_editor_changed();
		return new_editor;
	}

	@Override
	public Editor putStringSet(String key, Set<String> value) {
		Editor new_editor = editor.putStringSet(key, value);
		after_editor_changed();
		return new_editor;
	}

	@Override
	public Editor remove(String key) {
		Editor new_editor = editor.remove(key);
		after_editor_changed();
		return new_editor;
	}

}