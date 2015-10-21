package stetho.five.stethodemo.application;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.squareup.okhttp.OkHttpClient;

import stetho.five.stethodemo.business.dao.model.Variable;

public final class StethoDemoApplication extends Application {

    Injector injector = Injector.getInstance(this);

    @Override
    public void onCreate() {
        super.onCreate();
        initializeStetho(this);
        populateDb(this);
    }

    private void initializeStetho(final Context context) {

        Stetho.initialize(Stetho.newInitializerBuilder(context)
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                        .enableDumpapp(injector.getDemoDumperPluginsProvider())
                        .build()
        );

        OkHttpClient client = injector.getOkHttpClient();
        client.networkInterceptors().add(new StethoInterceptor());
    }

    private void populateDb(final Context context) {
        FlowManager.init(context);
        Delete.table(Variable.class);
        createVariable("foo");
        createVariable("bar");
        createVariable("wibble");
        createVariable("wobble");
    }

    private void createVariable(String name) {
        Variable var = new Variable();
        var.setName(name);
        var.setValue(injector.getRandom().nextInt(100));
        var.setRandomValue(injector.getRandom().nextInt());
        var.update();
    }
}
