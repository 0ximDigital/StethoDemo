package stetho.five.stethodemo.util;

import android.content.Context;
import android.content.SharedPreferences;

public final class PreferenceUtils {

    private static final String SHARED_PREFS = "shared_prefs";

    private static final String KEY_SHOW_TOAST = "show_toast";


    private final Context context;

    public PreferenceUtils(Context context) {
        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public boolean getShowToast(){
        return getSharedPreferences().getBoolean(KEY_SHOW_TOAST, true);
    }

    public void setShowToast(boolean showToast){
        getSharedPreferences().edit().putBoolean(KEY_SHOW_TOAST, showToast).apply();
    }

}
