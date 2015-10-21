package stetho.five.stethodemo.application;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.util.Random;

import stetho.five.stethodemo.business.dao.DemoDao;
import stetho.five.stethodemo.business.dao.DemoDaoImpl;

public final class Injector {

    private static Injector injectorInstance;

    private final Context applicationContext;

    private final OkHttpClient okHttpClient;
    private final Random random;
    private final DemoDao demoDao;

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
}
