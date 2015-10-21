package stetho.five.stethodemo.application;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.util.Random;

import stetho.five.stethodemo.application.dumpapp.DemoDumperPluginsProvider;
import stetho.five.stethodemo.business.dao.DemoDao;
import stetho.five.stethodemo.business.dao.DemoDaoImpl;
import stetho.five.stethodemo.util.PreferenceUtils;

public final class Injector {

    private static Injector injectorInstance;

    private final Context applicationContext;

    private final OkHttpClient okHttpClient;
    private final Random random;
    private final DemoDao demoDao;
    private final PreferenceUtils preferenceUtils;
    private final DemoDumperPluginsProvider demoDumperPluginsProvider;

    public static Injector getInstance(Context context) {
        if (injectorInstance == null) {
            injectorInstance = new Injector(context);
        }
        return injectorInstance;
    }

    private Injector(Context applicationContext) {
        this.applicationContext = applicationContext;
        this.okHttpClient = new OkHttpClient();
        this.random = new Random();
        this.demoDao = new DemoDaoImpl();
        this.preferenceUtils = new PreferenceUtils(applicationContext);
        this.demoDumperPluginsProvider = new DemoDumperPluginsProvider(applicationContext);
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Random getRandom() {
        return random;
    }

    public DemoDao getDemoDao() {
        return demoDao;
    }

    public PreferenceUtils getPreferenceUtils() {
        return preferenceUtils;
    }

    public DemoDumperPluginsProvider getDemoDumperPluginsProvider() {
        return demoDumperPluginsProvider;
    }
}
